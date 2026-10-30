INSERT INTO educational_program (code, name)
VALUES ('09.03.01', 'Информатика и вычислительная техника');


INSERT INTO discipline (name)
VALUES ('Программирование'),
       ('Системы искусственного интеллекта'),
       ('Проектирование информационных систем');


INSERT INTO program_discipline (
    educational_program_id,
    discipline_id,
    curriculum_index,
    credits
)
VALUES (
           (SELECT id
            FROM educational_program
            WHERE code = '09.03.01'),

           (SELECT id
            FROM discipline
            WHERE name = 'Программирование'),

           'Б1.О.17',
           9
       );


INSERT INTO program_discipline (
    educational_program_id,
    discipline_id,
    curriculum_index,
    credits
)
VALUES (
           (SELECT id
            FROM educational_program
            WHERE code = '09.03.01'),

           (SELECT id
            FROM discipline
            WHERE name = 'Системы искусственного интеллекта'),

           'Б1.О.07',
           3
       );


INSERT INTO program_discipline (
    educational_program_id,
    discipline_id,
    curriculum_index,
    credits
)
VALUES (
           (SELECT id
            FROM educational_program
            WHERE code = '09.03.01'),

           (SELECT id
            FROM discipline
            WHERE name = 'Проектирование информационных систем'),

           'Б1.В.02',
           10
       );