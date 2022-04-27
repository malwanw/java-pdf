package com.mandiri.repository;

import com.mandiri.entity.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Integer>, JpaSpecificationExecutor<Parameter> {
    List<Parameter> findAllByOrderByIdAsc();
}
