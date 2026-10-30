ALTER TABLE task
    ADD COLUMN topic_id BIGINT;

ALTER TABLE task
    ADD CONSTRAINT fk_task_topic
        FOREIGN KEY (topic_id)
            REFERENCES topic(id);