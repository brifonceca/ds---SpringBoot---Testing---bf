package etec.bdd.repository

import etec.bdd.entity.Entrega
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EntregasRepository : JpaRepository<Entrega, Long>