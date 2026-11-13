-- Datos iniciales para la home: los 6 años y sus materias.
-- Los slugs coinciden con los ids del mock del front (lib/curriculum.ts)
-- para que las pantallas de materia/ejercicio (que siguen mockeadas) sigan funcionando.

INSERT INTO anos (numero, nombre, foco) VALUES
    (1, '1° Año', 'Primeros pasos y lógica'),
    (2, '2° Año', 'Ciclos, condiciones y funciones'),
    (3, '3° Año', 'Listas y cadenas de texto'),
    (4, '4° Año', 'Ordenamiento y recursividad'),
    (5, '5° Año', 'Estructuras y matrices'),
    (6, '6° Año', 'Algoritmos avanzados y grafos');

INSERT INTO cursos (slug, nombre, descripcion, anos_id) VALUES
    ('intro-programacion',   'Introducción a la Programación', 'Variables, operaciones y tus primeras funciones.',            (SELECT id FROM anos WHERE numero = 1)),
    ('logica-algoritmos',    'Lógica y Algoritmos',            'Pensamiento computacional aplicado a problemas cotidianos.', (SELECT id FROM anos WHERE numero = 1)),
    ('programacion-1',       'Programación I',                 'Ciclos, acumuladores y manejo básico de listas.',            (SELECT id FROM anos WHERE numero = 2)),
    ('algoritmos-1',         'Algoritmos I',                   'Problemas clásicos para entrenar la lógica.',                (SELECT id FROM anos WHERE numero = 2)),
    ('estructuras-datos-1',  'Estructuras de Datos I',         'Arreglos, búsqueda y manipulación de colecciones.',          (SELECT id FROM anos WHERE numero = 3)),
    ('programacion-2',       'Programación II',                'Procesamiento de cadenas de texto.',                         (SELECT id FROM anos WHERE numero = 3)),
    ('ordenamiento',         'Algoritmos de Ordenamiento',     'Burbuja, mezcla y verificación de orden.',                   (SELECT id FROM anos WHERE numero = 4)),
    ('recursividad',         'Recursividad',                   'Funciones que se llaman a sí mismas.',                       (SELECT id FROM anos WHERE numero = 4)),
    ('estructuras-datos-2',  'Estructuras de Datos II',        'Pilas, búsqueda binaria y rotaciones.',                      (SELECT id FROM anos WHERE numero = 5)),
    ('matrices',             'Matrices y Arreglos 2D',         'Operaciones sobre tablas de datos.',                         (SELECT id FROM anos WHERE numero = 5)),
    ('algoritmos-avanzados', 'Algoritmos Avanzados',           'Optimización y técnicas de entrevista técnica.',             (SELECT id FROM anos WHERE numero = 6)),
    ('grafos',               'Teoría de Grafos',               'Listas de adyacencia, recorridos y caminos.',                (SELECT id FROM anos WHERE numero = 6));
