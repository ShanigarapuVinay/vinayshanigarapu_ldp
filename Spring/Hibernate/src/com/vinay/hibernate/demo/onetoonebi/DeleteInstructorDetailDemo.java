package com.vinay.hibernate.demo.onetoonebi;

import com.vinay.hibernate.demo.entity.Instructor;
import com.vinay.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("one-to-one-uni.hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 4;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            System.out.println("Instructor Detail: " + instructorDetail);

            System.out.println("Associated Instructor: " + instructorDetail.getInstructor());

            // remove the associated object reference
            // break bi-directional link
            instructorDetail.getInstructor().setInstructorDetail(null);

            System.out.println("Deleting Instructor Detail: " + instructorDetail);
            session.delete(instructorDetail);

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
