package etec.backend.exception

class ConsignaNoEncontradoException(id: Int) :
    RuntimeException("Consigna no encontrado con el ID: $id")