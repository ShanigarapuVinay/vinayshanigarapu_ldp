package com.vinay.springboot.thymeleafdemo.controller;

import com.vinay.springboot.thymeleafdemo.entity.Cricketer;
import com.vinay.springboot.thymeleafdemo.service.CricketerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CricketerControllerTest {

    @Mock
    private CricketerService cricketerService;

    @Mock
    private Model model;

    @InjectMocks
    private CricketerController cricketerController;

    @Test
    void Get_AllCricketers_ReturnsListOfCricketers(){
        List<Cricketer> cricketers = Arrays.asList(new Cricketer(), new Cricketer());
        when(cricketerService.findAll()).thenReturn(cricketers);

        String viewName = cricketerController.getAllCricketers(model);

        assertEquals("listCricketers", viewName);
        verify(model, times(1)).addAttribute(eq("cricketers"), anyList());
        verify(cricketerService, times(1)).findAll();
    }

    @Test
    void Show_AddCricketerForm(){
        String viewName = cricketerController.showAddForm(model);
        assertEquals("cricketer", viewName);
        verify(model, times(1)).addAttribute(eq("cricketer"), any(Cricketer.class));
    }

    @Test
    void Save_Cricketer(){
        Cricketer cricketer = new Cricketer();
        String viewName = cricketerController.saveCricketer(cricketer);
        assertEquals("redirect:list", viewName);
        verify(cricketerService, times(1)).save(any(Cricketer.class));
    }

    @Test
    void Show_UpdateCricketerForm(){
        Cricketer cricketer = new Cricketer(2, "Virat", "Kohli", "India", 35);
        when(cricketerService.findById(2)).thenReturn(cricketer);

        String viewName = cricketerController.showUpdateForm(model, 2);

        assertEquals("cricketer", viewName);
        verify(model, times(1)).addAttribute(eq("cricketer"), any(Cricketer.class));
        verify(cricketerService, times(1)).findById(2);
    }

    @Test
    void Delete_Cricketer(){
        String viewName = cricketerController.deleteCricketer(2);
        assertEquals("redirect:list", viewName);
        verify(cricketerService, times(1)).deleteById(2);
    }
}
