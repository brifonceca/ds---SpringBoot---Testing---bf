package etec.backend.exception

class EntregaNoEncontradoException(id: Int) :
    RuntimeException("Entrega no encontrado con el ID: $id")