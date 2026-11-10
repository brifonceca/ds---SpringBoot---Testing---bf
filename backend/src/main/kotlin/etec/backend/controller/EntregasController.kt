package etec.backend.controller

import etec.backend.dto.EntregasRequest
import etec.backend.dto.EntregasResponse
import etec.backend.service.EntregasService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/entregas")
class EntregasController(
    private val entregasService: EntregasService
) {

    @GetMapping
    fun listar(pageable: Pageable): ResponseEntity<Page<EntregasResponse>> {
        return ResponseEntity.ok(entregasService.listar(pageable))
    }

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Int): ResponseEntity<EntregasResponse> {
        return ResponseEntity.ok(entregasService.obtener(id))
    }

    @PostMapping
    fun crear(@Valid @RequestBody req: EntregasRequest): ResponseEntity<EntregasResponse> {
        val creado = entregasService.crear(req)
        return ResponseEntity.status(HttpStatus.CREATED).body(creado)
    }
}