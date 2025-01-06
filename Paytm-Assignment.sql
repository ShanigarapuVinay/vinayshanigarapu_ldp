# Paytm
CREATE DATABASE IF NOT EXISTS paytm;
USE paytm;

CREATE TABLE Branch (
    BranchID INT PRIMARY KEY,
    BranchName VARCHAR(10),
    Location VARCHAR(20)
);

CREATE TABLE Customer (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR(20),
    Email VARCHAR(20),
    PhoneNumber BIGINT,
    Address VARCHAR(45)
);

CREATE TABLE Account (
    AccountID INT PRIMARY KEY,
    AccountType ENUM('Savings', 'Checking'),
    Balance DECIMAL(10, 2),
    BranchID INT,
    CustomerID INT,
    FOREIGN KEY (BranchID) REFERENCES Branch(BranchID),
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
    CONSTRAINT UC_Account UNIQUE (BranchID, CustomerID)
);
