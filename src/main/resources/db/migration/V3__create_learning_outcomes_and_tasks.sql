CREATE TABLE competency
(
    id          BIGSERIAL PRIMARY KEY,
    code        VARCHAR(50) NOT NULL UNIQUE,
    name        VARCHAR(500)
);


CREATE TABLE competency_indicator
(
    id              BIGSERIAL PRIMARY KEY,
    competency_id   BIGINT NOT NULL,
    code             VARCHAR(50) NOT NULL UNIQUE,
    description      TEXT,

    CONSTRAINT fk_indicator_competency
        FOREIGN KEY (competency_id)
            REFERENCES competency (id)
);


CREATE TABLE learning_outcome
(
    id                      BIGSERIAL PRIMARY KEY,
    program_discipline_id   BIGINT NOT NULL,
    competency_indicator_id BIGINT,
    code                    VARCHAR(50),
    description             TEXT NOT NULL,

    CONSTRAINT fk_learning_outcome_discipline
        FOREIGN KEY (program_discipline_id)
            REFERENCES program_discipline (id),

    CONSTRAINT fk_learning_outcome_indicator
        FOREIGN KEY (competency_indicator_id)
            REFERENCES competency_indicator (id)
);


CREATE TABLE task
(
    id                      BIGSERIAL PRIMARY KEY,
    program_discipline_id   BIGINT NOT NULL,
    title                   VARCHAR(255) NOT NULL,
    description             TEXT NOT NULL,
    difficulty              INTEGER NOT NULL,
    estimated_minutes       INTEGER,
    max_score               NUMERIC(6, 2) NOT NULL,
    active                  BOOLEAN NOT NULL DEFAULT TRUE,

    CONSTRAINT fk_task_discipline
        FOREIGN KEY (program_discipline_id)
            REFERENCES program_discipline (id),

    CONSTRAINT chk_task_difficulty
        CHECK (difficulty BETWEEN 1 AND 5),

    CONSTRAINT chk_task_max_score
        CHECK (max_score > 0)
);


CREATE TABLE task_learning_outcome
(
    id                  BIGSERIAL PRIMARY KEY,
    task_id             BIGINT NOT NULL,
    learning_outcome_id BIGINT NOT NULL,
    weight              NUMERIC(5, 4) NOT NULL,

    CONSTRAINT fk_task_outcome_task
        FOREIGN KEY (task_id)
            REFERENCES task (id)
            ON DELETE CASCADE,

    CONSTRAINT fk_task_outcome_outcome
        FOREIGN KEY (learning_outcome_id)
            REFERENCES learning_outcome (id),

    CONSTRAINT chk_task_outcome_weight
        CHECK (weight > 0 AND weight <= 1),

    CONSTRAINT uk_task_learning_outcome
        UNIQUE (task_id, learning_outcome_id)
);