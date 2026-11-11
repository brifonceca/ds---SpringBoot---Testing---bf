CREATE TABLE if NOT EXISTS inscripciones(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    estudiantes_id BIGINT NOT NULL,
    cursos_id BIGINT NOT NULL,

    CONSTRAINT fk_estudiante_inscripciones FOREIGN KEY (estudiantes_id) REFERENCES estudiantes(id) ON DELETE CASCADE,
    CONSTRAINT fk_cursos_inscripciones FOREIGN KEY (cursos_id) REFERENCES cursos(id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;