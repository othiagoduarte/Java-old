package com.senac.model;

public class ContaEspecial extends Conta {

	private double limite;

	public ContaEspecial(String tipo, Cliente cliente, double limite) {
		super(tipo, cliente);
		this.limite = limite;
	}

	public boolean alterarLimite(double valor) {

		boolean operacaoRealizada = false;
		if (valor > 0) {

			this.limite = valor;

		}

		return operacaoRealizada;
	}

	public boolean sacar(double valor) {

		boolean operacaoRealizada = false;
		if ((this.limite + this.saldo) > valor) {

			this.saldo -= valor;

			operacaoRealizada = true;
		}

		return operacaoRealizada;

	}
	public double getLimite(){
		
		return this.limite;
	}
}
