package etec.backend.exception

class ConsignaNoEncontradoException(id: Int) :
    RuntimeException("Consigna no encontrada con el ID: $id")