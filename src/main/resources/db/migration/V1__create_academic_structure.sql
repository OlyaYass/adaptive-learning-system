CREATE TABLE educational_program
(
    id   BIGSERIAL PRIMARY KEY,
    code VARCHAR(20)  NOT NULL,
    name VARCHAR(255) NOT NULL,

    CONSTRAINT uk_educational_program_code UNIQUE (code)
);


CREATE TABLE discipline
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


CREATE TABLE program_discipline
(
    id BIGSERIAL PRIMARY KEY,

    educational_program_id BIGINT NOT NULL,
    discipline_id          BIGINT NOT NULL,

    curriculum_index VARCHAR(50) NOT NULL,
    credits          NUMERIC(4, 1) NOT NULL,

    CONSTRAINT fk_program_discipline_program
        FOREIGN KEY (educational_program_id)
            REFERENCES educational_program (id),

    CONSTRAINT fk_program_discipline_discipline
        FOREIGN KEY (discipline_id)
            REFERENCES discipline (id),

    CONSTRAINT uk_program_curriculum_index
        UNIQUE (educational_program_id, curriculum_index)
);