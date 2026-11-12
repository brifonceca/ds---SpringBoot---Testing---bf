package etec.backend.dto

import etec.backend.entity.Estudiante

data class EstudiantesResponse(
    val id: Int,
    val nombre: String
) {
    companion object {
        fun fromEntity(e: Estudiante): EstudiantesResponse =
            EstudiantesResponse(
                id = e.id ?: 0,
                nombre = e.nombre
            )
    }
}