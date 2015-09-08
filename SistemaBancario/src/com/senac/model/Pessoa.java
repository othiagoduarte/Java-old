package com.senac.model;

public class Pessoa {

	private String nome;
	private int telefone;
	private String endereco;
	private String tipoTelefone;

	public Pessoa(String nome, int telefone, String tipoTelefone,
			String endereco) {

		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.tipoTelefone = tipoTelefone;
	}

	public String getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public Pessoa(String nome, int telefone, String endereco) {

		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
