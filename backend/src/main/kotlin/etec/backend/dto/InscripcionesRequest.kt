package etec.backend.dto

import jakarta.validation.constraints.NotNull

data class InscripcionesRequest(
    @field:NotNull(message = "El ID del estudiante es obligatorio")
    val estudianteId: Long,

    @field:NotNull(message = "El ID del curso es obligatorio")
    val cursoId: Long
)