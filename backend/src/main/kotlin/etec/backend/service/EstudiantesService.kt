package etec.backend.service

import etec.backend.dto.EstudiantesRequests
import etec.backend.dto.EstudiantesResponse
import etec.backend.entity.Estudiante
import etec.backend.exception.EstudianteNoEncontradoException
import etec.backend.repository.EstudiantesRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EstudiantesService(
    private val estudiantesRepository: EstudiantesRepository
) {
    @Transactional(readOnly = true)
    fun listar(pageable: Pageable): Page<EstudiantesResponse> {
        return estudiantesRepository.findAll(pageable)
            .map { EstudiantesResponse.fromEntity(it) }
    }

    @Transactional(readOnly = true)
    fun obtener(id: Int): EstudiantesResponse {
        val estudiante = estudiantesRepository.findById(id)
            .orElseThrow { EstudianteNoEncontradoException(id) }
        return EstudiantesResponse.fromEntity(estudiante)
    }

    @Transactional
    fun crear(req: EstudiantesRequests): EstudiantesResponse {
        val nuevoEstudiante = Estudiante(
            nombre = req.nombre
        )
        val guardado = estudiantesRepository.save(nuevoEstudiante)
        return EstudiantesResponse.fromEntity(guardado)
    }
}