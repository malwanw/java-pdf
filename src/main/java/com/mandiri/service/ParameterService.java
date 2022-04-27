package com.mandiri.service;

import com.mandiri.entity.Parameter;
import com.mandiri.repository.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParameterService {
    @Autowired
    ParameterRepository parameterRepository;

    public List<Parameter> getAll(){
        return parameterRepository.findAllByOrderByIdAsc();
    }

    public Parameter getById(Integer id){
        return parameterRepository.findById(id).get();
    }

    public Parameter addParam(Parameter parameter){
        return parameterRepository.save(parameter);
    }

    public void updateParam(Parameter parameter){
        parameterRepository.save(parameter);
    }
    public void deleteById(Integer id) {
        parameterRepository.deleteById(id);
    }
}
