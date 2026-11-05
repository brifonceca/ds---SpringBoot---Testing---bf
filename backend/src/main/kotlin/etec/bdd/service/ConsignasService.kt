package etec.bdd.service

import etec.bdd.dto.ConsignasRequest
import etec.bdd.dto.ConsignasResponse
import etec.bdd.entity.Consigna
import etec.bdd.exception.ConsignaNoEncontradoException
import etec.bdd.exception.CursoNoEncontradoException
import etec.bdd.repository.ConsignasRepository
import etec.bdd.repository.CursosRepository
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
    fun listar(pageable: Pageable): Page<ConsignasResponse> {
        return consignasRepository.findAll(pageable)
            .map { ConsignasResponse.fromEntity(it) }
    }

    @Transactional(readOnly = true)
    fun obtener(id: Long): ConsignasResponse {
        val consigna = consignasRepository.findById(id)
            .orElseThrow { ConsignaNoEncontradoException(id) }
        return ConsignasResponse.fromEntity(consigna)
    }

    @Transactional
    fun crear(req: ConsignasRequest): ConsignasResponse {
        val curso = cursosRepository.findById(req.cursoId)
            .orElseThrow { CursoNoEncontradoException(req.cursoId) }

        val nuevaConsigna = Consigna(
            titulo = req.titulo,
            descripcion = req.descripcion,
            curso = curso
        )
        val guardado = consignasRepository.save(nuevaConsigna)
        return ConsignasResponse.fromEntity(guardado)
    }
}