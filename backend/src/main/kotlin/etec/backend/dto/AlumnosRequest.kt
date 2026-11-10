package etec.backend.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class AlumnosRequest(
    @field:NotBlank(message = "El nombre no puede estar en blanco")
    @field:Size(min = 1, max = 120, message = "El nombre debe tener entre 1 y 120 caracteres")
    val nombre: String,

    @field:NotNull(message = "El ID del curso es obligatorio")
    val cursoId: Int
)