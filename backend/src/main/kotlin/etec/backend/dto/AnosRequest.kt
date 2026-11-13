package etec.backend.dto

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class AnosRequest(
    @field:Min(1, message = "El número de año debe ser al menos 1")
    @field:Max(6, message = "El número de año no puede superar 6")
    val numero: Int,

    @field:NotBlank(message = "El nombre del año no puede estar en blanco")
    @field:Size(max = 50, message = "El nombre del año no puede superar los 50 caracteres")
    val nombre: String,

    @field:Size(max = 120, message = "El foco no puede superar los 120 caracteres")
    val foco: String?
)
