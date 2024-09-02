package com.vinay.hibernate.demo.crud;

import com.vinay.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new Student Object...");
            Student student = new Student("Pranay", "Shanigarapu", "pranayshanigarapu2406@gmail.com");

            // Start the transaction
            session.beginTransaction();

            // Save the student object
            System.out.println("Saving the student details...");
            System.out.println(student);
            session.save(student);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Saved Student, Generated Primary Key: " + student.getId());
            System.out.println("Done!!!");

            // Get the student
            session = factory.getCurrentSession();

            session.beginTransaction();

            System.out.println("\nGetting student details with id: " + student.getId());
            Student std = session.get(Student.class, student.getId());
            System.out.println("Get Request successful details are " + std);

            session.getTransaction().commit();
            System.out.println("Done!!!");

        } finally {
            factory.close();
        }
    }
}
