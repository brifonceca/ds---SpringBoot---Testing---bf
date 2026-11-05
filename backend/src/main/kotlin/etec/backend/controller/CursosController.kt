package etec.backend.controller

import etec.backend.dto.CursosRequest
import etec.backend.dto.CursosResponse
import etec.backend.service.CursosService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cursos")
class CursosController(
    private val cursosService: CursosService
) {

    @GetMapping
    fun listar(pageable: Pageable): ResponseEntity<Page<CursosResponse>> {
        return ResponseEntity.ok(cursosService.listar(pageable))
    }

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Long): ResponseEntity<CursosResponse> {
        return ResponseEntity.ok(cursosService.obtener(id))
    }

    @PostMapping
    fun crear(@Valid @RequestBody req: CursosRequest): ResponseEntity<CursosResponse> {
        val creado = cursosService.crear(req)
        return ResponseEntity.status(HttpStatus.CREATED).body(creado)
    }
}