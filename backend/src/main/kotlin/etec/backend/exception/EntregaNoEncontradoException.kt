package etec.backend.exception

class EntregaNoEncontradoException(id: Long) :
    RuntimeException("Entrega no encontrado con el ID: $id")