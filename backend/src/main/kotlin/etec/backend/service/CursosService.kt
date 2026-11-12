package etec.backend.service

import etec.backend.dto.CursosRequest
import etec.backend.dto.CursosResponse
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
    fun listar(pageable: Pageable): Page<CursosResponse> {
        return cursosRepository.findAll(pageable)
            .map { CursosResponse.fromEntity(it) }
    }

    @Transactional(readOnly = true)
    fun obtener(id: Int): CursosResponse {
        val curso = cursosRepository.findById(id)
            .orElseThrow { CursoNoEncontradoException(id) }
        return CursosResponse.fromEntity(curso)
    }

    @Transactional
    fun crear(req: CursosRequest): CursosResponse {
        val ano = anosRepository.findById(req.anoId)
            .orElseThrow { AnoNoEncontradoException(req.anoId) }

        val nuevoCurso = Curso(
            nombre = req.nombre,
            ano = ano
        )
        val guardado = cursosRepository.save(nuevoCurso)
        return CursosResponse.fromEntity(guardado)
    }
}