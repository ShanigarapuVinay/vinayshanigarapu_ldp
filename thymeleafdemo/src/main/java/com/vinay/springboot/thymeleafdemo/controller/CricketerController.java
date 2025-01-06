package com.vinay.springboot.thymeleafdemo.controller;

import com.vinay.springboot.thymeleafdemo.entity.Cricketer;
import com.vinay.springboot.thymeleafdemo.service.CricketerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/cricketers")
public class CricketerController {

    private CricketerService cricketerService;

    @GetMapping("/list")
    public String getAllCricketers(Model model){
        List<Cricketer> cricketers = cricketerService.findAll();
        model.addAttribute("cricketers", cricketers);
        return "listCricketers";
    }

    @GetMapping("/showAddForm")
    public String showAddForm(Model model){
        Cricketer cricketer = new Cricketer();
        model.addAttribute("cricketer", cricketer);
        return "cricketer";
    }

    @PostMapping("/save")
    public String saveCricketer(@ModelAttribute("cricketer") Cricketer cricketer){
        cricketerService.save(cricketer);
        return "redirect:list";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(Model model, @RequestParam int cricketerId){
        Cricketer cricketer = cricketerService.findById(cricketerId);
        model.addAttribute("cricketer", cricketer);
        return "cricketer";
    }

    @GetMapping("/delete")
    public String deleteCricketer(@RequestParam int cricketerId){
        cricketerService.deleteById(cricketerId);
        return "redirect:list";
    }
}
