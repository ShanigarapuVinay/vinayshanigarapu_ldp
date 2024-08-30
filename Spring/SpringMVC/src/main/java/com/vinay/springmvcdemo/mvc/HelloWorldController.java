package com.vinay.springmvcdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm(){
        return "hello-world-form";
    }

    @GetMapping("/processForm")
    public String processForm(){
        return "hello-world";
    }

    @GetMapping("/processForm2.0")
    public String letsShoutOut(HttpServletRequest http, Model model){
        String name = http.getParameter("studentName");
        name = name.toUpperCase();
        String msg = "Moshi Mosh! " + name;
        model.addAttribute("message",msg);
        return "hello-world";
    }

    @GetMapping("/processForm3.0")
    public String displayNameUsingRequestParam(@RequestParam("studentName") String name, Model model){
        name = name.toUpperCase();
        String msg = "Yo! Whats up, " + name;
        model.addAttribute("message",msg);
        return "hello-world";
    }
}
