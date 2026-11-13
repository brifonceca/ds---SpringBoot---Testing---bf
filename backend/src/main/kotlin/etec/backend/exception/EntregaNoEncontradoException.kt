package etec.backend.exception

class EntregaNoEncontradoException(id: Long) :
    RuntimeException("Entrega no encontrada con el ID: $id")