package com.vinay.springboot.thymeleafdemo.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DemoControllerTest {
    @Mock
    private Model model;

    @InjectMocks
    private DemoController demoController;

    @Test
    void Say_Hello_ReturnsHelloJSP(){
        String viewName = demoController.sayHello(model);
        assertEquals("hello", viewName);
        verify(model, times(1)).addAttribute(eq("theDate"), any(Date.class));
    }
}
