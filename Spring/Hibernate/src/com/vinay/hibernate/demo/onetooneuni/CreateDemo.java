package com.vinay.hibernate.demo.onetooneuni;

import com.vinay.hibernate.demo.entity.Instructor;
import com.vinay.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("one-to-one-uni.hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            Instructor instructor = new Instructor("Vinay", "Shanigarapu", "vinayshanigarapu05@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail("Vinay's Lab", "Development");

//            Instructor instructor = new Instructor("Lahari", "Challagulla", "laharivinay715@gmail.com");
//
//            InstructorDetail instructorDetail = new InstructorDetail("Vinay's Lab", "Watching Movies");

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

        }finally {
            factory.close();
        }
    }
}
