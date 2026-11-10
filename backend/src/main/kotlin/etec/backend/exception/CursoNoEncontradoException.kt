package etec.backend.exception

class CursoNoEncontradoException(id: Int) :
    RuntimeException("Curso no encontrado con el ID: $id")