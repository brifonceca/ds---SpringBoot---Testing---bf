package etec.backend.dto

import etec.backend.entity.Inscripcion

data class InscripcionResponse(
    val id: Int,
    val estudianteId: Int?,
    val estudianteNombre: String?,
    val cursoId: Int?,
    val cursoNombre: String?
) {
    companion object {
        fun fromEntity(i: Inscripcion): InscripcionResponse =
            InscripcionResponse(
                id = i.id ?: 0,
                estudianteId = i.estudiante?.id,
                estudianteNombre = i.estudiante?.nombre ?: "Sin estudiante",
                cursoId = i.curso?.id,
                cursoNombre = i.curso?.nombre ?: "Sin curso"
            )
    }
}