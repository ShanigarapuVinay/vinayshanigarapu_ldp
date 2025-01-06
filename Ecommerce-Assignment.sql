# Ecommerce
CREATE DATABASE IF NOT EXISTS ecommerce;
USE ecommerce;

CREATE TABLE Supplier (
    SupplierID INT PRIMARY KEY,
    SupplierName VARCHAR(20),
    Email VARCHAR(20),
    Phone BIGINT
);

CREATE TABLE Customer (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR(20),
    Email VARCHAR(20),
    Phone BIGINT,
    Address VARCHAR(20)
);

CREATE TABLE Items (
    ItemID INT PRIMARY KEY,
    ItemName VARCHAR(20),
    Price DECIMAL(10, 2),
    Quantity INT,
    SupplierID INT,
    FOREIGN KEY (SupplierID) REFERENCES Supplier(SupplierID)
);

CREATE TABLE `Order` (
    OrderID INT PRIMARY KEY,
    OrderDate DATETIME,
    CustomerID INT,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);

-- Table for OrderItem (Junction table for many-to-many relationship)
CREATE TABLE OrderItem (
    OrderItemID INT PRIMARY KEY,
    OrderID INT,
    ItemID INT,
    Quantity INT,
    PriceAtOrder DECIMAL(10, 2),
    FOREIGN KEY (OrderID) REFERENCES `Order`(OrderID),
    FOREIGN KEY (ItemID) REFERENCES Items(ItemID)
);