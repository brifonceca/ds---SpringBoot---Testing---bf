package etec.backend.exception

class AlumnoNoEncontradoException(id: Long) :
    RuntimeException("Alumno no encontrado con el ID: $id")