CREATE TABLE discipline_semester
(
    id BIGSERIAL PRIMARY KEY,

    program_discipline_id BIGINT NOT NULL,

    semester_number INTEGER NOT NULL,

    control_type VARCHAR(30) NOT NULL,

    active BOOLEAN NOT NULL DEFAULT TRUE,

    CONSTRAINT fk_discipline_semester
        FOREIGN KEY (program_discipline_id)
            REFERENCES program_discipline(id),

    CONSTRAINT chk_semester_number
        CHECK (semester_number > 0),

    CONSTRAINT uk_discipline_semester
        UNIQUE (program_discipline_id, semester_number)
);