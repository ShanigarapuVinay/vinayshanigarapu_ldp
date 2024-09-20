package com.vinay.springboot.thymeleafdemo.service;

import com.vinay.springboot.thymeleafdemo.entity.Cricketer;

import java.util.List;

public interface CricketerService {
    List<Cricketer> findAll();
    Cricketer findById(int id);
    void save(Cricketer cricketer);
    void deleteById(int id);
}
