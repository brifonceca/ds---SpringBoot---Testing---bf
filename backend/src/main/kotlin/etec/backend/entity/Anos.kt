package etec.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "anos")
class Ano(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    // Número de año de cursada (1 a 6)
    @Column(nullable = false, unique = true)
    var numero: Int = 0,

    // Texto para mostrar, ej: "1° Año"
    @Column(nullable = false, length = 50)
    var nombre: String = "",

    // Eje temático del año, ej: "Primeros pasos y lógica"
    @Column(length = 120)
    var foco: String? = null
)
