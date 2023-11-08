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

INSERT INTO ManagerView VALUES ("CoffeeGrounds", 50, NULL, "Inventory");
INSERT INTO ManagerView VALUES ("Lattee", NULL, 3.50, "Price Check");

CREATE TABLE CustomerLine(
	Fname VARCHAR(50),
    Lname VARCHAR(50),
    OrderDescription MEDIUMTEXT,
	BeingWorkedOn BOOLEAN
);

INSERT INTO CustomerLine VALUES ("Bob", "Smith", "Latte and a cookie", FALSE);
INSERT INTO CustomerLine VALUES ("Dave", "Lee", "Mocha and a sandwhich", FALSE);

SELECT * FROM my_coffee_shop.CustomerLine;
SELECT * FROM my_coffee_shop.managerview;
SELECT * FROM my_coffee_shop.coffeeshoporders;
