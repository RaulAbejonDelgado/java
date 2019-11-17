INSERT INTO users (username,password,enabled,name,email,surname,logging_tries) VALUES('drohne','$2a$10$r1ENt2ARboU7ltAv5lJtTuzeEmesRiOU5sYgGb66h0sNw3eNTUb5W',true,'drohne','drohne@gmail.com','xxxx',0)
INSERT INTO users (username,password,enabled,name,email,surname,logging_tries) VALUES('rultest','$2a$10$r1ENt2ARboU7ltAv5lJtTuzeEmesRiOU5sYgGb66h0sNw3eNTUb5W',true,'rultest','rultest@gmail.com','xxxx',0)

INSERT INTO roles (name) VALUES ('ROLE_USER')
INSERT INTO roles (name) VALUES ('ROLE_ADMIN')

INSERT INTO users_roles (user_id,role_id) VALUES(1,2)
INSERT INTO users_roles (user_id,role_id) VALUES(2,1)