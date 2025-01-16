package com.vinay.hibernate.demo.crud;

import com.vinay.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            System.out.println("Creating new Student Object...");
            Student student = new Student("Vinay", "Shanigarapu", "vinayshanigarapu05@gmail.com");

            // Start the transaction
            session.beginTransaction();

            // Save the student object
            System.out.println("Saving the student details...");
            session.save(student);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!!!");

        }finally {
            factory.close();
        }
    }
}
