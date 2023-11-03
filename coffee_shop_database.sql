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
INSERT INTO ManagerView VALUES ("Latte", 2.50, NULL, "Price Check");

SELECT * FROM my_coffee_shop.managerview;
SELECT * FROM my_coffee_shop.coffeeshoporders;
