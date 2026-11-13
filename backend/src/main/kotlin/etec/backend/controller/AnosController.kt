package etec.backend.controller

import etec.backend.dto.AnoConCursosResponse
import etec.backend.service.AnosService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/anos")
class AnosController(
    private val anosService: AnosService
) {
    // GET /api/anos -> [{ id, numero, nombre, foco, cursos: [...] }, ...]
    @GetMapping
    fun listar(): ResponseEntity<List<AnoConCursosResponse>> =
        ResponseEntity.ok(anosService.listarConCursos())
}
