DROP DATABASE IF EXISTS my_coffee_shop;
CREATE DATABASE my_coffee_shop;
USE my_coffee_shop;

CREATE TABLE CoffeeShopOrders(
	Fname VARCHAR(50) NOT NULL,
    Lname VARCHAR(50) NOT NULL,
    OrderDescription MEDIUMTEXT NOT NULL,
    Price DOUBLE NOT NULL
);

INSERT INTO CoffeeShopOrders VALUES ("Bob", "Smith", "Latte and a cookie", 6.50);


CREATE TABLE ManagerView (
	Product VARCHAR(1000) NOT NULL,
    Price double,
    Quantity INT,
    Category VARCHAR(50) NOT NULL
);

INSERT INTO ManagerView VALUES ("Coffee Grounds", NULL, 40, "Inventory");
INSERT INTO ManagerView VALUES ("Coffee Filters", NULL, 35, "Inventory");
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
	Fname VARCHAR(50) NOT NULL,
    Lname VARCHAR(50) NOT NULL,
    OrderDescription MEDIUMTEXT NOT NULL,
	BeingWorkedOn BOOLEAN NOT NULL
);



INSERT INTO CustomerLine VALUES ("Bob", "Smith", "Latte and a cookie", TRUE);
INSERT INTO CustomerLine VALUES ("Dave", "Lee", "Mocha and a sandwhich", FALSE);

CREATE TABLE Employees(
	Fname VARCHAR(50) NOT NULL,
    Lname VARCHAR(50) NOT NULL,
    EmployeeID VARCHAR(15) NOT NULL,
    Permission Int
);

INSERT INTO Employees VALUES ("devlin", "hamill", "213", 2);
INSERT INTO Employees VALUES("william","sykes","321",3);

SELECT * FROM my_coffee_shop.CustomerLine;
SELECT * FROM my_coffee_shop.managerview;
SELECT * FROM my_coffee_shop.coffeeshoporders;
SELECT * FROM my_coffee_shop.Employees;
