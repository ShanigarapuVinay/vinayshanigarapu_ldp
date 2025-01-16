package com.vinay.hibernate.demo.crud;

import com.vinay.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            // Method 1
            Student student = session.get(Student.class, 5);
            System.out.println("Deleting " + student);
            session.delete(student);

            // Method 2
            session.createQuery("delete from Student where id = :id")
                    .setParameter("id", 4)
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
