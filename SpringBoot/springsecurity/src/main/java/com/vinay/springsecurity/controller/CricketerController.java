package com.vinay.springsecurity.controller;

import com.vinay.springsecurity.entity.Cricketer;
import com.vinay.springsecurity.service.CricketerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CricketerController {
    private CricketerService cricketerService;

    @GetMapping("/cricketers")
    public List<Cricketer> getAllCricketers(){
        return cricketerService.findAll();
    }

    @GetMapping("/cricketers/{id}")
    public Cricketer getCricketerById(@PathVariable int id){
        return cricketerService.findById(id);
    }

    @PostMapping("/cricketers")
    public ResponseEntity<Cricketer> saveCricketer(@RequestBody Cricketer cricketer){
        cricketer.setId(0);
        cricketerService.save(cricketer);
        return ResponseEntity.ok(cricketer);
    }

    @PutMapping("/cricketers")
    public ResponseEntity<Cricketer> updateCricketer(@RequestBody Cricketer cricketer){
        cricketerService.save(cricketer);
        return ResponseEntity.ok(cricketer);
    }

    @DeleteMapping("/cricketers/{id}")
    public String deleteCricketers(@PathVariable int id){
        cricketerService.deleteById(id);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cricketers of id = ");
        stringBuilder.append(id);
        stringBuilder.append(" deleted successfully..");
        return stringBuilder.toString();
    }
}
