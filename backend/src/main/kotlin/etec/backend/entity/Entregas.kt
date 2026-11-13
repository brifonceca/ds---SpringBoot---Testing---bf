package etec.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
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

    @Column(name = "codigo_enviado", length = 120)
    var codigoEnviado: String? = null,

    @Column(length = 50)
    var estado: String = "",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_id", nullable = false)
    var estudiante: Estudiante? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consigna_id", nullable = false)
    var consigna: Consigna? = null
)