CREATE TABLE employees (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           first_name VARCHAR(255),
                           last_name VARCHAR(255),
                           email VARCHAR(255)
);

CREATE TABLE role (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255)
);

CREATE TABLE user (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      first_name VARCHAR(255),
                      last_name VARCHAR(255),
                      email VARCHAR(255) UNIQUE,
                      password VARCHAR(255)
);

CREATE TABLE users_roles (
                             user_id BIGINT,
                             role_id BIGINT,
                             FOREIGN KEY (user_id) REFERENCES user(id),
                             FOREIGN KEY (role_id) REFERENCES role(id),
                             PRIMARY KEY (user_id, role_id)
);
