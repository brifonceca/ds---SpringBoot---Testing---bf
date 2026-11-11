package etec.backend.service

import etec.backend.dto.EstudiantesRequest
import etec.backend.dto.EstudianteResponse
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
    fun listar(pageable: Pageable): Page<EstudianteResponse> {
        return estudiantesRepository.findAll(pageable)
            .map { EstudianteResponse.fromEntity(it) }
    }

    @Transactional(readOnly = true)
    fun obtener(id: Int): EstudianteResponse {
        val estudiante = estudiantesRepository.findById(id)
            .orElseThrow { EstudianteNoEncontradoException(id) }
        return EstudianteResponse.fromEntity(estudiante)
    }

    @Transactional
    fun crear(req: EstudiantesRequest): EstudianteResponse {
        val nuevoEstudiante = Estudiante(
            nombre = req.nombre
        )
        val guardado = estudiantesRepository.save(nuevoEstudiante)
        return EstudianteResponse.fromEntity(guardado)
    }
}