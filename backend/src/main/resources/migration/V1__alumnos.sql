CREATE TABLE IF NOT EXISTS alumnos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(120) NOT NULL,
    curso_id BIGINT NOT NULL,

    --relacion entre alumnos a un curso
    CONSTRAINT fk_alumno_curso FOREIGN KEY (curso_id) REFERENCES cursos(id) ON DELETE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


