package etec.backend.dto

import etec.backend.entity.Alumno

data class AlumnosResponse(
    val id: Int,
    val nombre: String,
    val cursoNombre: String
) {
    companion object {
        fun fromEntity(a: Alumno): AlumnosResponse =
            AlumnosResponse(
                id = a.id ?: 0,
                nombre = a.nombre,
                cursoNombre = a.curso?.nombre ?: "Sin curso"
            )
    }
}