package etec.backend.service

import etec.backend.dto.AlumnosRequest
import etec.backend.dto.AlumnosResponse
import etec.backend.entity.Alumno
import etec.backend.exception.AlumnoNoEncontradoException
import etec.backend.exception.CursoNoEncontradoException
import etec.backend.repository.AlumnosRepository
import etec.backend.repository.CursosRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AlumnosService(
    private val alumnosRepository: AlumnosRepository,
    private val cursosRepository: CursosRepository
) {
    @Transactional(readOnly = true)
    fun listar(pageable: Pageable): Page<AlumnosResponse> {
        return alumnosRepository.findAll(pageable)
            .map { AlumnosResponse.fromEntity(it) }
    }

    @Transactional(readOnly = true)
    fun obtener(id: Int): AlumnosResponse {
        val alumno = alumnosRepository.findById(id)
            .orElseThrow { AlumnoNoEncontradoException(id) }
        return AlumnosResponse.fromEntity(alumno)
    }

    @Transactional
    fun crear(req: AlumnosRequest): AlumnosResponse {
        val curso = cursosRepository.findById(req.cursoId)
            .orElseThrow { CursoNoEncontradoException(req.cursoId) }

        val nuevoAlumno = Alumno(
            nombre = req.nombre,
            curso = curso
        )
        val guardado = alumnosRepository.save(nuevoAlumno)
        return AlumnosResponse.fromEntity(guardado)
    }
}