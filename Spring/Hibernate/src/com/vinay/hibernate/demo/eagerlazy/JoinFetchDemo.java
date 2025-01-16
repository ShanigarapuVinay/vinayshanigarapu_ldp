package com.vinay.hibernate.demo.eagerlazy;

import com.vinay.hibernate.demo.entity2.Course;
import com.vinay.hibernate.demo.entity2.Instructor;
import com.vinay.hibernate.demo.entity2.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class JoinFetchDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("onetomany.hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Start the transaction
            session.beginTransaction();

            // get Instructor by id
            int id = 1;

            // Method 2 : Using JOIN FETCH
            Query<Instructor> query = session.createQuery("select i from Instructor i "
                    + "JOIN FETCH i.courses "
                    + "where i.id = :instructorId", Instructor.class);
            query.setParameter("instructorId", id);

            Instructor instructor = query.getSingleResult();

            System.out.println("Instructor: " + instructor);

            // Commit the transaction
            session.getTransaction().commit();

            // close the session
            session.close();
            System.out.println("\nThe session is closed...\n");

            System.out.println("Course: " + instructor.getCourses());

            System.out.println("Done!!!");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}