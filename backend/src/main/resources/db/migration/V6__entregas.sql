CREATE TABLE IF NOT EXISTS entregas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(120) NOT NULL,
    codigo_enviado VARCHAR(120),
    estado VARCHAR(50),
    estudiante_id BIGINT NOT NULL,
    consigna_id BIGINT NOT NULL,

--  Relacion: entregas con estudiante y entregas a curso
    CONSTRAINT fk_entrega_estudiante FOREIGN KEY (estudiante_id) REFERENCES estudiantes(id) ON DELETE CASCADE,
    CONSTRAINT fk_entrega_consigna FOREIGN KEY (consigna_id) REFERENCES consignas(id) ON DELETE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;