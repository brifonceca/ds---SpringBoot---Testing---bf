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
@Table(name = "consignas")
class Consigna(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, length = 120)
    var titulo: String = "",

    @Column(columnDefinition = "TEXT")
    var descripcion: String? = null,

    @ManyToOne // relacion de muchas consignas q pertenecen a un curso
    @JoinColumn(name = "curso_id", nullable = false)
    var curso: Curso? = null
)