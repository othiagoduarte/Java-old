package com.senac.data;

import java.io.IOException;

import com.senac.model.Conta;

public class ListaContas {

	private Conta[] contas;
	private SalvarDadosClientes salvar;
	private CarregarDadosClientes carregar;
	private int numClientesValidos;

	public ListaContas() throws IOException {

		
		this.carregar = new CarregarDadosClientes();
		
		this.contas = new Conta[1];

		this.numClientesValidos = 0;

		Conta contaTemp;
		do {
			contaTemp = carregar.lerConta();

			if (contaTemp != null) {

				this.contas[this.numClientesValidos] = contaTemp;

				aumnetarListaConta();

				this.numClientesValidos++;
			}

		} while (contaTemp != null);

	}

	public void salvarListaContas() throws IOException {

		this.salvar = new SalvarDadosClientes();
		for (int i = 0; i < numClientesValidos; i++) {

			salvar.salvarConta(contas[i]);
		}

		salvar.fechar();
	}

	public void setCliente(int indice, Conta conta) {

		if (indice < contas.length) {

			this.contas[indice] = conta;
		}
	}

	public int size() {

		return this.numClientesValidos;
	}

	private void aumnetarListaConta() {

		Conta[] contasTemp = new Conta[this.contas.length + 1];

		System.arraycopy(this.contas, 0, contasTemp, 0, this.contas.length);

		this.contas = contasTemp;
	}

	public boolean incluirConta(Conta conta) {

		boolean inclusão = false;

		if (conta != null) {

			aumnetarListaConta();

			this.contas[numClientesValidos] = conta;

			numClientesValidos++;

			inclusão = true;
		}

		return inclusão;
	}

	public Conta getConta(int indice) {

		if (indice > numClientesValidos) {

		}

		return this.contas[indice];
	}

}
