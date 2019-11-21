CREATE USER IF NOT EXISTS 'mharrop'@'localhost' IDENTIFIED BY 'mharrop';

DROP DATABASE IF EXISTS BOOKSDB;
CREATE DATABASE BOOKSDB;
USE BOOKSDB;
GRANT ALL PRIVILEGES ON BOOKSDB.* TO 'mharrop'@'localhost';
FLUSH PRIVILEGES;

/*in case of java.sql.SQLException: The server timezone value 'UTC' is unrecognized or represents more than one timezone. */
SET GLOBAL time_zone = '+5:00';