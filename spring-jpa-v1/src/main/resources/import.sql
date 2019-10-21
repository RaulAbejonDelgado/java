INSERT INTO partners( name, surname, email, create_at, photo) VALUES('drohne','Enhord','drohne@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('pepone','toblerone','pepone@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('Rul','Rul','rul@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('BugFixer','BugFixer','BugFixer@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('qwerty','qwerty','qwerty@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('Enhord','Enhord','Enhord@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('drohne','Enhord','drohne@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('pepone','toblerone','pepone@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('Rul','Rul','rul@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('BugFixer','BugFixer','BugFixer@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('qwerty','qwerty','qwerty@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('Enhord','Enhord','Enhord@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('drohne','Enhord','drohne@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('pepone','toblerone','pepone@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('Rul','Rul','rul@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('BugFixer','BugFixer','BugFixer@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('qwerty','qwerty','qwerty@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('Enhord','Enhord','Enhord@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('drohne','Enhord','drohne@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('pepone','toblerone','pepone@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('Rul','Rul','rul@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('BugFixer','BugFixer','BugFixer@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('qwerty','qwerty','qwerty@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('Enhord','Enhord','Enhord@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('drohne','Enhord','drohne@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('pepone','toblerone','pepone@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('Rul','Rul','rul@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('BugFixer','BugFixer','BugFixer@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('qwerty','qwerty','qwerty@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('Enhord','Enhord','Enhord@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('drohne','Enhord','drohne@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('pepone','toblerone','pepone@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('Rul','Rul','rul@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('BugFixer','BugFixer','BugFixer@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('qwerty','qwerty','qwerty@gmail.com','2019-10-11', '');
INSERT INTO partners( name, surname, email, create_at, photo) VALUES('Enhord','Enhord','Enhord@gmail.com','2019-10-11', '');


/*Products*/

INSERT INTO products (name, price, create_at) VALUES('Keyboard',10.00,NOW());
INSERT INTO products (name, price, create_at) VALUES('Mouse',7.00,NOW());
INSERT INTO products (name, price, create_at) VALUES('Monitor',65.00,NOW());

/*SaleOrders*/
INSERT INTO sales_order(description, obserbation,partner_id, create_at) VALUES('Office material',null,1, NOW());
INSERT INTO sale_order_line(quantiy, product_id, sale_order_id) VALUES(3,1,1);
INSERT INTO sale_order_line(quantiy, product_id, sale_order_id) VALUES(3,2,1);
INSERT INTO sale_order_line(quantiy, product_id, sale_order_id) VALUES(1,3,1);

INSERT INTO sales_order(description, obserbation,partner_id, create_at) VALUES('Monitor',null,1, NOW());
INSERT INTO sale_order_line(quantiy, product_id, sale_order_id) VALUES(2,3,2);