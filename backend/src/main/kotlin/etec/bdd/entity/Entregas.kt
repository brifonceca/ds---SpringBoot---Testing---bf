package etec.bdd.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "entregas")
class Entrega(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, length = 120)
    var nombre: String = "",

    @Column(name = "codigo_enviado")
    var codigoEnviado: String? = null,

    @Column(length = 50)
    var estado: String? = null,

    @ManyToOne // relacion muchas entregas q pertenecen a un solo alumno
    @JoinColumn(name = "alumno_id", nullable = false)
    var alumno: Alumno? = null,

    @ManyToOne // relacion muchas entregas q responden a una consigna
    @JoinColumn(name = "consigna_id", nullable = false)
    var consigna: Consigna? = null
)