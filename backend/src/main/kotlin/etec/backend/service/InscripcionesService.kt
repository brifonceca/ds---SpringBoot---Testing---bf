package etec.backend.service

import etec.backend.dto.InscripcionesRequest
import etec.backend.dto.InscripcionResponse
import etec.backend.entity.Inscripcion
import etec.backend.exception.InscripcionNoEncontradoException
import etec.backend.exception.EstudianteNoEncontradoException
import etec.backend.exception.CursoNoEncontradoException
import etec.backend.repository.InscripcionesRepository
import etec.backend.repository.EstudiantesRepository
import etec.backend.repository.CursosRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InscripcionesService(
    private val inscripcionesRepository: InscripcionesRepository,
    private val estudiantesRepository: EstudiantesRepository,
    private val cursosRepository: CursosRepository
) {
    @Transactional(readOnly = true)
    fun listar(pageable: Pageable): Page<InscripcionResponse> {
        return inscripcionesRepository.findAll(pageable)
            .map { InscripcionResponse.fromEntity(it) }
    }

    @Transactional(readOnly = true)
    fun obtener(id: Int): InscripcionResponse {
        val inscripcion = inscripcionesRepository.findById(id)
            .orElseThrow { InscripcionNoEncontradoException(id) }
        return InscripcionResponse.fromEntity(inscripcion)
    }

    @Transactional
    fun crear(req: InscripcionesRequest): InscripcionResponse {
        val estudiante = estudiantesRepository.findById(req.estudianteId)
            .orElseThrow { EstudianteNoEncontradoException(req.estudianteId) }

        val curso = cursosRepository.findById(req.cursoId)
            .orElseThrow { CursoNoEncontradoException(req.cursoId) }

        val nuevaInscripcion = Inscripcion(
            estudiante = estudiante,
            curso = curso
        )
        val guardado = inscripcionesRepository.save(nuevaInscripcion)
        return InscripcionResponse.fromEntity(guardado)
    }
}