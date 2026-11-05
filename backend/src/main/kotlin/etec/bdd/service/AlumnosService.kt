package etec.bdd.service

import etec.bdd.dto.AlumnosRequest
import etec.bdd.dto.AlumnosResponse
import etec.bdd.entity.Alumno
import etec.bdd.exception.AlumnoNoEncontradoException
import etec.bdd.exception.CursoNoEncontradoException
import etec.bdd.repository.AlumnosRepository
import etec.bdd.repository.CursosRepository
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
    fun obtener(id: Long): AlumnosResponse {
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