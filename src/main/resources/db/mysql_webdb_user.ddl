GRANT USAGE ON *.* TO 'webdb'@'localhost';
DROP USER 'webdb'@'localhost';
CREATE USER 'webdb'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES on webdb.* to 'webdb'@'localhost' identified by 'webdb';