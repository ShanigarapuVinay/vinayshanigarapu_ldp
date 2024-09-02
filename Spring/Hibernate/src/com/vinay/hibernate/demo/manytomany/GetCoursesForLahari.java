package com.vinay.hibernate.demo.manytomany;

import com.vinay.hibernate.demo.entity4.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForLahari {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("manytomany.hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Start the transaction
            session.beginTransaction();

            // get the student
            int id = 2;
            Student student = session.get(Student.class, id);

            System.out.println("Course for " + student.getFirstName());
            System.out.println(student.getCourses());

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!!!");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
