package etec.bdd.dto

import etec.bdd.entity.Entrega

data class EntregasResponse(
    val id: Long,
    val nombre: String,
    val codigoEnviado: String?,
    val estado: String?,
    val alumnoNombre: String,
    val consignaTitulo: String
) {
    companion object {
        fun fromEntity(e: Entrega): EntregasResponse =
            EntregasResponse(
                id = e.id ?: 0L,
                nombre = e.nombre,
                codigoEnviado = e.codigoEnviado,
                estado = e.estado,
                alumnoNombre = e.alumno?.nombre ?: "Sin alumno",
                consignaTitulo = e.consigna?.titulo ?: "Sin consigna"
            )
    }
}