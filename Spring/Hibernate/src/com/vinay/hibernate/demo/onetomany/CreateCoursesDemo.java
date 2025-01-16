package com.vinay.hibernate.demo.onetomany;

import com.vinay.hibernate.demo.entity2.Course;
import com.vinay.hibernate.demo.entity2.Instructor;
import com.vinay.hibernate.demo.entity2.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("onetomany.hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            // Start the transaction
            session.beginTransaction();

            // get the Instructor
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);

            // create Courses
            Course course1 = new Course("Java");
            Course course2 = new Course("Spring");

            // add the courses to instructor
            instructor.add(course1);
            instructor.add(course2);

            // save courses in database
            session.save(course1);
            session.save(course2);

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
