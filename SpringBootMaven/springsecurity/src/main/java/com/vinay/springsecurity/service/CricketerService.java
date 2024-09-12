package com.vinay.springsecurity.service;


import com.vinay.springsecurity.entity.Cricketer;

import java.util.List;

public interface CricketerService {
    List<Cricketer> findAll();
    Cricketer findById(int id);
    void save(Cricketer cricketer);
    void deleteById(int id);
}
