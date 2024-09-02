package com.springdto.lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

@Getter

@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private String email;
}
