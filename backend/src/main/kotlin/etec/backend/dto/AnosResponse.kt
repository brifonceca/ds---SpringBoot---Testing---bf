package etec.backend.dto

import etec.backend.entity.Ano

data class AnoResponse(
    val id: Int
) {
    companion object {
        fun fromEntity(a: Ano): AnoResponse =
            AnoResponse(
                id = a.id ?: 0
            )
    }
}