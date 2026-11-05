package etec.bdd.exception

class AlumnoNoEncontradoException(id: Long) :
    RuntimeException("Alumno no encontrado con el ID: $id")