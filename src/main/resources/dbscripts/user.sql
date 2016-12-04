CREATE TABLE mydb.user
(
    id INT PRIMARY KEY NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
ALTER TABLE mydb.user ADD CONSTRAINT unique_id UNIQUE (id);