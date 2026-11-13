package etec.backend.exception

class InscripcionNoEncontradoException(id: Long) :
    RuntimeException("Inscripción no encontrada con el ID: $id")