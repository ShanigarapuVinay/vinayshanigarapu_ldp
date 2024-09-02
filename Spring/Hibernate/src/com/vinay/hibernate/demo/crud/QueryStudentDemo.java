package com.vinay.hibernate.demo.crud;

import com.vinay.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            // Start the transaction
            session.beginTransaction();

            // query students
            List students = session.createQuery("from Student").getResultList();
            System.out.println("All Students...");
            displayStudents(students);

            // query students: lastName - Shanigarapu
            students = session.createQuery("from Student s where s.lastName='Shanigarapu'").getResultList();
            System.out.println("Students with Last Name \"Shanigarapu\"...");
            displayStudents(students);

            // query students with lastName - Shanigarapu OR firstName - Lahari
            students = session.createQuery("from Student s where s.lastName = 'Shanigarapu' "+
                    "OR s.firstName ='Lahari'").getResultList();
            System.out.println("Students with Last Name \"Shanigarapu\" OR First Name \"Lahari\"");
            displayStudents(students);

            // query students where email LIKE '%gmail.com'
            students = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
            System.out.println("Students with email like \"gmail.com\"");
            displayStudents(students);
            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!!!");

        }finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for(Student stud : students)
            System.out.println(stud);
    }
}
