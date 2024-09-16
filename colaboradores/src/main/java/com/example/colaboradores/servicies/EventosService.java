package com.example.colaboradores.servicies;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colaboradores.entities.AvaliacaoEntity;
import com.example.colaboradores.entities.EventoJuradoEntity;
import com.example.colaboradores.entities.EventosEntity;
import com.example.colaboradores.entities.IdeiasEntity;
import com.example.colaboradores.entities.JuradosEntity;
import com.example.colaboradores.repositories.AvaliacaoRepository;
import com.example.colaboradores.repositories.EventoJuradsoRepository;
import com.example.colaboradores.repositories.EventosRepository;
import com.example.colaboradores.repositories.IdeiasRepository;
import com.example.colaboradores.repositories.JuradosRepository;

@Service
public class EventosService {
	
	@Autowired
	private IdeiasRepository ideiasRepository;
	
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Autowired
	private EventosRepository eventosRepository;
	
	@Autowired
	private JuradosRepository juradosRepository;

	@Autowired
	private EventoJuradsoRepository eventoJuradoRepository;
	
	public void selecionarJuradosParaEventos(Long evento_id, List<Long> juradosIds) {
		EventosEntity eventos = eventosRepository.findById(evento_id)
				.orElseThrow(() -> new RuntimeException("evento nao achado"));
		
				for (Long jurado_id : juradosIds) {
					JuradosEntity jurados = juradosRepository.findById(jurado_id)
							.orElseThrow(() -> new RuntimeException ("jurado nap encontrado"));
					EventoJuradoEntity eventoJurado = new EventoJuradoEntity();
					eventoJuradoRepository.save(eventoJurado);
				}
	}
	
	public void distribuirIdeias(Long evento_id) {
		
		List<JuradosEntity> jurados = juradosRepository.findJuradosByEventoId(evento_id);
		
		List<IdeiasEntity> ideias = ideiasRepository.findIdeiasByEventoId(evento_id);
		
		Collections.shuffle(ideias);
		
		int juradoIndex = 0;
		for (IdeiasEntity ideia : ideias) {
			JuradosEntity jurado = jurados.get(juradoIndex);
			
			
			AvaliacaoEntity avaliacao = new AvaliacaoEntity(jurado, ideia);
			avaliacaoRepository.save(avaliacao);
			
			juradoIndex = (juradoIndex + 1) % jurados.size();
			
		}
	}
}
