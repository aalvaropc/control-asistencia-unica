-- Crear las tablas
CREATE TABLE app_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    username VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
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

CREATE TABLE schedule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    course_id BIGINT,
    department_id BIGINT,
    professor_id BIGINT,
    weekday VARCHAR(10),
    start_time TIME,
    end_time TIME,
    FOREIGN KEY (course_id) REFERENCES course(id),
    FOREIGN KEY (department_id) REFERENCES department(id),
    FOREIGN KEY (professor_id) REFERENCES professor(id)
);

CREATE TABLE attendancy (
    id BIGINT AUTO_INCREMENT,
    schedule_id BIGINT,
    start_time TIMESTAMP,
    is_present BIGINT,
    FOREIGN KEY (schedule_id) REFERENCES schedule(id)
);

-- Insertar usuarios
INSERT INTO app_user (id, first_name, last_name, username, email, password, phone_number, role, last_login, status)
VALUES
(1, 'Jhon', 'Lovera', 'jhonl', 'jhon@example.com', '12345', '123456789', 'PROFESSOR', CURRENT_TIMESTAMP, 'ACTIVE'),
(2, 'Jessica', 'Puchuri', 'jessicap', 'jessica@example.com', '1234', '987654321', 'PROFESSOR', CURRENT_TIMESTAMP, 'ACTIVE'),
(3, 'Carmen', 'Pineda', 'carmenp', 'carmen@example.com', '123','555555555', 'PROFESSOR', CURRENT_TIMESTAMP, 'ACTIVE');

-- Insertar facultades
INSERT INTO faculty (id, acronym, name, email, password_hash, created_at, updated_at, last_login)
VALUES
(1, 'FIS', 'Facultad de Ingeniería de Sistemas', 'fis@example.com', 'hashed_password_1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Insertar departamentos - escuela
INSERT INTO department (id, name, description, created_at, updated_at, faculty_id)
VALUES
(1, 'Escuela de Ingenieria de Sistemas', 'Descripción del departamento de ingeniería', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);

-- Insertar cursos
INSERT INTO course (id, name, description, department_id)
VALUES
(1, 'ANÁLISIS Y DISEÑO DE ARQUITECTURA EMPRESARIAL', 'Curso básico de psicología', 1),
(2, 'CONTROL DE CALIDAD Y PRUEBAS DE SOFTWARE',' DISEÑO E IMPLEMENTACIÓN DE SISTEMAS', 1),
(3, 'DISEÑO E IMPLEMENTACIÓN DE SISTEMAS', 'Curso avanzado de matemáticas', 1),
(4, 'GERENCIA DE PROYECTOS TI', 'GERENCIA DE PROYECTOS TI', 1),
(5, 'INGENIERÍA DE PROCESOS DE NEGOCIO', 'INGENIERÍA DE PROCESOS DE NEGOCIO', 1);

-- Insertar profesores
INSERT INTO professor (id, user_id, department_id, hire_date)
VALUES
(1, 1, 1, CURRENT_TIMESTAMP),
(2, 2, 1, CURRENT_TIMESTAMP),
(3, 3, 1, CURRENT_TIMESTAMP);

-- Insertar horarios
INSERT INTO schedule (id, course_id, department_id, professor_id, weekday, start_time, end_time)
VALUES
(1, 1, 1, 1, 'LUNES', '08:00:00', '10:00:00'),
(2, 2, 1, 1, 'MIÉRCOLES', '10:00:00', '12:00:00'),
(3, 3, 1, 1, 'LUNES', '18:30:00', '20:30:00'),
(4, 4, 1, 2, 'MIÉRCOLES', '18:30:00', '20:30:00'),
(5, 5, 1, 2, 'LUNES', '18:30:00', '20:30:00');

-- Insertar registros de asistencia
INSERT INTO attendancy (id, schedule_id, start_time, is_present)
VALUES
(1, 1, '2024-10-05T10:00:00',0),
(2, 2, '2024-10-05T10:00:00',1),
(3, 3, '2024-10-05T10:00:00',1);


