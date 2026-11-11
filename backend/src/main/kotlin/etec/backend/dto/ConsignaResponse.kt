package etec.backend.dto

import etec.backend.entity.Consigna

data class ConsignasResponse(
    val id: Int,
    val titulo: String,
    val descripcion: String?,
    val cursoId: Int?,
    val cursoNombre: String?
) {
    companion object {
        fun fromEntity(c: Consigna): ConsignasResponse =
            ConsignasResponse(
                id = c.id ?: 0,
                titulo = c.titulo,
                descripcion = c.descripcion,
                cursoId = c.curso?.id,
                cursoNombre = c.curso?.nombre ?: "Sin curso"
            )
    }
}