package com.example.colaboradores.services;

import java.util.Collections;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.colaboradores.entities.IdeiasEntity;
import com.example.colaboradores.repositories.AvaliacaoRepository;
import com.example.colaboradores.servicies.AvaliacaoService;

@SpringBootTest
public class AvaliacaoServiceTest {
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@MockBean
	private AvaliacaoRepository avaliacaoRepository;
	
	@Test
	public void testListarIdeiasDoJurado_comIdeias() {
		Long jurado_id = 1L;
		
		List<IdeiasEntity> ideias = Arrays.asList(
				new IdeiasEntity(1L, "ideia 1", "coisas", 100.0, "descricao 1"),
				new IdeiasEntity(2L, "ideia 2", "coisas", 200.0, "descricao 2")
				
				);
		
		when(avaliacaoRepository.findIdeiasbyJuradoId(jurado_id).thenReturn)(ideias);
		
		List<IdeiasEntity> resultado = avaliacaoService.listarIdeiasDoJurado(jurado_id);
	
		assertEquals(2, resultado.size());
		assertEquals("ideia1", resultado.get(0).getNomeIdeia());
		assertEquals("ideia2", resultado.get(1).getNomeIdeia());
		
	}
	
	@Test
	public void testListarIdeiasDoJurado_semIdeiasAtribuidas() {
		
		Long jurado_id = 2L;
		
		when(avaliacaoRepository.findIdeiasbyJuradoId(jurado_id).thenReturn(Collections.EMPTY_LIST));
		
		List<IdeiasEntity> resultado = avaliacaoService.listarIdeiasDoJurado(jurado_id);
		
		assertTrue(resultado.isEmpty());
	}

}
