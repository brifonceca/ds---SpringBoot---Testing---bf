package etec.backend.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class ConsignasRequest(
    @field:NotBlank(message = "El título no puede estar en blanco")
    @field:Size(min = 1, max = 120, message = "El título debe tener entre 1 y 120 caracteres")
    val titulo: String,

    @field:Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    val descripcion: String?,

    @field:NotNull(message = "El ID del curso es obligatorio")
    val cursoId: Long
)