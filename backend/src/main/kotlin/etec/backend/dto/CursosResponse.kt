package etec.backend.dto

import etec.backend.entity.Curso

data class CursosResponse(
    val id: Long,
    val nombre: String
) {
    companion object {
        fun fromEntity(c: Curso): CursosResponse =
            CursosResponse(
                id = c.id ?: 0L,
                nombre = c.nombre
            )
    }
}