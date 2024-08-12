# IRCTC
CREATE DATABASE IF NOT EXISTS irctc;
USE irctc;

CREATE TABLE Train (
    TrainID VARCHAR(20) PRIMARY KEY,
    TrainName VARCHAR(20),
    Source VARCHAR(45),
    Destination VARCHAR(45),
    DepartureTime DATETIME,
    ArrivalTime DATETIME
);

CREATE TABLE Customer (
    CustomerID VARCHAR(20) PRIMARY KEY,
    Name VARCHAR(20),
    Email VARCHAR(20),
    PhoneNumber BIGINT
);

CREATE TABLE Ticket (
    TicketID VARCHAR(20) PRIMARY KEY,
    TicketStatus VARCHAR(20),
    ReservationTime DATETIME,
    TrainID VARCHAR(20),
    CustomerID VARCHAR(20),
    FOREIGN KEY (TrainID) REFERENCES Train(TrainID),
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);