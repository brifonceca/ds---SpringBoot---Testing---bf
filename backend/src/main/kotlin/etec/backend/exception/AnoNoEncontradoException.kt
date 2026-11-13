package etec.backend.exception

class AnoNoEncontradoException(id: Long) :
    RuntimeException("Año no encontrado con el ID: $id")