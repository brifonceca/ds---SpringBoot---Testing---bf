package etec.bdd.repository

import etec.bdd.entity.Curso
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CursosRepository : JpaRepository<Curso, Long>