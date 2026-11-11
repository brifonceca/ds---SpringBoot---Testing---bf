package etec.backend.service

import etec.backend.dto.ConsignasRequest
import etec.backend.dto.ConsignaResponse
import etec.backend.entity.Consigna
import etec.backend.exception.ConsignaNoEncontradoException
import etec.backend.exception.CursoNoEncontradoException
import etec.backend.repository.ConsignasRepository
import etec.backend.repository.CursosRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ConsignasService(
    private val consignasRepository: ConsignasRepository,
    private val cursosRepository: CursosRepository
) {
    @Transactional(readOnly = true)
    fun listar(pageable: Pageable): Page<ConsignaResponse> {
        return consignasRepository.findAll(pageable)
            .map { ConsignaResponse.fromEntity(it) }
    }

    @Transactional(readOnly = true)
    fun obtener(id: Int): ConsignaResponse {
        val consigna = consignasRepository.findById(id)
            .orElseThrow { ConsignaNoEncontradoException(id) }
        return ConsignaResponse.fromEntity(consigna)
    }

    @Transactional
    fun crear(req: ConsignasRequest): ConsignaResponse {
        val curso = cursosRepository.findById(req.cursoId)
            .orElseThrow { CursoNoEncontradoException(req.cursoId) }

        val nuevaConsigna = Consigna(
            titulo = req.titulo,
            descripcion = req.descripcion,
            curso = curso
        )
        val guardado = consignasRepository.save(nuevaConsigna)
        return ConsignaResponse.fromEntity(guardado)
    }
}