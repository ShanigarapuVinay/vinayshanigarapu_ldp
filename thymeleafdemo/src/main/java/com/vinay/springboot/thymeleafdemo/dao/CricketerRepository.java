package com.vinay.springboot.thymeleafdemo.dao;

import com.vinay.springboot.thymeleafdemo.entity.Cricketer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CricketerRepository extends JpaRepository<Cricketer, Integer> {

}
