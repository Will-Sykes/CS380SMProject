DROP DATABASE IF EXISTS my_coffee_shop;
CREATE DATABASE my_coffee_shop;
USE my_coffee_shop;

CREATE TABLE CoffeeShopOrders(
	Fname VARCHAR(50),
    Lname VARCHAR(50),
    OrderDescription MEDIUMTEXT,
    Price DOUBLE
);

INSERT INTO CoffeeShopOrders VALUES ("Bob", "Smith", "Lattee with a cookie", 6.50);


CREATE TABLE ManagerView (
	Product VARCHAR(1000),
    Price double,
    Quantity INT,
    Category VARCHAR(50)
);

INSERT INTO ManagerView VALUES ("CoffeeGrounds", NULL, 40, "Inventory");
INSERT INTO ManagerView VALUES ("Latte", 3.50, NULL, "Price Check");
INSERT INTO ManagerView VALUES ("Macchiato", 4.25, NULL, "Price Check");
INSERT INTO ManagerView VALUES ("Hot Chocolate", 2.50, NULL, "Price Check");
INSERT INTO ManagerView VALUES ("Frappee", 3.75, NULL, "Price Check");
INSERT INTO ManagerView VALUES ("Americano", 3.50, NULL, "Price Check");
INSERT INTO ManagerView VALUES ("Cappuccino", 3.50, NULL, "Price Check");
INSERT INTO ManagerView VALUES ("Italian Soda", 4.00, NULL, "Price Check");
INSERT INTO ManagerView VALUES ("Muffin", 4.25, NULL, "Price Check");
INSERT INTO ManagerView VALUES ("Doughnut", 4.50, NULL, "Price Check");
INSERT INTO ManagerView VALUES ("Bagel", 5.00, NULL, "Price Check");
INSERT INTO ManagerView VALUES ("Cookie", 4.50, NULL, "Price Check");
INSERT INTO ManagerView VALUES ("Sandwhiches", 5.25, NULL, "Price Check");

CREATE TABLE CustomerLine(
	Fname VARCHAR(50),
    Lname VARCHAR(50),
    OrderDescription MEDIUMTEXT,
	BeingWorkedOn BOOLEAN
);



INSERT INTO CustomerLine VALUES ("Bob", "Smith", "Latte and a cookie", FALSE);
INSERT INTO CustomerLine VALUES ("Dave", "Lee", "Mocha and a sandwhich", FALSE);

CREATE TABLE Employees(
	Fname VARCHAR(50),
    Lname VARCHAR(50),
    EmployeeID VARCHAR(15),
    Permission Int
);

INSERT INTO Employees VALUES ("Devlin", "Hamill", "213", 2);
INSERT INTO Employees VALUES("William","Sykes","321",3);

SELECT * FROM my_coffee_shop.CustomerLine;
SELECT * FROM my_coffee_shop.managerview;
SELECT * FROM my_coffee_shop.coffeeshoporders;
SELECT * FROM my_coffee_shop.Employees;
