package etec.bdd.service

import etec.bdd.dto.CursosRequest
import etec.bdd.dto.CursosResponse
import etec.bdd.entity.Curso
import etec.bdd.exception.CursoNoEncontradoException
import etec.bdd.repository.CursosRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CursosService(
    private val cursosRepository: CursosRepository
) {
    @Transactional(readOnly = true)
    fun listar(pageable: Pageable): Page<CursosResponse> {
        return cursosRepository.findAll(pageable)
            .map { CursosResponse.fromEntity(it) }
    }

    @Transactional(readOnly = true)
    fun obtener(id: Long): CursosResponse {
        val curso = cursosRepository.findById(id)
            .orElseThrow { CursoNoEncontradoException(id) }
        return CursosResponse.fromEntity(curso)
    }

    @Transactional
    fun crear(req: CursosRequest): CursosResponse {
        val nuevoCurso = Curso(
            nombre = req.nombre
        )
        val guardado = cursosRepository.save(nuevoCurso)
        return CursosResponse.fromEntity(guardado)
    }
}