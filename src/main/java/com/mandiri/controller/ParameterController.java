package com.mandiri.controller;

import com.mandiri.entity.Parameter;
import com.mandiri.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParameterController {
    @Autowired
    ParameterService parameterService;

    @GetMapping("/parameters")
    public List<Parameter> getAll(){
        return parameterService.getAll();
    }

    @GetMapping("/parameter")
    public Parameter getById(@RequestParam Integer id){
        return parameterService.getById(id);
    }
    @PostMapping("/parameter")
    public Parameter addParameter(@RequestBody Parameter parameter){
        return parameterService.addParam(parameter);
    }

    @PutMapping("/parameter")
    public void updateParam(@RequestBody Parameter parameter){
        parameterService.updateParam(parameter);
    }

    @DeleteMapping("/parameter/{id}")
    public void deleteParam(@PathVariable Integer id){
        parameterService.deleteById(id);
    }

}
