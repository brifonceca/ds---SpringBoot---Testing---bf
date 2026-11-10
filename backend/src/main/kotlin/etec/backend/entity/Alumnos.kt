package etec.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "alumnos")
class Alumno(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(nullable = false, length = 120)
    var nombre: String = "",

    @ManyToOne // relacion muchos alumnos q pertenecen a un curso
    @JoinColumn(name = "curso_id", nullable = false)
    var curso: Curso? = null
)