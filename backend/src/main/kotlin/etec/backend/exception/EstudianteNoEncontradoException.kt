package etec.backend.exception

class EstudianteNoEncontradoException(id: Int) :
    RuntimeException("Estudiante no encontrado con el ID: $id")