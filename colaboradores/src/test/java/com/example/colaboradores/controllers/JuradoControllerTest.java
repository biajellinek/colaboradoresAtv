package com.example.colaboradores.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.colaboradores.entities.IdeiasEntity;
import com.example.colaboradores.servicies.AvaliacaoService;

@SpringBootTest
@AutoConfigureMockMvc
public class JuradoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AvaliacaoService avaliacaoService;
	
	@Test 
	public void testarListarIdeiasDoJurado() throws Exception {
		Long jurado_id = 1L;
		List<IdeiasEntity> ideias = Arrays.asList(jurado_id)
				 new IdeiasEntity(1L, "Ideia 1", "Impacto", 100.0, "Descrição 1"),
		            new IdeiasEntity(2L, "Ideia 2", "Impacto", 200.0, "Descrição 2")
		      
	when(avaliacaoService.listarIdeiasDoJurado(jurado_id).thenRetun(ideias));
		
		
		mockMvc.perform(get ("/jurados/1/ideias"))
		.andExpect(status().isOk())
        .andExpect(jsonPath("$[0].nomeIdeia").value("Ideia 1"))
        .andExpect(jsonPath("$[1].nomeIdeia").value("Ideia 2"));

		
	}
	
	@Test
	public void resAvaliarIdeia() throws Exception {
		
		Long jurado_id = 1L;
		Long ideia_id = 1L;
		int nota = 7;
		
		 mockMvc.perform(post("/jurados/1/avaliar")
	                .param("ideiaId", ideia_id.toString())
	                .param("nota", Integer.toString(nota)))
	            .andExpect(status().isOk())
	            .andExpect(content().string("ideia avaliada"));
	    }
	}


