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
@Table(name = "cursos")
class Curso(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    // Identificador legible para URLs (ej: "intro-programacion").
    // El front lo usa para linkear a /materia/{slug}.
    @Column(nullable = false, unique = true, length = 80)
    var slug: String = "",

    @Column(nullable = false, length = 120)
    var nombre: String = "",

    @Column(length = 255)
    var descripcion: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anos_id", nullable = false)
    var ano: Ano? = null
)
