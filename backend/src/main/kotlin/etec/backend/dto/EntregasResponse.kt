package etec.backend.dto

import etec.backend.entity.Entrega

data class EntregasResponse(
    val id: Long,
    val nombre: String,
    val codigoEnviado: String?,
    val estado: String,
    val estudianteId: Long?,
    val estudianteNombre: String?,
    val consignaId: Long?,
    val consignaTitulo: String?
) {
    companion object {
        fun fromEntity(e: Entrega): EntregasResponse =
            EntregasResponse(
                id = e.id ?: 0L,
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