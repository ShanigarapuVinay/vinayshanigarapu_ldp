package com.vinay.springmvcdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        System.out.printf("First Name: %s\nLastName: %s\nAge: %d\nBranch: %s\n   Fav Programming Language: %s\n",
                student.getFirstName(), student.getLastName(), student.getAge(), student.getBranch(),
                student.getFavoriteLanguage());
        System.out.println("Languages Known: ");
        Arrays.stream(student.getLanguagesKnown()).forEach(lang -> System.out.println(lang));
        return "student-confirmation";
    }
}
