package etec.backend.service

import etec.backend.dto.AnoConCursosResponse
import etec.backend.dto.CursosResponse
import etec.backend.repository.AnosRepository
import etec.backend.repository.CursosRepository
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AnosService(
    private val anosRepository: AnosRepository,
    private val cursosRepository: CursosRepository
) {
    /**
     * Devuelve los años ordenados (1° a 6°) con sus cursos anidados.
     * Hace 2 queries en total (años + cursos) en lugar de 1 por año (evita el problema N+1).
     */
    @Transactional(readOnly = true)
    fun listarConCursos(): List<AnoConCursosResponse> {
        val anos = anosRepository.findAll(Sort.by("numero"))
        val anoIds = anos.mapNotNull { it.id }

        val cursosPorAno = cursosRepository.findAllByAnoIdInOrderByIdAsc(anoIds)
            .groupBy { it.ano?.id }

        return anos.map { ano ->
            AnoConCursosResponse(
                id = ano.id ?: 0L,
                numero = ano.numero,
                nombre = ano.nombre,
                foco = ano.foco,
                cursos = cursosPorAno[ano.id].orEmpty().map { CursosResponse.fromEntity(it) }
            )
        }
    }
}
