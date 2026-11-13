package etec.backend.dto

import etec.backend.entity.Inscripcion

data class InscripcionResponse(
    val id: Long,
    val estudianteId: Long?,
    val estudianteNombre: String?,
    val cursoId: Long?,
    val cursoNombre: String?
) {
    companion object {
        fun fromEntity(i: Inscripcion): InscripcionResponse =
            InscripcionResponse(
                id = i.id ?: 0L,
                estudianteId = i.estudiante?.id,
                estudianteNombre = i.estudiante?.nombre ?: "Sin estudiante",
                cursoId = i.curso?.id,
                cursoNombre = i.curso?.nombre ?: "Sin curso"
            )
    }
}