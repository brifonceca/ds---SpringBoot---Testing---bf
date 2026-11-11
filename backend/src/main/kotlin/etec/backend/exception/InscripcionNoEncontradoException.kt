package etec.backend.exception

class InscripcionNoEncontradoException(id: Int) :
    RuntimeException("Inscripción no encontrada con el ID: $id")