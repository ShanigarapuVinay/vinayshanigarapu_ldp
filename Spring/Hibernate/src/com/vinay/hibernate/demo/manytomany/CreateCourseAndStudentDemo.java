package com.vinay.hibernate.demo.manytomany;

import com.vinay.hibernate.demo.entity4.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentDemo {
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

            // create Course
            Course course = new Course("Java");

            System.out.println("Saving the Course: " + course);
            session.save(course);
            System.out.println("Saved the Course: " + course);

            // create a students
            Student student1 = new Student("Vinay", "Shanigarapu", "vinayshanigarapu05@gmail.com");
            Student student2 = new Student("Lahari", "Challagulla", "laharivinay715@gmail.com");

            // add the students to course
            course.addStudent(student1);
            course.addStudent(student2);

            // save the students
            System.out.println("Saving students...");
            session.save(student1);
            session.save(student2);
            System.out.println("Saved the students successfully!!!");
            System.out.println(course.getStudents());

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
