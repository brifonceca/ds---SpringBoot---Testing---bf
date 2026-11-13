package etec.backend.controller

import etec.backend.dto.EstudiantesRequests
import etec.backend.dto.EstudiantesResponse
import etec.backend.service.EstudiantesService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/alumnos")
class EstudiantesController(
    private val EstudiantesService: EstudiantesService
) {

    @GetMapping
    fun listar(pageable: Pageable): ResponseEntity<Page<EstudiantesResponse>> {
        return ResponseEntity.ok(EstudiantesService.listar(pageable))
    }

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Long): ResponseEntity<EstudiantesResponse> {
        return ResponseEntity.ok(EstudiantesService.obtener(id))
    }

    @PostMapping
    fun crear(@Valid @RequestBody req:  EstudiantesRequests): ResponseEntity<EstudiantesResponse> {
        val creado = EstudiantesService.crear(req)
        return ResponseEntity.status(HttpStatus.CREATED).body(creado)
    }
}