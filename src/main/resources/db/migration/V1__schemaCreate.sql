/*Write a initial schema of an users table with the following columns: (check if the table already exists before creating it)
id: UUID, primary key
name: string, not null, restricted to 50 characters
email: string, not null, unique
password: string, not null, restricted to 50 characters
 */
CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL
);