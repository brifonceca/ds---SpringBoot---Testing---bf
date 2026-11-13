package etec.backend.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class CursosRequest(
    @field:NotBlank(message = "El slug del curso no puede estar en blanco")
    @field:Size(max = 80, message = "El slug no puede superar los 80 caracteres")
    @field:Pattern(regexp = "^[a-z0-9-]+$", message = "El slug solo admite minúsculas, números y guiones")
    val slug: String,

    @field:NotBlank(message = "El nombre del curso no puede estar en blanco")
    @field:Size(min = 1, max = 120, message = "El nombre del curso debe tener entre 1 y 120 caracteres")
    val nombre: String,

    @field:Size(max = 255, message = "La descripción no puede superar los 255 caracteres")
    val descripcion: String?,

    @field:NotNull(message = "El ID del año es obligatorio")
    val anoId: Long
)
