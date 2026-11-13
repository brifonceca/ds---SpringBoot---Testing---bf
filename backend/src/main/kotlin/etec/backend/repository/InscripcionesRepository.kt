package etec.backend.repository

import etec.backend.entity.Inscripcion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InscripcionesRepository : JpaRepository<Inscripcion, Long>