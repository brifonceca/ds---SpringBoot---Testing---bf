package etec.backend.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class EntregasRequest(
    @field:NotBlank(message = "El nombre de la entrega no puede estar en blanco")
    @field:Size(min = 1, max = 120, message = "El nombre debe tener entre 1 y 120 caracteres")
    val nombre: String,

    @field:NotBlank(message = "El código enviado no puede estar en blanco")
    val codigoEnviado: String,

    @field:NotBlank(message = "El estado no puede estar en blanco")
    @field:Size(max = 50, message = "El estado no puede superar los 50 caracteres")
    val estado: String,

    @field:NotNull(message = "El ID del alumno es obligatorio")
    val estudianteId: Int,

    @field:NotNull(message = "El ID de la consigna es obligatorio")
    val consignaId: Int
)