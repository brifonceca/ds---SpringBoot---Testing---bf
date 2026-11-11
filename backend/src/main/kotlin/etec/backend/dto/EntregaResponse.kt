package etec.backend.dto

import etec.backend.entity.Entrega

data class EntregasResponse(
    val id: Int,
    val nombre: String,
    val codigoEnviado: String?,
    val estado: String,
    val estudianteId: Int?,
    val estudianteNombre: String?,
    val consignaId: Int?,
    val consignaTitulo: String?
) {
    companion object {
        fun fromEntity(e: Entrega): EntregasResponse =
            EntregasResponse(
                id = e.id ?: 0,
                nombre = e.nombre,
                codigoEnviado = e.codigoEnviado,
                estado = e.estado,
                estudianteId = e.estudiante?.id,
                estudianteNombre = e.estudiante?.nombre ?: "Sin estudiante",
                consignaId = e.consigna?.id,
                consignaTitulo = e.consigna?.titulo ?: "Sin consigna"
            )
    }
}