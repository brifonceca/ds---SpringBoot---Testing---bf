package etec.bdd.exception

class ConsignaNoEncontradoException(id: Long) :
    RuntimeException("Consigna no encontrado con el ID: $id")