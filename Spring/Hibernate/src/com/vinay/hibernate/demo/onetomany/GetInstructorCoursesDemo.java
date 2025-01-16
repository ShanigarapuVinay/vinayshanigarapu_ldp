package com.vinay.hibernate.demo.onetomany;

import com.vinay.hibernate.demo.entity2.Course;
import com.vinay.hibernate.demo.entity2.Instructor;
import com.vinay.hibernate.demo.entity2.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetInstructorCoursesDemo {
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

            List<Instructor> instructorList = session.createQuery("from Instructor").getResultList();

            for (Instructor instructor : instructorList) {
                System.out.println(instructor);
                System.out.println(instructor.getCourses());
            }

            // get Instructor by id
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);

            System.out.println("Instructor: " + instructor);
            System.out.println("Course: " + instructor.getCourses());

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
