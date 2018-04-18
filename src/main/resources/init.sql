/*
    Database initialization script that runs on every web-application redeployment.
*/

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS task;
DROP TABLE IF EXISTS task_item_category;
DROP TABLE IF EXISTS task_item;
DROP TABLE IF EXISTS task_question;
DROP TABLE IF EXISTS task_answer;
DROP TABLE IF EXISTS attendance;


CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    user_email TEXT UNIQUE NOT NULL,
    user_password TEXT NOT NULL,
    user_name TEXT NULL,
    user_firstName TEXT NULL,
    user_lastName TEXT NULL,
    user_introduction TEXT NULL,
    user_image TEXT NULL,
    user_role TEXT NOT NULL,
	CONSTRAINT email_not_empty CHECK (user_email <> ''),
	CONSTRAINT password_not_empty CHECK (user_password <> '')
);

INSERT INTO users (user_name, user_email, user_password, user_role) VALUES
	('Robi', 'robert.kohanyi@codecool.com', 'a', 'Mentor'),
	('Pako', 'pal.monoczki@codecool.com', 'a', 'Mentor'),
	('Ben', 'o.g.bence@totalcar.hu', 'a', 'Student'),
	('Tib', 'domokos.tibor.82@gmail.com', 'a', 'Student'),
	('Norb', 'dnorbert@gmail.com', 'a', 'Student'),
	('Krisz', 'kollarkr@gmail.com', 'a', 'Student')
;

CREATE TABLE task (
    task_id SERIAL PRIMARY KEY,
    task_name TEXT UNIQUE NOT NULL
);

INSERT INTO task (task_name) VALUES
    ('Python')
;

CREATE TABLE task_item_category (
    task_item_category_id SERIAL PRIMARY KEY,
    task_item_category_name TEXT UNIQUE NOT NULL,
    task_item_category_icon TEXT UNIQUE NOT NULL
);

INSERT INTO task_item_category (task_item_category_name, task_item_category_icon) VALUES
	('Text Page', '<i class="fa fa-file-text-o fa-lg" aria-hidden="true"></i>'),
	('Quiz', '<i class="fa fa-list-ol fa-lg" aria-hidden="true"></i>'),
	('Assignment', '<i class="fa fa-list fa-lg" aria-hidden="true"></i>')
;

CREATE TABLE task_item (
    task_item_id SERIAL PRIMARY KEY,
    task_item_title TEXT NOT NULL,
    task_item_short_description_title TEXT NULL,
    task_item_short_description TEXT NOT NULL,
    task_item_long_description_title TEXT NULL,
    task_item_long_description TEXT NULL,
    task_item_estimated_time INT NOT NULL,
    task_item_task_id INT NOT NULL,
    task_item_category_id INT NOT NULL
);

INSERT INTO task_item (task_item_title, task_item_short_description, task_item_estimated_time, task_item_task_id, task_item_category_id) VALUES 
    ('Python basics','The very beginning of a long journey',2,1,1),
    ('Python basics Quiz','Please give a lot attention for the Python basics Text Page then fill this quiz',5,1,2)
;

CREATE TABLE task_question (
    task_q_id SERIAL PRIMARY KEY,
    task_q_question TEXT NOT NULL,
    task_q_correct_answer TEXT NOT NULL,
    task_q_point INT NOT NULL,
    task_q_submitted_user_id TEXT NULL,
    task_q_item_id INT NOT NULL
);

INSERT INTO task_question (task_q_question, task_q_correct_answer, task_q_submitted_user_id, task_q_point, task_q_item_id) VALUES
    ('How can you see what''s inside the current directory?', 'By running "ls"', '', 2, 2),
    ('What will the following command do: "ls ../.."', 'List the content of the "grandparent" of the current directory', '', 3, 2)
;

CREATE TABLE task_answer (
    task_a_id SERIAL PRIMARY KEY,
    task_a_answer TEXT NOT NULL,
    task_a_question_id INT NOT NULL
);

INSERT INTO task_answer (task_a_answer, task_a_question_id) VALUES
    ('By running "list"',1),
    ('By running "ls"',1),
    ('By running "tree"',1),
    ('List the content of the "grandparent" of the current directory',2),
    ('Nothing, ls only can show the content of the directory I''m in',2),
    ('List the content of the current directory',2),
    ('List the content of the "parent" of the current directory',2)
;

CREATE TABLE attendance (
    attendance_id SERIAL PRIMARY KEY,
    attendance_date DATE NOT NULL,
    attendance_user_id TEXT NOT NULL
);

INSERT INTO attendance (attendance_date, attendance_user_id) VALUES
    ('2018-04-01','3,4,5,6'),
    ('2018-04-02','3,4,5'),
    ('2018-04-03','3,5,6'),
    ('2018-04-04','3,4')
;
