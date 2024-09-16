package com.example.colaboradores.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.colaboradores.servicies.EventosService;

@RestController
@RequestMapping("/eventos")
public class EventosController {
	
	@Autowired
	private EventosService eventosService;

	public ResponseEntity<String> selecionarJurados(@PathVariable Long evento_id, @RequestBody List<Long> juradosIds){
		eventosService.selecionarJuradosParaEventos(evento_id, juradosIds);
		return ResponseEntity.ok("jurados selecionados");
		
	}
	
	public ResponseEntity<String> distribuirIdeias(@PathVariable Long evento_id){
		
		eventosService.distribuirIdeias(evento_id);
		return ResponseEntity.ok("ideias distribuidas");
	}
}
