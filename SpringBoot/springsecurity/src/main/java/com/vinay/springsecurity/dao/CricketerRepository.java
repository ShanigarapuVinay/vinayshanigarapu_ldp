package com.vinay.springsecurity.dao;


import com.vinay.springsecurity.entity.Cricketer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CricketerRepository extends JpaRepository<Cricketer, Integer> {

}
