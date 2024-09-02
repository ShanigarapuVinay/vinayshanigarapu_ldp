package com.vinay.hibernate.demo.onetooneuni;

import com.vinay.hibernate.demo.entity.Instructor;
import com.vinay.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("one-to-one-uni.hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
//            Instructor instructor = new Instructor("Bhavish", "Reddy", "bhavishreddi06@gmail.com");
//
//            InstructorDetail instructorDetail = new InstructorDetail("BhavishBuster", "Writing Novels");
//
//            instructor.setInstructorDetail(instructorDetail);
//            // Start the transaction
//            session.beginTransaction();
//
//            System.out.println("Saving " + instructor);
//            session.save(instructor);
//
//            // Commit the transaction
//            session.getTransaction().commit();

            // Delete
            session.beginTransaction();

            int id = 3;

            Instructor inst = session.get(Instructor.class, id);

            if (inst != null) {
                System.out.println("Deleting " + inst);
                session.delete(inst);
            } else {
                System.out.println("No Instructor Found with id: " + id);
            }

            session.getTransaction().commit();

            System.out.println("Done!!!");

        } finally {
            factory.close();
        }
    }
}
