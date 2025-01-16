package com.vinay.hibernate.demo.manytomany;

        import com.vinay.hibernate.demo.entity4.*;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.cfg.Configuration;

public class AddCoursesForLahari {
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
            // create Course
            Course course1 = new Course("React");
            Course course2 = new Course("Spring");

            // add student to courses
            course1.addStudent(student);
            course2.addStudent(student);

            System.out.println("Saving the Courses...");
            session.save(course1);
            session.save(course2);
            System.out.println("Saved the Courses Successfully...");


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
