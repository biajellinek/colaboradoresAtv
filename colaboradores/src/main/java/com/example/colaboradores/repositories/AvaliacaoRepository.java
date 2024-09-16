package com.example.colaboradores.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.colaboradores.entities.AvaliacaoEntity;
import com.example.colaboradores.entities.IdeiasEntity;

@Repository
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, Long>{

	@Query("SELECT a.ideia FROM avaliaco a WHERE a.jurado.id = :jurado_id")
	List<IdeiasEntity> findIdeiasbyJuradoId (@Param("jurado_id") Long jurado_id);
	
	Optional<AvaliacaoEntity> findByJuradoEIdeiaId(Long jurado_id, Long ideia_id);
	
}
