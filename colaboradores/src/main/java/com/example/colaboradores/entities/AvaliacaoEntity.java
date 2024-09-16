package com.example.colaboradores.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AvaliacaoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int nota;

	@ManyToOne
	@JoinColumn(name = "jurado_id")
	private JuradosEntity jurados;
	
	@ManyToOne
	@JoinColumn (name = "ideia_id")
	private IdeiasEntity ideias;
	
	public AvaliacaoEntity (JuradosEntity jurados, IdeiasEntity ideias) {
		this.jurados = jurados;
		this.ideias = ideias;
		
	}
	
	public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

}
