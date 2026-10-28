CREATE TABLE IF NOT EXISTS alumnos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(120) NOT NULL,
    curso_id BEGINT NOT NULL,

    --relacion entre alumnos a un curso
    CONSTRAINT fk_alumno_curso FOREING KEY (curso_id) REFERENCE cursos(id) ON DELETE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


