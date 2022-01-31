CREATE TABLE employee (
    id SERIAL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR (255) NOT NULL,
    department_id INTEGER NOT NULL,
    job_title VARCHAR (255) NOT NULL,
    gender VARCHAR (255) NOT NULL,
    date_of_birth DATE NOT NULL,
    CONSTRAINT pk_employee_id PRIMARY KEY (id)
);
CREATE SEQUENCE employees_id_seq START WITH 5 INCREMENT BY 1;