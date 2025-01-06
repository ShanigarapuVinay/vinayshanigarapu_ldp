package com.vinay.springboot.thymeleafdemo.service;

import com.vinay.springboot.thymeleafdemo.dao.CricketerRepository;
import com.vinay.springboot.thymeleafdemo.entity.Cricketer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CricketerServiceTest{

    @Mock
    private CricketerRepository cricketerRepository;

    @InjectMocks
    private CricketerServiceImpl cricketerService;

    @Test
    void Find_AllCricketers_ReturnsListOfCricketers(){
        List<Cricketer> cricketers = Arrays.asList(new Cricketer(), new Cricketer());
        when(cricketerRepository.findAll()).thenReturn(cricketers);

        List<Cricketer> result = cricketerService.findAll();
        assertNotNull(result);
        assertEquals(2,result.size());
        verify(cricketerRepository, times(1)).findAll();
    }

    @Test
    void Find_CricketerById_ReturnsCricketer_WhenIdIsValid(){
        Cricketer cricketer = new Cricketer(2, "Virat", "Kohli", "India", 35);
        when(cricketerRepository.findById(2)).thenReturn(Optional.of(cricketer));

        Cricketer result = cricketerService.findById(2);

        assertNotNull(result);
        assertEquals(2, result.getId());
        assertEquals("Virat", result.getFirstName());
        verify(cricketerRepository, times(1)).findById(2);
    }

    @Test
    void Find_CricketerById_ExceptionThrown_WhenCricketerNotFound(){
        when(cricketerRepository.findById(2)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            cricketerService.findById(2);
        });

        String expectedMessage = "Did not find cricketer with id - 2";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        verify(cricketerRepository, times(1)).findById(2);
    }

    @Test
    void Save_Or_Update_Cricketer(){
        Cricketer cricketer = new Cricketer(2, "Virat", "Kohli", "India", 35);

        cricketerService.save(cricketer);

        verify(cricketerRepository, times(1)).save(cricketer);
    }

    @Test
    void Delete_CricketerById_DeletesCricketer_WhenIdIsValid(){
        int cricketer_id = 2;
        Cricketer cricketer = new Cricketer(2, "Virat", "Kohli", "India", 35);

        when(cricketerRepository.findById(cricketer_id)).thenReturn(Optional.of(cricketer));

        cricketerService.deleteById(cricketer_id);

        verify(cricketerRepository, times(1)).findById(cricketer_id);
        verify(cricketerRepository, times(1)).deleteById(cricketer_id);
    }

    @Test
    void Delete_CricketerById_ExceptionThrown_WhenCricketerNotFound(){
        when(cricketerRepository.findById(100)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            cricketerService.deleteById(100);
        });

        String expectedMessage = "Did not find cricketer with id - 100";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        verify(cricketerRepository, times(1)).findById(100);
        verify(cricketerRepository, never()).deleteById(100);
    }
}
