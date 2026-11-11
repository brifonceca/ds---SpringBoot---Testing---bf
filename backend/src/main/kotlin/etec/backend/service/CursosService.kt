package etec.backend.service

import etec.backend.dto.CursosRequest
import etec.backend.dto.CursoResponse
import etec.backend.entity.Curso
import etec.backend.exception.CursoNoEncontradoException
import etec.backend.exception.AnoNoEncontradoException
import etec.backend.repository.CursosRepository
import etec.backend.repository.AnosRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CursosService(
    private val cursosRepository: CursosRepository,
    private val anosRepository: AnosRepository
) {
    @Transactional(readOnly = true)
    fun listar(pageable: Pageable): Page<CursoResponse> {
        return cursosRepository.findAll(pageable)
            .map { CursoResponse.fromEntity(it) }
    }

    @Transactional(readOnly = true)
    fun obtener(id: Int): CursoResponse {
        val curso = cursosRepository.findById(id)
            .orElseThrow { CursoNoEncontradoException(id) }
        return CursoResponse.fromEntity(curso)
    }

    @Transactional
    fun crear(req: CursosRequest): CursoResponse {
        val ano = anosRepository.findById(req.anoId)
            .orElseThrow { AnoNoEncontradoException(req.anoId) }

        val nuevoCurso = Curso(
            nombre = req.nombre,
            ano = ano
        )
        val guardado = cursosRepository.save(nuevoCurso)
        return CursoResponse.fromEntity(guardado)
    }
}