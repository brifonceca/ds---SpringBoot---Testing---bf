package etec.backend.controller

import etec.backend.dto.InscripcionesRequest
import etec.backend.dto.InscripcionResponse
import etec.backend.service.InscripcionesService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/inscripciones")
class InscripcionesController(
    private val inscripcionesService: InscripcionesService
) {

    @GetMapping
    fun listar(pageable: Pageable): ResponseEntity<Page<InscripcionResponse>> {
        return ResponseEntity.ok(inscripcionesService.listar(pageable))
    }

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Long): ResponseEntity<InscripcionResponse> {
        return ResponseEntity.ok(inscripcionesService.obtener(id))
    }

    @PostMapping
    fun crear(@Valid @RequestBody req: InscripcionesRequest): ResponseEntity<InscripcionResponse> {
        val creado = inscripcionesService.crear(req)
        return ResponseEntity.status(HttpStatus.CREATED).body(creado)
    }
}