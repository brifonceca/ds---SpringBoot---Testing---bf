package etec.bdd.exception

class CursoNoEncontradoException(id: Long) :
    RuntimeException("Curso no encontrado con el ID: $id")