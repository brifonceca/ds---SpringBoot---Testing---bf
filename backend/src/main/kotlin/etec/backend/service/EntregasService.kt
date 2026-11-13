package etec.backend.service

import etec.backend.dto.EntregasRequest
import etec.backend.dto.EntregasResponse
import etec.backend.entity.Entrega
import etec.backend.exception.EntregaNoEncontradoException
import etec.backend.exception.EstudianteNoEncontradoException
import etec.backend.exception.ConsignaNoEncontradoException
import etec.backend.repository.EntregasRepository
import etec.backend.repository.EstudiantesRepository
import etec.backend.repository.ConsignasRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EntregasService(
    private val entregasRepository: EntregasRepository,
    private val estudiantesRepository: EstudiantesRepository,
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
        val estudiante = estudiantesRepository.findById(req.estudianteId)
            .orElseThrow { EstudianteNoEncontradoException(req.estudianteId) }

        val consigna = consignasRepository.findById(req.consignaId)
            .orElseThrow { ConsignaNoEncontradoException(req.consignaId) }

        val nuevaEntrega = Entrega(
            nombre = req.nombre,
            codigoEnviado = req.codigoEnviado,
            estado = req.estado,
            estudiante = estudiante,
            consigna = consigna
        )
        val guardado = entregasRepository.save(nuevaEntrega)
        return EntregasResponse.fromEntity(guardado)
    }
}