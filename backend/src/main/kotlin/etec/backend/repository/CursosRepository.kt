package etec.backend.repository

import etec.backend.entity.Curso
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CursosRepository : JpaRepository<Curso, Int>