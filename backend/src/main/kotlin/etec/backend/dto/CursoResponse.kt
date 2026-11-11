package etec.backend.dto

import etec.backend.entity.Curso

data class CursosResponse(
    val id: Int,
    val nombre: String,
    val anoId: Int?
) {
    companion object {
        fun fromEntity(c: Curso): CursosResponse =
            CursosResponse(
                id = c.id ?: 0,
                nombre = c.nombre,
                anoId = c.ano?.id
            )
    }
}