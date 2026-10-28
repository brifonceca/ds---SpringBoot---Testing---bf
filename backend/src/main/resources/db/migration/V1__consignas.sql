CREATE TABLE IF NOT EXISTS consignas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(120) NOT NULL,
    descripcion VARCHAR,
    curso_id BIGINT NOT NULL,

    --relacion entre consignas a curso
    CONSTRAINT fk_consigna_curso FOREING KEY (curso_id) REFERENCE cursos(id) ON DELETE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
