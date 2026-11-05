package etec.bdd.dto

import etec.bdd.entity.Consigna

data class ConsignasResponse(
    val id: Long,
    val titulo: String,
    val descripcion: String?,
    val cursoNombre: String
) {
    companion object {
        fun fromEntity(c: Consigna): ConsignasResponse =
            ConsignasResponse(
                id = c.id ?: 0L,
                titulo = c.titulo,
                descripcion = c.descripcion,
                cursoNombre = c.curso?.nombre ?: "Sin curso"
            )
    }
}