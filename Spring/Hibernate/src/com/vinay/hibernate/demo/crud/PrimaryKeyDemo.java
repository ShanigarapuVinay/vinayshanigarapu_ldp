package com.vinay.hibernate.demo.crud;

import com.vinay.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            System.out.println("Creating 3 Student Object...");
            Student student1 = new Student("Lahari", "Challagulla", "laharivinay715@gmail.com");
            Student student2 = new Student("Virat", "Kohli", "viratkohli18@gmail.com");
            Student student3 = new Student("Rohit", "Sharma", "rohitsharma45@gmail.com");
            // Start the transaction
            session.beginTransaction();

            // Save the student object
            System.out.println("Saving the student details...");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!!!");

        }finally {
            factory.close();
        }
    }
}
