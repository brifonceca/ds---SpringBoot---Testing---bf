package etec.backend.repository

import etec.backend.entity.Ano
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnosRepository : JpaRepository<Ano, Int>