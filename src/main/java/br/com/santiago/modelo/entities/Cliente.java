package br.com.santiago.modelo.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente {

	private Long id;
	private String nome;
	private String email;
	private LocalDate dataNascimento;

	public Cliente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getDataFormatada() {		
		return this.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));		
	}
}
