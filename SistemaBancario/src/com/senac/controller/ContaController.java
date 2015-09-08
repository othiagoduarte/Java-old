package com.senac.controller;

import java.io.IOException;
import java.text.DecimalFormat;

import com.senac.data.Extrato;
import com.senac.data.ListaContas;
import com.senac.model.Cliente;
import com.senac.model.Conta;
import com.senac.view.ConsoleView;

public class ContaController {

	private ListaContas contas;
	private int indiceConta;
	private boolean acesso;
	private ConsoleView view;

	private DecimalFormat df = new DecimalFormat("#,##0.00");

	public static void main(String[] args) throws IOException {
		new ContaController().run();
	}

	public void run() throws IOException {

		menuPrincipal();

	}

	public ContaController() throws IOException {

		this.acesso = false;
		this.contas = new ListaContas();
		this.indiceConta = -1;
		view = new ConsoleView();

	}

	public void menuPrincipal() throws IOException {

		int opc = 0;
		String[] menuPrincipal = { "Acessar Conta", "Criar Conta",
				"Sair", };

		while (opc != 3) {

			view.showMenu(menuPrincipal);
			opc = view.readInt("");

			switch (opc) {
			case 1:
				acessarConta();
				break;

			case 2:
				criarCliente();
				break;

			case 3:
				salvarDados();
				break;
			}

		}

	}

	public void menuConta() {

		Extrato extrato = new Extrato(contas.getConta(indiceConta));

		int opc = 0;

		String[] menuPrincipal = { "Saldo", "Depositar", "Sacar",
				"Extrato", "sair" };

		String dados = contas.getConta(indiceConta).getCliente().getPessoa()
				.getNome()
				+ "\n"
				+ "Conta "
				+ contas.getConta(indiceConta).getNumeroConta();

		view.showMessage(dados);

		while (opc != menuPrincipal.length) {

			view.showMenu(menuPrincipal);
			opc = view.readInt("");

			if (opc > menuPrincipal.length) {

				view.showMessage("Opção Inválida");
			}
			switch (opc) {

			case 1:
				String saldo = df.format(contas.getConta(indiceConta)
						.getSaldo());
				view.showMessage("Saldo R$ " + saldo);

				break;

			case 2:

				double deposito = view
						.readDouble("Digite o Valor do deposito ");
				view.validarOperação(this.contas.getConta(indiceConta)
						.depositar(deposito));

				extrato.depositar(deposito);

				break;

			case 3:

				double saque = view.readDouble("Digite o valor do Saque");
				view.validarOperação(this.contas.getConta(indiceConta).sacar(
						saque));
				extrato.sacar(saque);

				break;

			case 4:

				boolean b = true;
				while (b) {
					int opcExtrato = view
							.readInt("1 - Visualiar \n2 - Imprimir");

					switch (opcExtrato) {

					case 1:
						view.showMessage(extrato.getExtrato());
						b = false;
						break;
					case 2:
						extrato.gerarExtrato(contas.getConta(indiceConta)
								.getSaldo());
						b = false;
						break;
					}

				}
			}
		}
	}

	public void acessarConta() {

		this.acesso = false;
		this.indiceConta = -1;

		int numConta = view.readInt("Digite o número da Conta");

		for (int indice = 0; indice < contas.size(); indice++) {

			if (contas.getConta(indice).getNumeroConta() == numConta) {

				this.indiceConta = indice;
				this.acesso = true;

				break;
			}

		}

		view.validarOperação(acesso);
		if (acesso) {
			view.linha();
			menuConta();

		}

	}

	public void criarCliente() {

		String nome = view.readLine("Digite o nome completo do Cliente");
		String endereco = view.readLine("Digite a rua");
		endereco = endereco + " , " + view.readLine("Digite o mumero");
		endereco = endereco + " - " + view.readLine("Digite a cidade");
		endereco = endereco + " - " + view.readLine("Digite a UF");

		String tipoTelefone = view.readLine("Digite o tipo de telefone");
		int telefone = view.readInt("Digite o telefone");
		int numConta = view.readInt("Digite o Número da Conta");

		Cliente novoCliente = new Cliente(numConta, nome, telefone,
				tipoTelefone, endereco);

		Conta novaConta = new Conta("Comun", novoCliente);

		view.validarOperação(this.contas.incluirConta(novaConta));

	}

	public void salvarDados() throws IOException {

		this.contas.salvarListaContas();
	}

	public void criarContaEspecial(int numeroConta, double limiteInicial) {

	}

	public void criarContaInvestimento(int numeroConta, String data) {

	}

}
