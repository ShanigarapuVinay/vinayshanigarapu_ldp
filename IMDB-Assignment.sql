# IMDB
CREATE DATABASE IF NOT EXISTS imdb;
USE imdb;

CREATE TABLE Movie (
    MovieID INT PRIMARY KEY,
    Title VARCHAR(20),
    ReleaseDate DATE,
    Genre VARCHAR(20),
    Duration INT
);

CREATE TABLE TVSeries (
    TVSeriesID INT PRIMARY KEY,
    Title VARCHAR(20),
    Genre VARCHAR(20),
    Seasons INT
);

CREATE TABLE Actor (
    ActorID INT PRIMARY KEY,
    Name VARCHAR(20),
    Nationality VARCHAR(10)
);

-- Table for MovieActor (Junction table for many-to-many relationship between Movie and Actor)
CREATE TABLE MovieActor (
    MovieActorID INT PRIMARY KEY,
    MovieID INT,
    ActorID INT,
    Role VARCHAR(10),
    FOREIGN KEY (MovieID) REFERENCES Movie(MovieID),
    FOREIGN KEY (ActorID) REFERENCES Actor(ActorID)
);

-- Table for TVSeriesActor (Junction table for many-to-many relationship between TV Series and Actor)
CREATE TABLE TVSeriesActor (
    TVSeriesActorID INT PRIMARY KEY,
    TVSeriesID INT,
    ActorID INT,
    Role VARCHAR(20),
    FOREIGN KEY (TVSeriesID) REFERENCES TVSeries(TVSeriesID),
    FOREIGN KEY (ActorID) REFERENCES Actor(ActorID)
);