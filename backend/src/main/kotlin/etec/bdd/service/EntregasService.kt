package etec.bdd.service

import etec.bdd.dto.EntregasRequest
import etec.bdd.dto.EntregasResponse
import etec.bdd.entity.Entrega
import etec.bdd.exception.AlumnoNoEncontradoException
import etec.bdd.exception.ConsignaNoEncontradoException
import etec.bdd.exception.EntregaNoEncontradoException
import etec.bdd.repository.AlumnosRepository
import etec.bdd.repository.ConsignasRepository
import etec.bdd.repository.EntregasRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EntregasService(
    private val entregasRepository: EntregasRepository,
    private val alumnosRepository: AlumnosRepository,
    private val consignasRepository: ConsignasRepository
) {
    @Transactional(readOnly = true)
    fun listar(pageable: Pageable): Page<EntregasResponse> {
        return entregasRepository.findAll(pageable)
            .map { EntregasResponse.fromEntity(it) }
    }

    @Transactional(readOnly = true)
    fun obtener(id: Long): EntregasResponse {
        val entrega = entregasRepository.findById(id)
            .orElseThrow { EntregaNoEncontradoException(id) }
        return EntregasResponse.fromEntity(entrega)
    }

    @Transactional
    fun crear(req: EntregasRequest): EntregasResponse {
        val alumno = alumnosRepository.findById(req.alumnoId)
            .orElseThrow { AlumnoNoEncontradoException(req.alumnoId) }

        val consigna = consignasRepository.findById(req.consignaId)
            .orElseThrow { ConsignaNoEncontradoException(req.consignaId) }

        val nuevaEntrega = Entrega(
            nombre = req.nombre,
            codigoEnviado = req.codigoEnviado,
            estado = req.estado,
            alumno = alumno,
            consigna = consigna
        )
        val guardado = entregasRepository.save(nuevaEntrega)
        return EntregasResponse.fromEntity(guardado)
    }
}