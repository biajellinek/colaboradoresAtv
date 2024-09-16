package com.example.colaboradores.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.colaboradores.entities.IdeiasEntity;

@Repository
public interface IdeiasRepository extends JpaRepository<IdeiasEntity, Long>{

	List<IdeiasEntity> findIdeiasByEventoId(Long evento_id);
}
