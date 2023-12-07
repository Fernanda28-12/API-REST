package com.example.demo.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;


public interface CitaRepository  extends CrudRepository<Cita, CitaId>{
  Set<Cita> findAll();
  Optional<Cita> findById(CitaId id);
}
