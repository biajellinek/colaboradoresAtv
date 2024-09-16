package com.example.colaboradores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.colaboradores.entities.EventoJuradoEntity;

@Repository
public interface EventoJuradsoRepository extends JpaRepository<EventoJuradoEntity, Long>{

}
