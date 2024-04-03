-- Заполнение таблицы employees
INSERT INTO employees (first_name, last_name, email) VALUES
('John', 'Doe', 'john.doe@example.com'),
('Jane', 'Smith', 'jane.smith@example.com'),
('Alice', 'Johnson', 'alice.johnson@example.com'),
('Michael', 'Johnson', 'michael.johnson@example.com'),
('Emily', 'Brown', 'emily.brown@example.com'),
('William', 'Jones', 'william.jones@example.com');

-- Заполнение таблицы role
INSERT INTO role (name) VALUES
('ROLE_ADMIN'),
('ROLE_USER');

-- Заполнение таблицы user
INSERT INTO user (first_name, last_name, email, password) VALUES
('John', 'Doe', 'john.doe@example.com', '$2y$10$/u2w00vox2Dv.YILbNoiuOxZ1P8Tvr74h/2x9TM4IG6Ox4pb5YW4i'),
('Jane', 'Smith', 'jane.smith@example.com', '$2y$10$/u2w00vox2Dv.YILbNoiuOxZ1P8Tvr74h/2x9TM4IG6Ox4pb5YW4i'),
('Alice', 'Johnson', 'alice.johnson@example.com', '$2y$10$/u2w00vox2Dv.YILbNoiuOxZ1P8Tvr74h/2x9TM4IG6Ox4pb5YW4i');

-- Связи пользователей с ролями
INSERT INTO users_roles (user_id, role_id) VALUES
(1, 1), -- John Doe - ROLE_ADMIN
(2, 2); -- Jane Smith - ROLE_USER
