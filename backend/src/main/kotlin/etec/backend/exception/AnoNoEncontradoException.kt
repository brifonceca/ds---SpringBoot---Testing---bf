package etec.backend.exception

class AnoNoEncontradoException(id: Int) :
    RuntimeException("Año no encontrado con el ID: $id")