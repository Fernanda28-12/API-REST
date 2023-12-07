package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.MedicoModel;

@Repository

public interface MedicoRepository extends CrudRepository<MedicoModel, Long> {
    public abstract ArrayList<MedicoModel> findById(String Id);

    public abstract ArrayList<MedicoModel> findAll();

    public abstract void deleteById(Long id);

    public abstract MedicoModel save(Object medico);

}