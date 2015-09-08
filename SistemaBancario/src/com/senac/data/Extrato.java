package com.senac.data;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.senac.model.Cliente;
import com.senac.model.Conta;

public class Extrato {

	private String[] movimenta��o;
	private int contadorMovimenta��o;
	private Date data = new Date();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private DecimalFormat df = new DecimalFormat("#,##0.00");
	
	private String aux = sdf.format(data);
	private SalvarArquivo extrato;

	public Extrato(Conta conta) {

		Conta contaTemp = conta;
		this.movimenta��o = new String[100];
		this.contadorMovimenta��o = 0;
		this.extrato = new SalvarArquivo(contaTemp.getCliente().getPessoa().getNome()+" - Extrato.txt");

		String dados = contaTemp.getCliente().getPessoa().getNome();
		extrato.gravar(dados);
		extrato.gravar("\n");
		dados = "Conta " + contaTemp.getNumeroConta();
		extrato.gravar(dados);
		extrato.gravar(" - ");
		String dia = sdf.format(data);
		extrato.gravar(dia);
		extrato.gravar("\n");
	}

	public void sacar(double valor) {

		String dia = sdf.format(data);
		String mov = dia+" - Saque -    R$ " + df.format(valor);
		this.movimenta��o[contadorMovimenta��o] = mov;

		contadorMovimenta��o++;

	}

	public void depositar(double valor) {

		String dia = sdf.format(data);
		String mov = dia+" - Deposito - R$ " + df.format(valor);
		this.movimenta��o[contadorMovimenta��o] = mov;

		contadorMovimenta��o++;

	}

	public void alterarLimite(double valor) {

		String dia = sdf.format(data);
		String mov = dia+" - Novo limite - R$ " + df.format(valor);
		this.movimenta��o[contadorMovimenta��o] = mov;

		contadorMovimenta��o++;
	}

	public void gerarExtrato(double saldo) {

		String aux = "";

		for (int i = 0; i < this.contadorMovimenta��o; i++) {

			aux = aux + "\n" + movimenta��o[i];
		}
		extrato.gravar("===================================================");
		extrato.gravar(aux);
		extrato.gravar("===================================================");
		extrato.gravar("\n");
		aux = "Saldo atual : R$ " + df.format(saldo);

		extrato.gravar(aux);
		extrato.close();
	}

	public String getExtrato() {

		String extrato = "";
		for (int i = 0; i < this.contadorMovimenta��o; i++) {

			extrato = extrato + "\n" + movimenta��o[i];

		}

		return extrato;
	}

}
