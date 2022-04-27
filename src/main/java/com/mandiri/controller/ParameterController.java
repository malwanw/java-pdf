package com.mandiri.controller;

import com.mandiri.entity.Parameter;
import com.mandiri.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParameterController {
    @Autowired
    ParameterService parameterService;

    @GetMapping("/parameter")
    public List<Parameter> getAll(){
        return parameterService.getAll();
    }

    @PostMapping("/parameter")
    public Parameter addParameter(@RequestBody Parameter parameter){
        return parameterService.addParam(parameter);
    }
}
