package etec.backend.controller

import etec.backend.dto.AlumnosRequest
import etec.backend.dto.AlumnosResponse
import etec.backend.service.AlumnosService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/alumnos")
class AlumnosController(
    private val alumnosService: AlumnosService
) {

    @GetMapping
    fun listar(pageable: Pageable): ResponseEntity<Page<AlumnosResponse>> {
        return ResponseEntity.ok(alumnosService.listar(pageable))
    }

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Long): ResponseEntity<AlumnosResponse> {
        return ResponseEntity.ok(alumnosService.obtener(id))
    }

    @PostMapping
    fun crear(@Valid @RequestBody req: AlumnosRequest): ResponseEntity<AlumnosResponse> {
        val creado = alumnosService.crear(req)
        return ResponseEntity.status(HttpStatus.CREATED).body(creado)
    }
}