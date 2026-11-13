package etec.backend.dto

import etec.backend.entity.Estudiante

data class EstudiantesResponse(
    val id: Long,
    val nombre: String
) {
    companion object {
        fun fromEntity(e: Estudiante): EstudiantesResponse =
            EstudiantesResponse(
                id = e.id ?: 0L,
                nombre = e.nombre
            )
    }
}