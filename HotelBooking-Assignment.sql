# Hotel Booking
CREATE DATABASE IF NOT EXISTS hotelbooking;
USE hotelbooking;

CREATE TABLE Hotel(
	HotelID INT PRIMARY KEY,
    HotelName VARCHAR(20),
    Location VARCHAR(45),
    Rating DECIMAL
);

CREATE TABLE Customer(
	CustomerID INT PRIMARY KEY,
    Name VARCHAR(20),
    Email VARCHAR(20),
    Phone BIGINT,
    CustomerType VARCHAR(10),
    HotelID INT,
    FOREIGN KEY (HotelID) REFERENCES Hotel(HotelID)
);