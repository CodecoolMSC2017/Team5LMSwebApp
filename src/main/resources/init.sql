/*
    Database initialization script that runs on every web-application redeployment.
*/

DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
    name TEXT NULL,
    firstName TEXT NULL,
    lastName TEXT NULL,
    message TEXT NULL,
    role TEXT NULL,
	CONSTRAINT email_not_empty CHECK (email <> ''),
	CONSTRAINT password_not_empty CHECK (password <> '')
);

INSERT INTO users (name, email, password, role) VALUES
	('Robi', 'robert.kohanyi@codecool.com', 'a', 'Mentor'),
	('Pako', 'pal.monoczki@codecool.com', 'a', 'Mentor'),
	('Ben', 'o.g.bence@totalcar.hu', 'a', 'Student'),
	('Tib', 'domokos.tibor.82@gmail.com', 'a', 'Student'),
	('Norb', 'dnorbert@gmail.com', 'a', 'Student'),
	('Krisz', 'kollarkr@gmail.com', 'a', 'Student');
