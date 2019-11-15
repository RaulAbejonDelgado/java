INSERT INTO users (username,password,enabled,name,email,surname) VALUES('drohne','123',1,'drohne','drohne@gmail.com','xxxx')
INSERT INTO users (username,password,enabled,name,email,surname) VALUES('drohne2','1233',1,'drohne2','drohne2@gmail.com','xxxx')

INSERT INTO roles (name) VALUES ('ROLE_USER')
INSERT INTO roles (name) VALUES ('ROLE_ADMIN')

INSERT INTO `users_roles` (user_id,role_id) VALUES(1,2)
INSERT INTO `users_roles` (user_id,role_id) VALUES(2,1)