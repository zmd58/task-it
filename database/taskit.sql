BEGIN TRANSACTION;

DROP TABLE IF EXISTS tasks;
DROP SEQUENCE IF EXISTS seq_task_id;


CREATE TABLE tasks
(
	task_id serial NOT NULL,
	title varchar(100) NOT NULL,
	note varchar(300) NOT NULL,
	date_due date NOT NULL,
	task_status boolean NOT NULL,
	CONSTRAINT PK_tasks PRIMARY KEY (task_id)
);

CREATE SEQUENCE seq_task_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

INSERT INTO tasks
	(title, note, date_due, task_status)
VALUES
	('pick up', 'apple, orange, banana', '03-28-2023', false);

INSERT INTO tasks
	(title, note, date_due, task_status)
VALUES
	('groom', 'groom tha doggie', '03-29-2023', false);

INSERT INTO tasks
	(title, note, date_due, task_status)
VALUES
	('pay', 'pay zoe rent', '03-30-2023', false);

COMMIT;
