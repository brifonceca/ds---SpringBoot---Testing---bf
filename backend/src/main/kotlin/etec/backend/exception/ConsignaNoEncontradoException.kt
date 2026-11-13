package etec.backend.exception

class ConsignaNoEncontradoException(id: Long) :
    RuntimeException("Consigna no encontrada con el ID: $id")