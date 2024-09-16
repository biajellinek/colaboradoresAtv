package com.example.colaboradores.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class JuradosEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nomeJurado;
	
	public JuradosEntity() {}
	
	public JuradosEntity(String nomeJurado) {
		this.nomeJurado = nomeJurado;
	}
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeJurado() {
        return nomeJurado;
    }

    public void setNomeJurado(String nomeJurado) {
        this.nomeJurado = nomeJurado;
    }
	
	@ManyToOne 
	@JoinColumn(name = "admin_id")
	private List<AdminEntity> admin; 
	
	@ManyToMany(mappedBy = "eventos_id")
	private List<EventosEntity> eventos;
	

}
