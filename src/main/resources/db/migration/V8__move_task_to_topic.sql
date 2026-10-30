ALTER TABLE task
    DROP CONSTRAINT fk_task_discipline;

ALTER TABLE task
    DROP COLUMN program_discipline_id;

ALTER TABLE task
    ALTER COLUMN topic_id SET NOT NULL;