package com.assignment12;

import java.util.*;
import java.util.stream.Collectors;

class Student{
    private final int id;
    private final String name;
    private final int age;
    private final String gender;
    private final String engDepartment;
    private final int year;
    private final double perTillDate;

    public Student(int id, String name, int age, String gender, String engDepartment, int year, double perTillDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.engDepartment = engDepartment;
        this.year = year;
        this.perTillDate = perTillDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEngDepartment() {
        return engDepartment;
    }

    public int getYear() {
        return year;
    }

    public double getPerTillDate() {
        return perTillDate;
    }
}
public class StudentStream {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8),
                new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2),
                new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3),
                new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80),
                new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70),
                new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70),
                new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70),
                new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80),
                new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85),
                new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82),
                new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83),
                new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4),
                new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6),
                new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8),
                new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4),
                new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4),
                new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5)
        );
        // 1. Print the name of all departments in the college?
        System.out.println("1. Departments in the college are:");
        students.stream().map(Student::getEngDepartment).distinct().forEach(System.out::println);
        System.out.println();

        // 2. Get the names of all students who have enrolled after 2018?
        List<String> listAfter2018 = students.stream().filter(student -> student.getYear() > 2018).map(Student::getName).collect(Collectors.toList());
        System.out.println("2. Names of all students who have enrolled after 2018: " + listAfter2018);
        System.out.println();

        // 3. Get the details of all male student in the computer sci department?
        System.out.println("3. Details of all Male students in the Computer Science Department: ");
        students.stream()
                .filter(student -> student.getGender().equals("Male") && student.getEngDepartment().equals("Computer Science"))
                .forEach(student -> System.out.printf("Id: %d, Name: %s, Age: %d, Year: %d, Percentage: %.2f\n",
                        student.getId(),
                        student.getName(),
                        student.getAge(),
                        student.getYear(),
                        student.getPerTillDate()));
        System.out.println();

        // 4. How many male and female student are there ? (HINT:use Collectors.groupingBy() for grouping based on gender)
        System.out.println("4. Gender Count using groupingBy: ");
        Map<String, Long> genderCount = students.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        genderCount.forEach((gender, count) -> System.out.println(gender + ": " + count));
        System.out.println();

        // 5. What is the average age of male and female students?
        System.out.println("5. Average age of male and female students:");
        Map<String, Double> avgAgeByGender = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGender,
                        Collectors.averagingDouble(Student::getAge)
                ));
        avgAgeByGender.forEach((gender, avg) -> System.out.println(gender + ": " + avg));
        System.out.println();

        // 6. Get the details of student having highest percentage ?
        System.out.println("6. Details of Student with Highest Percentage: ");
        Student studentWithHighestPercentage = students.stream()
                .max(Comparator.comparing(Student::getPerTillDate))
                .orElse(null);
        System.out.printf("Id: %d, Name: %s, Age: %d, Gender: %s, Department: %s, Year: %d, Percentage: %.2f\n",
                studentWithHighestPercentage.getId(),
                studentWithHighestPercentage.getName(),
                studentWithHighestPercentage.getAge(),
                studentWithHighestPercentage.getGender(),
                studentWithHighestPercentage.getEngDepartment(),
                studentWithHighestPercentage.getYear(),
                studentWithHighestPercentage.getPerTillDate());
        System.out.println();

        // 7. Count the number of students in each department? (Hint :use Collectors.groupingBy())
        System.out.println("7. Number of students in each Department: ");
        Map<String, Long> studentCount = students.stream().collect(Collectors.groupingBy(Student::getEngDepartment, Collectors.counting()));
        studentCount.forEach((dep, count) -> System.out.println(dep + ": " + count));
        System.out.println();

        // 8. What is the average percentage achieved in each department?
        System.out.println("8. Average percentage achieved in each Department:");
        Map<String, Double> averagePerInEachDep = students.stream().collect(Collectors.groupingBy(Student::getEngDepartment, Collectors.averagingDouble(Student::getPerTillDate)));
        averagePerInEachDep.forEach((dept, avgPercentage) ->
                System.out.println(dept + ": " + String.format("%.2f", avgPercentage) + "%"));
        System.out.println();

        // 9. Get the details of the youngest male student in the Electronic department?(Hint :Use Collectors.minBy)
        System.out.println("9. Details of Youngest Male Student in the Electronic Department:");
        Optional<Student> youngestStudent = students.stream().filter(student -> student.getGender().equals("Male") && student.getEngDepartment().equals("Electronic"))
                .collect(Collectors.minBy(Comparator.comparing(Student::getAge)));
        youngestStudent.ifPresent(info -> System.out.printf("Id: %d, Name: %s, Age: %d, Gender: %s, Department: %s, Year: %d, Percentage: %.2f\n",
                info.getId(),
                info.getName(),
                info.getAge(),
                info.getGender(),
                info.getEngDepartment(),
                info.getYear(),
                info.getPerTillDate()));
        System.out.println();

        // 10. How many male and female students are there in the computer science department?
        System.out.println("10. The Count of Male and Female students in the Computer Science Department:");
        Map<String, Long> sciStudentCount = students.stream()
                .filter(student -> student.getEngDepartment().equals("Computer Science"))
                .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        sciStudentCount.forEach((gender, count) -> System.out.println(gender + ": " + count));
    }
}
