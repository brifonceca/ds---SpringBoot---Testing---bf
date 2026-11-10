package etec.backend.repository

import etec.backend.entity.Consigna
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ConsignasRepository : JpaRepository<Consigna, Int>