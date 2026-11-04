package etec.bdd.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class AlumnosRequest(
    @field:NotBlank
    @field:Size(min = 1, max = 120)
    val nombre: String,

    @field:NotNull
    val cursoId:
)