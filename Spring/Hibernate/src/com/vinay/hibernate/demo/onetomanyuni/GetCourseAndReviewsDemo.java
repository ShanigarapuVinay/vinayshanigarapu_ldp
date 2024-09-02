package com.vinay.hibernate.demo.onetomanyuni;

import com.vinay.hibernate.demo.entity3.Course;
import com.vinay.hibernate.demo.entity3.Instructor;
import com.vinay.hibernate.demo.entity3.InstructorDetail;
import com.vinay.hibernate.demo.entity3.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("onetomanyuni.hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Start the transaction
            session.beginTransaction();

            int id = 10;
            Course course = session.get(Course.class, id);

            System.out.println("Course: " + course);
            System.out.println("Reviews: " + course.getReviews());

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
