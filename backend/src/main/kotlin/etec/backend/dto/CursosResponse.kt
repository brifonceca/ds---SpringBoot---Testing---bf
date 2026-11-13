package etec.backend.dto

import etec.backend.entity.Curso

data class CursosResponse(
    val id: Long,
    val slug: String,
    val nombre: String,
    val descripcion: String?,
    val anoId: Long?
) {
    companion object {
        fun fromEntity(c: Curso): CursosResponse =
            CursosResponse(
                id = c.id ?: 0L,
                slug = c.slug,
                nombre = c.nombre,
                descripcion = c.descripcion,
                anoId = c.ano?.id
            )
    }
}
