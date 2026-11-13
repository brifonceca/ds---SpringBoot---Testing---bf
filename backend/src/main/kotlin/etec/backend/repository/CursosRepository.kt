package etec.backend.repository

import etec.backend.entity.Curso
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CursosRepository : JpaRepository<Curso, Long> {
    // Spring Data arma el SQL a partir del nombre del método:
    // SELECT * FROM cursos WHERE anos_id IN (...) ORDER BY id
    fun findAllByAnoIdInOrderByIdAsc(anoIds: Collection<Long>): List<Curso>
}
