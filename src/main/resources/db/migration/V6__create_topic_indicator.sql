CREATE TABLE topic_indicator
(
    id BIGSERIAL PRIMARY KEY,

    topic_id BIGINT NOT NULL,
    indicator_id BIGINT NOT NULL,

    weight NUMERIC(5, 4) NOT NULL DEFAULT 1.0000,

    CONSTRAINT fk_topic_indicator_topic
        FOREIGN KEY (topic_id)
            REFERENCES topic(id)
            ON DELETE CASCADE,

    CONSTRAINT fk_topic_indicator_indicator
        FOREIGN KEY (indicator_id)
            REFERENCES competency_indicator(id),

    CONSTRAINT chk_topic_indicator_weight
        CHECK (weight > 0),

    CONSTRAINT uk_topic_indicator
        UNIQUE (topic_id, indicator_id)
);