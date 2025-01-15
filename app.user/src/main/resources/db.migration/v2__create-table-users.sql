CREATE TABLE users (
    id VARCHAR(255) PRIMARY KEY NOT NULL UNIQUE,
    login VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL);
    
    INSERT INTO users (login, password, role)  
VALUES ('usuario_admin', '$2a$12$swLZnlsz1Bo9IgHva8RYxeHinzZGdQouVZ2hmgq8LnVvOezFYw1yi', 'ROLE_ADMIN');