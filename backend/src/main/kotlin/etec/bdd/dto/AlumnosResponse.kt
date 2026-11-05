package etec.bdd.dto

import etec.bdd.entity.Alumno

data class AlumnosResponse(
    val id: Long,
    val nombre: String,
    val cursoNombre: String
) {
    companion object {
        fun fromEntity(a: Alumno): AlumnosResponse =
            AlumnosResponse(
                id = a.id ?: 0L,
                nombre = a.nombre,
                cursoNombre = a.curso?.nombre ?: "Sin curso"
            )
    }
}