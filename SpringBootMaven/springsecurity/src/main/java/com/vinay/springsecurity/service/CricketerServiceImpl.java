package com.vinay.springsecurity.service;

import com.vinay.springsecurity.dao.CricketerRepository;
import com.vinay.springsecurity.entity.Cricketer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CricketerServiceImpl implements CricketerService{

    private CricketerRepository cricketerRepository;

    @Override
    public List<Cricketer> findAll() {
        return cricketerRepository.findAll();
    }

    @Override
    public Cricketer findById(int id) {
        Optional<Cricketer> result = cricketerRepository.findById(id);
        Cricketer cricketer = null;
        if(result.isPresent())
            cricketer = result.get();
        else
            throw new RuntimeException("Did not find cricketer with id - " + id);
        return cricketer;
    }

    @Override
    public void save(Cricketer cricketer) {
        cricketerRepository.save(cricketer);
    }

    @Override
    public void deleteById(int id) {
        cricketerRepository.deleteById(id);
    }
}
