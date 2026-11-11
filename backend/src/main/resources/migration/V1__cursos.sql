CREATE TABLE IF NOT EXISTS cursos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(120) NOT NULL
    consignas_id BIGINT NOT NULL,
    anos_id BIGINT NOT NULL,

--  Relacion: Cursos con años
    CONSTRAINT fk_cursos_anos FOREIGN KEY (anos_id) REFERENCES anos(id) ON DELETE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;