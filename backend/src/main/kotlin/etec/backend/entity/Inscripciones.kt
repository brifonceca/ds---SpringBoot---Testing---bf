package etec.backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "inscripciones")
class Inscripcion(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiantes_id", nullable = false)
    var estudiante: Estudiante? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cursos_id", nullable = false)
    var curso: Curso? = null
)