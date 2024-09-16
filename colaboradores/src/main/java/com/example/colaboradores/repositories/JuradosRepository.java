package com.example.colaboradores.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.colaboradores.entities.JuradosEntity;

@Repository
public interface JuradosRepository extends JpaRepository<JuradosEntity, Long>{

	@Query("SELECT j FROM jurado j JOIN EventoJurado ej ON j.id = ej.jurado.id WHERE ej.evento.id = evento_id")
	List<JuradosEntity> findJuradosByEventoId(@Param("evento_id") Long evento_id);
}
