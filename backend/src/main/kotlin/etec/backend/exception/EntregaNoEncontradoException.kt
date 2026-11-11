package etec.backend.exception

class EntregaNoEncontradoException(id: Int) :
    RuntimeException("Entrega no encontrada con el ID: $id")