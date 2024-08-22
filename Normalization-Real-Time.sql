CREATE DATABASE IF NOT EXISTS normalisation;
USE normalisation;

CREATE TABLE Student (
    StudentID INT PRIMARY KEY,
    StudentName VARCHAR(100) NOT NULL
);

CREATE TABLE Instructor (
    InstructorID INT PRIMARY KEY,
    Instructor VARCHAR(100) NOT NULL,
    InstructorPhone VARCHAR(15) NOT NULL
);

CREATE TABLE Course (
    CourseID INT PRIMARY KEY,
    CourseName VARCHAR(100) NOT NULL,
    InstructorID INT,
    FOREIGN KEY (InstructorID) REFERENCES Instructor(InstructorID)
);

CREATE TABLE Enrollment (
    StudentID INT,
    CourseID INT,
    PRIMARY KEY (StudentID, CourseID),
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Course(CourseID)
);

INSERT INTO Student (StudentID, StudentName) VALUES
(1, 'Vinay'),
(2, 'Lahari');

INSERT INTO Instructor (InstructorID, Instructor, InstructorPhone) VALUES
(1, 'Dr. Robert', '9999999999'),
(2, 'Dr. Jon', '8888888888'),
(3, 'Dr. Nick', '7777777777');

INSERT INTO Course (CourseID, CourseName, InstructorID) VALUES
(101, 'Java', 1),
(102, 'Cpp', 2),
(103, 'React', 3);

INSERT INTO Enrollment (StudentID, CourseID) VALUES
(1, 101),
(1, 102),
(2, 101),
(2, 103);


## Basic Queries
# 1. Retrieve all students and their enrolled courses:
SELECT s.StudentName, c.CourseName
FROM Student s
JOIN Enrollment e ON s.StudentID = e.StudentID
JOIN Course c ON e.CourseID = c.CourseID;

# 2. List all courses along with their instructors:
SELECT c.CourseName, i.Instructor, i.InstructorPhone
FROM Course c
JOIN Instructor I on c.InstructorID = i.InstructorID;

# 3. Find all courses taken by a specific student (e.g., Lahari):
SELECT s.StudentName, c.CourseName
FROM Student s
JOIN Enrollment e ON s.StudentID = e.StudentID
JOIN Course c ON e.CourseID = c.CourseID
WHERE s.StudentName = "Lahari";

# 4. Find the instructor and their phone number for a specific course (e.g., Cpp)
SELECT i.Instructor, i.InstructorPhone
FROM Instructor i
JOIN Course c ON i.InstructorID = c.InstructorID
WHERE c.CourseName = "Cpp";

# 5. List all students with their enrolled courses and the corresponding instructor's name:
SELECT s.StudentName, c.CourseName, i.Instructor
FROM Student s
JOIN Enrollment e ON s.StudentID = e.StudentID
JOIN Course c ON e.CourseID = c.CourseID
JOIN Instructor i ON c.InstructorID = i.InstructorID;
