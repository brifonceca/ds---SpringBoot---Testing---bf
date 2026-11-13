package etec.backend.dto

import etec.backend.entity.Ano

data class AnoResponse(
    val id: Long,
    val numero: Int,
    val nombre: String,
    val foco: String?
) {
    companion object {
        fun fromEntity(a: Ano): AnoResponse =
            AnoResponse(
                id = a.id ?: 0L,
                numero = a.numero,
                nombre = a.nombre,
                foco = a.foco
            )
    }
}

/**
 * Lo que consume la HOME del front: cada año con sus cursos (materias) adentro.
 * Una sola request => el front arma toda la grilla.
 */
data class AnoConCursosResponse(
    val id: Long,
    val numero: Int,
    val nombre: String,
    val foco: String?,
    val cursos: List<CursosResponse>
)
