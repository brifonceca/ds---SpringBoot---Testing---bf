package etec.bdd.repository

import etec.bdd.entity.Alumno
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AlumnosRepository : JpaRepository<Alumno, Long>