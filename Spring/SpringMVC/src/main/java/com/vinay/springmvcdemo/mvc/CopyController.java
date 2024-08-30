package com.vinay.springmvcdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello-copy")
public class CopyController {

    @GetMapping("/showForm")
    @ResponseBody
    public String displayForm(){
        return "Form";
    }
}
