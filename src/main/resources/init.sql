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
    task_name TEXT NOT NULL
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

INSERT INTO task_item (task_item_title, task_item_short_description, task_item_long_description, task_item_estimated_time, task_item_task_id, task_item_category_id) VALUES
    ('Python basics','The very beginning of a long journey','Python is a powerful high-level, object-oriented programming language created by Guido van Rossum.<br>It has simple easy-to-use syntax, making it the perfect language for someone trying to learn computer programming for the first time.<br>This is a comprehensive guide on how to get started in Python, why you should learn it and how you can learn it.<br><br><br><big><b>Features of Python Programming</b></big><br><br><b>A simple language which is easier to learn</b><br>Python has a very simple and elegant syntax. It''s much easier to read and write Python programs compared to other languages like: C++, Java, C#. Python makes programming fun and allows you to focus on the solution rather than syntax.<br>If you are a newbie, it''s a great choice to start your journey with Python.<br><br><b>Free and open-source</b><br>You can freely use and distribute Python, even for commercial use. Not only can you use and distribute softwares written in it, you can even make changes to the Python''s source code.<br>Python has a large community constantly improving it in each iteration.<br><br><b>Portability</b><br>You can move Python programs from one platform to another, and run it without any changes.<br>It runs seamlessly on almost all platforms including Windows, Mac OS X and Linux.<br><br><b>Extensible and Embeddable</b><br>Suppose an application requires high performance. You can easily combine pieces of C/C++ or other languages with Python code.<br>This will give your application high performance as well as scripting capabilities which other languages may not provide out of the box.<br><br><b>A high-level, interpreted language</b><br>Unlike C/C++, you don''t have to worry about daunting tasks like memory management, garbage collection and so on.<br>Likewise, when you run Python code, it automatically converts your code to the language your computer understands. You don''t need to worry about any lower-level operations.<br><br><b>Large standard libraries to solve common tasks</b><br>Python has a number of standard libraries which makes life of a programmer much easier since you don''t have to write all the code yourself. For example: Need to connect MySQL database on a Web server? You can use MySQLdb library using import MySQLdb .<br>Standard libraries in Python are well tested and used by hundreds of people. So you can be sure that it won''t break your application.<br><br><b>Object-oriented</b><br>Everything in Python is an object. Object oriented programming (OOP) helps you solve a complex problem intuitively.<br>With OOP, you are able to divide these complex problems into smaller sets by creating objects.',2,1,1),
    ('Python basics Quiz','Please give a lot attention for the Python basics Text Page then fill this quiz',null,5,1,2)
;

CREATE TABLE task_question (
    task_q_id SERIAL PRIMARY KEY,
    task_q_question TEXT NOT NULL,
    task_q_correct_answer TEXT NOT NULL,
    task_q_point INT NOT NULL,
    task_q_submitted_user_id INT NULL,
    task_q_item_id INT NOT NULL
);

INSERT INTO task_question (task_q_question, task_q_correct_answer, task_q_point, task_q_item_id) VALUES
    ('How can you see what''s inside the current directory?', 'By running "ls"', 2, 2),
    ('What will the following command do: "ls ../.."', 'List the content of the "grandparent" of the current directory', 3, 2)
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
    attendance_user_id integer ARRAY NOT NULL
);

INSERT INTO attendance (attendance_date, attendance_user_id) VALUES
    ('2018-04-01','{3,4,5,6}'),
    ('2018-04-02','{3,4,5}'),
    ('2018-04-03','{3,5,6}'),
    ('2018-04-04','{3,4}')
;
