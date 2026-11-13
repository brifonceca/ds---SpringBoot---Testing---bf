-- Corrige el modelo de años y cursos.
--
-- Problemas del esquema original:
--   * anos.curso_id     -> un año NO pertenece a un curso; es al revés (cursos.anos_id ya lo resuelve).
--   * cursos.consignas_id -> un curso tiene MUCHAS consignas; la relación ya vive en consignas.cursos_id.
-- Ambas columnas eran NOT NULL y sin uso, así que impedían insertar datos.
--
-- Además se agregan los datos que necesita la home del front.

ALTER TABLE anos
    DROP COLUMN curso_id,
    ADD COLUMN numero INT NOT NULL,
    ADD COLUMN nombre VARCHAR(50) NOT NULL,
    ADD COLUMN foco VARCHAR(120) NULL,
    ADD CONSTRAINT uk_anos_numero UNIQUE (numero);

ALTER TABLE cursos
    DROP COLUMN consignas_id,
    ADD COLUMN slug VARCHAR(80) NOT NULL,
    ADD COLUMN descripcion VARCHAR(255) NULL,
    ADD CONSTRAINT uk_cursos_slug UNIQUE (slug);
