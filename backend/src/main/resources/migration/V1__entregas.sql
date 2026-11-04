CREATE TABLE IF NOT EXISTS entregas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(120) NOT NULL,
    codigo_enviado VARCHAR,
    estado VARCHAR(50),
    alumno_id BIGINT NOT NULL,
    consigna_id BIGINT NOT NULL,

    --RELACION entregas con alumno y entregas a curso
    CONSTRAINT fk_entrega_alumno FOREIGN KEY (alumno_id) REFERENCES alumnos(id) ON DELETE CASCADE
    CONSTRAINT fk_entrega_curso FOREIGN KEY (consigna_id) REFERENCES consignas(id) ON DELETE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;