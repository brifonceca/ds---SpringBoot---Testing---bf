package etec.backend.dto

import etec.backend.entity.Estudiante

data class EstudianteResponse(
    val id: Int,
    val nombre: String
) {
    companion object {
        fun fromEntity(e: Estudiante): EstudianteResponse =
            EstudianteResponse(
                id = e.id ?: 0,
                nombre = e.nombre
            )
    }
}