package etec.backend.controller

import etec.backend.dto.ConsignasRequest
import etec.backend.dto.ConsignasResponse
import etec.backend.service.ConsignasService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/consignas")
class ConsignasController(
    private val consignasService: ConsignasService
) {

    @GetMapping
    fun listar(pageable: Pageable): ResponseEntity<Page<ConsignasResponse>> {
        return ResponseEntity.ok(consignasService.listar(pageable))
    }

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Int): ResponseEntity<ConsignasResponse> {
        return ResponseEntity.ok(consignasService.obtener(id))
    }

    @PostMapping
    fun crear(@Valid @RequestBody req: ConsignasRequest): ResponseEntity<ConsignasResponse> {
        val creado = consignasService.crear(req)
        return ResponseEntity.status(HttpStatus.CREATED).body(creado)
    }
}