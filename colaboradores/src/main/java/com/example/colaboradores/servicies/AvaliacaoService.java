package com.example.colaboradores.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colaboradores.entities.AvaliacaoEntity;
import com.example.colaboradores.entities.IdeiasEntity;
import com.example.colaboradores.repositories.AvaliacaoRepository;
import com.example.colaboradores.repositories.IdeiasRepository;

@Service
public class AvaliacaoService {
	
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Autowired
	private IdeiasRepository ideiaRepository;
	
	public List<IdeiasEntity> listarIdeiasDoJurado(Long jurado_id){
		return avaliacaoRepository.findIdeiasbyJuradoId(jurado_id);
		
	}
	
	public void avaliarIdeia(Long jurado_id, Long ideia_id, int nota) {
		AvaliacaoEntity avaliacao = avaliacaoRepository.findByJuradoEIdeiaId(jurado_id, ideia_id)
				.orElseThrow(() -> new RunTimeException("ideia nao atribuida"));
		avaliacao.setNota(nota);
		avaliacaoRepository.save(avaliacao);
	}

}
