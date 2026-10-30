CREATE TABLE topic
(
    id BIGSERIAL PRIMARY KEY,

    discipline_semester_id BIGINT NOT NULL,

    name VARCHAR(255) NOT NULL,

    position INTEGER NOT NULL,

    target_mastery NUMERIC(5, 2) NOT NULL DEFAULT 75.00,

    active BOOLEAN NOT NULL DEFAULT TRUE,

    CONSTRAINT fk_topic_semester
        FOREIGN KEY (discipline_semester_id)
            REFERENCES discipline_semester(id),

    CONSTRAINT chk_topic_position
        CHECK (position > 0),

    CONSTRAINT chk_topic_target_mastery
        CHECK (target_mastery BETWEEN 0 AND 100),

    CONSTRAINT uk_topic_position
        UNIQUE (discipline_semester_id, position)
);