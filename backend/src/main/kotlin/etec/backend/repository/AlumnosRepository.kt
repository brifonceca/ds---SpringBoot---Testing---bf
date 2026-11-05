package etec.backend.repository

import etec.backend.entity.Alumno
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AlumnosRepository : JpaRepository<Alumno, Long>