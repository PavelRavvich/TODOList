CREATE DATABASE todo_list ENCODING 'UTF8';

\c todo_list

CREATE TABLE IF NOT EXISTS tasks (
    id SERIAL NOT NULL,
    description TEXT NOT NULL,
    done BOOLEAN NOT NULL,
    create_time TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO tasks (id, description, done, create_time)
VALUES (DEFAULT , 'Учиться', 'false', now());

SELECT * FROM tasks;

UPDATE tasks SET done = 'true' WHERE id = '1';

DELETE FROM tasks WHERE id = '1';

