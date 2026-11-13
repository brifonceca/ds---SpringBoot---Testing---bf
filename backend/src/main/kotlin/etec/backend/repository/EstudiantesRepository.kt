package etec.backend.repository

import etec.backend.entity.Estudiante
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EstudiantesRepository : JpaRepository<Estudiante, Long>
