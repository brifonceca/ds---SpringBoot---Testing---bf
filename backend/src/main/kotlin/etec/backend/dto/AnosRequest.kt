package etec.backend.dto

import jakarta.validation.constraints.NotNull

data class AnosRequest(
    @field:NotNull(message = "El ID del curso es obligatorio")
    val cursoId: Int
)