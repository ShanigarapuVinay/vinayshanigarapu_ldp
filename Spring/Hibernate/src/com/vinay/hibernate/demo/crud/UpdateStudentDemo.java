package com.vinay.hibernate.demo.crud;

import com.vinay.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            int id = 1;
            System.out.println("Updating Student with id: " + id);
            Student student = session.get(Student.class, id);
            System.out.println("Before Updating " + student);

            student.setFirstName("Vinay2.0");
            System.out.println("After Updating " + student);
            // Commit the transaction
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            int studId = 2;

            //updating email for specific student
            System.out.println("Updating email for id: " + studId);
            session.createQuery("update Student set email = :email where id = :studentId")
                    .setParameter("email", "vinaylahari999@yahoo.com")
                    .setParameter("studentId", studId)
                    .executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!!!");

        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student stud : students)
            System.out.println(stud);
    }
}
