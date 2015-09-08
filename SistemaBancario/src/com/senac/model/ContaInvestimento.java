package com.senac.model;

public class ContaInvestimento extends Conta {

	private String dataCriacao;

	private double taxa;
	private double limiteTaxa;

	public ContaInvestimento(String tipo,Cliente cliente, String data) {

		super(tipo,cliente );

		this.dataCriacao = data;
		this.limiteTaxa = 0.50;
		this.taxa = 0.01;
	}

	public boolean aplicarTaxa(double taxa) {

		boolean operacaoRealizada = false;
		if (taxa < this.limiteTaxa && taxa > 0) {

			this.taxa = taxa;

			this.saldo = (this.saldo + (this.saldo * this.taxa));

		} else {

			System.err.println("Valor de taxa invalido");

		}

		return operacaoRealizada;
	}

	public boolean aplicarTaxa() {

		boolean operacaoRealizada = false;

		if (this.taxa != 0) {
			this.saldo = (this.saldo + (this.saldo * this.taxa));
			operacaoRealizada = true;

		} else {

			System.err
					.println("Valor de taxa esta igual a zero, favor Redefinir taxa");
		}

		return operacaoRealizada;
	}

	public boolean alterarTaxa(double taxa) {

		boolean operacaoRealizada = false;
		if (taxa > 0 && taxa <= limiteTaxa) {

			this.taxa = taxa;
			operacaoRealizada = true;
		} else {

			System.err.println("valor invalido");
		}

		return operacaoRealizada;
	}

	public double getTaxa(){
		
		return this.taxa;
	}
	
	public String getData(){
		
		return this.dataCriacao;
	}
}
