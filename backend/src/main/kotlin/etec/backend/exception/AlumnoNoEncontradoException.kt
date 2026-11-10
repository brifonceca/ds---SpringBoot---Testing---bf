package etec.backend.exception

class AlumnoNoEncontradoException(id: Int) :
    RuntimeException("Alumno no encontrado con el ID: $id")