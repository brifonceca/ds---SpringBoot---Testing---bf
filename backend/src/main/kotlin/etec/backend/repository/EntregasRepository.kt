package etec.backend.repository

import etec.backend.entity.Entrega
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EntregasRepository : JpaRepository<Entrega, Long>