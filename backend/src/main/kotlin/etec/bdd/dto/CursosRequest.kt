package etec.bdd.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CursosRequest(
    @field:NotBlank(message = "El nombre del curso no puede estar en blanco")
    @field:Size(min = 1, max = 120, message = "El nombre del curso debe tener entre 1 y 120 caracteres")
    val nombre: String
)