package com.mandiri.entity;

import com.mandiri.repository.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name="parameter")
public class Parameter {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String param;

    public Parameter() {
    }

    public Integer getId() {
        return id;
    }

    public String getParam() {
        return param;
    }
}
