package etec.backend.exception

class EstudianteNoEncontradoException(id: Long) :
    RuntimeException("Estudiante no encontrado con el ID: $id")