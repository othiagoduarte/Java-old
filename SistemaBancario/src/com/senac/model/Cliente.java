package com.senac.model;

public class Cliente {

	private Pessoa cliente;
	private int numeroConta;

	public Cliente(int numConta, String nome, int telefone,
			String tipoTelefone, String endereco) {

		cliente = new Pessoa(nome, telefone, tipoTelefone, endereco);
		this.numeroConta = numConta;

	}

	public Pessoa getPessoa() {

		return this.cliente;

	}

	public int getNumeroConta() {
		return this.numeroConta;
	}

	public void setNumeroConta(int numeroConta) {

		this.numeroConta = numeroConta;

	}

	public String toString() {

		return this.cliente.getNome() + "\n" + 
		this.cliente.getEndereco()	+ "\n" +
		this.cliente.getTipoTelefone() + "\n"+
		this.cliente.getTelefone()+ "\n";

	}
}
