-- Crear las tablas
CREATE TABLE app_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    username VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(255),
    role VARCHAR(50),
    last_login TIMESTAMP,
    status VARCHAR(50)
);

CREATE TABLE faculty (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    acronym VARCHAR(50),
    name VARCHAR(255),
    email VARCHAR(255),
    password_hash VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    last_login TIMESTAMP
);

CREATE TABLE department (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    faculty_id BIGINT,
    FOREIGN KEY (faculty_id) REFERENCES faculty(id)
);

CREATE TABLE course (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    department_id BIGINT,
    FOREIGN KEY (department_id) REFERENCES department(id)
);

CREATE TABLE professor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    department_id BIGINT,
    hire_date TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES app_user(id),
    FOREIGN KEY (department_id) REFERENCES department(id)
);

CREATE TABLE qr_generated (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    uuid VARCHAR(255),
    qr_code VARCHAR(255),
    generation_date TIMESTAMP,
    status VARCHAR(50),
    expiration_time TIMESTAMP,
    course_id BIGINT,
    FOREIGN KEY (course_id) REFERENCES course(id)
);

CREATE TABLE attendancy (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    course_id BIGINT,
    department_id BIGINT,
    professor_id BIGINT,
    weekday VARCHAR(10),
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    FOREIGN KEY (course_id) REFERENCES course(id),
    FOREIGN KEY (department_id) REFERENCES department(id),
    FOREIGN KEY (professor_id) REFERENCES professor(id)
);

CREATE TABLE schedule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    course_id BIGINT,
    department_id BIGINT,
    professor_id BIGINT,
    weekday VARCHAR(10),
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    FOREIGN KEY (course_id) REFERENCES course(id),
    FOREIGN KEY (department_id) REFERENCES department(id),
    FOREIGN KEY (professor_id) REFERENCES professor(id)
);


-- Insertar usuarios
INSERT INTO app_user (id, first_name, last_name, username, email, phone_number, role, last_login, status)
VALUES
(1, 'Juan', 'Pérez', 'juanp', 'juan@example.com', '123456789', 'PROFESSOR', CURRENT_TIMESTAMP, 'ACTIVE'),
(2, 'María', 'Gómez', 'mariag', 'maria@example.com', '987654321', 'PROFESSOR', CURRENT_TIMESTAMP, 'ACTIVE'),
(3, 'Carlos', 'Sánchez', 'carloss', 'carlos@example.com', '555555555', 'PROFESSOR', CURRENT_TIMESTAMP, 'ACTIVE');

-- Insertar facultades
INSERT INTO faculty (id, acronym, name, email, password_hash, created_at, updated_at, last_login)
VALUES
(1, 'FCS', 'Facultad de Ciencias Sociales', 'fcs@example.com', 'hashed_password_1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'FCE', 'Facultad de Ciencias Económicas', 'fce@example.com', 'hashed_password_2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'FING', 'Facultad de Ingeniería', 'fing@example.com', 'hashed_password_3', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Insertar departamentos
INSERT INTO department (id, name, description, created_at, updated_at, faculty_id)
VALUES
(1, 'Departamento de Psicología', 'Descripción del departamento de psicología', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
(2, 'Departamento de Economía', 'Descripción del departamento de economía', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2),
(3, 'Departamento de Ingeniería', 'Descripción del departamento de ingeniería', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3);

-- Insertar cursos
INSERT INTO course (id, name, description, department_id)
VALUES
(1, 'Introducción a la Psicología', 'Curso básico de psicología', 1),
(2, 'Teoría Económica', 'Curso sobre teoría económica', 2),
(3, 'Matemáticas', 'Curso avanzado de matemáticas', 3),
(4, 'Física', 'Curso de física aplicada', 3),
(5, 'Programación', 'Curso de programación en Java', 3);

-- Insertar profesores
INSERT INTO professor (id, user_id, department_id, hire_date)
VALUES
(1, 1, 1, CURRENT_TIMESTAMP),
(2, 2, 2, CURRENT_TIMESTAMP),
(3, 3, 3, CURRENT_TIMESTAMP);

-- Insertar horarios
INSERT INTO schedule (id, course_id, department_id, professor_id, weekday, start_time, end_time)
VALUES
(1, 3, 3, 1, 'LUNES', '2024-09-30T08:00:00', '2024-09-30T10:00:00'),  -- Matemáticas
(2, 4, 3, 1, 'MIÉRCOLES', '2024-10-02T10:00:00', '2024-10-02T12:00:00'), -- Física
(3, 5, 3, 1, 'LUNES', '2024-09-30T10:30:00', '2024-09-30T12:30:00'); -- Programación

-- Insertar registros de asistencia
INSERT INTO attendancy (id, course_id, department_id, professor_id, weekday, start_time, end_time)
VALUES
(1, 3, 3, 1, 'LUNES', '2024-09-30T08:00:00', '2024-09-30T10:00:00'),  -- Matemáticas
(2, 4, 3, 1, 'MIÉRCOLES', '2024-10-02T10:00:00', '2024-10-02T12:00:00'), -- Física
(3, 5, 3, 1, 'LUNES', '2024-09-30T10:30:00', '2024-09-30T12:30:00'); -- Programación
