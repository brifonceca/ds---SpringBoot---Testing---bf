package etec.backend.service

import etec.backend.dto.EntregasRequest
import etec.backend.dto.EntregasResponse
import etec.backend.entity.Entrega
import etec.backend.exception.AlumnoNoEncontradoException
import etec.backend.exception.ConsignaNoEncontradoException
import etec.backend.exception.EntregaNoEncontradoException
import etec.backend.repository.AlumnosRepository
import etec.backend.repository.ConsignasRepository
import etec.backend.repository.EntregasRepository
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