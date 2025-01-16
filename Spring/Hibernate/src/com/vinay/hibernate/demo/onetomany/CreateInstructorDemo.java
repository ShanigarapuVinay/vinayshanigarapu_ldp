package com.vinay.hibernate.demo.onetomany;

import com.vinay.hibernate.demo.entity2.Course;
import com.vinay.hibernate.demo.entity2.Instructor;
import com.vinay.hibernate.demo.entity2.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("onetomany.hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            Instructor instructor = new Instructor("Deamon", "Targaryen", "deamon@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail("Dragons", "Swinging Swords");

            instructor.setInstructorDetail(instructorDetail);
            // Start the transaction
            session.beginTransaction();

            // Save the Instructor Details
            // Note: This will also save the details object because of the CascadeType.ALL
            System.out.println("Saving "+instructor);
            session.save(instructor);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!!!");

        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
