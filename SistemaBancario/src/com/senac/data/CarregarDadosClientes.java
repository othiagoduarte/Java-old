package com.senac.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.senac.model.Cliente;
import com.senac.model.Conta;

public class CarregarDadosClientes {

	private BufferedReader br;

	private Conta conta;

	public CarregarDadosClientes() {

		try {

			InputStream is = new FileInputStream("Dados.txt");

			InputStreamReader isr = new InputStreamReader(is);

			br = new BufferedReader(isr);
		} catch (Exception e) {

		}

	}

	public Conta lerConta() throws IOException {

		try {

			int numConta = Integer.parseInt(br.readLine());
			double saldo = Double.parseDouble(br.readLine());
			String tipoConta = br.readLine();
			String nome = br.readLine();
			int telefone = Integer.parseInt(br.readLine());
			String tipoTelefone = br.readLine();
			String endereco = br.readLine();

			Cliente cliente = new Cliente(numConta, nome, telefone,
					tipoTelefone, endereco);

			this.conta = new Conta(tipoConta, cliente);
			// Primeiro Deposito
			this.conta.depositar(saldo);

			// Verifica de a próxima linha esta vaiza
			if (br.ready() == false) {

				this.conta = null;

			}

		} catch (Exception e) {

		}

		return this.conta;

	}

}
