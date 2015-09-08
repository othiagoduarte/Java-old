package com.senac.jogos.apps.Matching.view;

import java.util.Scanner;
import static java.lang.System.*;

import com.senac.jogos.Jogador;
import com.senac.jogos.apps.Matching.controller.JogoController;

public class JogoView {

	private static Scanner teclado = new Scanner(System.in);
	private static int numJogadores;

	private static JogoController controller;
	private static int pular[];

	public JogoView() {

		out.println("Digite o numero de jogadores (até 4 jogadores permitido)");

		numJogadores = teclado.nextInt(); // Número de jogadores
		controller = new JogoController(numJogadores);
		pular = new int[numJogadores];

		for (int i = 0; i < pular.length; i++) {
			pular[i] = 0;
		}

		rodada();

	}

	public static void continuarJogando() {

		boolean ok = true;
		while (ok) {
			out.println("Deseja jogar novamente ? 'S' para sim, 'N' para não");

			String aux = "";
			aux = teclado.next();
			if (aux.equalsIgnoreCase("N")) {

				exibirResultados();
				getGanhador();
				out.println("---------- Fim ---------- ");
				ok = false;

			} else if (aux.equalsIgnoreCase("S")) {
				rodada();
				ok = false;
			}
		}
	}

	public static void exibirResultados() {

		imprimirLinha();

		for (int i = 0; i < numJogadores; i++) {

			out.println(controller.getNomeJogador(i));
			out.println(controller.getPontosJogador(i));
		}

	}

	public static String getGanhador() {

		String ganhador = controller.getNomeJogador(0);

		for (int i = 0; i < numJogadores - 1; i++) {

			if (controller.getPontosJogador(i) < controller
					.getPontosJogador(i + 1)) {

				ganhador = controller.getNomeJogador(i + 1);

			}

		}

		return ganhador;
	}

	public static void rodada() {

		for (int jogada = 0; jogada < numJogadores; jogada++) {

			imprimirLinha();
			out.println("***** Carta na mesa: " + controller.showMesa()
					+ " *****");

			imprimirLinha();
			imprimirLinha();

			out.println("********* " + controller.getNomeJogador(jogada)
					+ " *********"); // Nome do Jogador
			imprimirLinha();
			boolean ok = true;

			while (ok) {

				out.println("Digite 'jogar' para jogar, 'pular' para passar a vez: ");
				String comando = teclado.next();

				if (comando.equalsIgnoreCase("JOGAR")) {
					jogar(jogada);
					ok = false;

				}
				if (comando.equalsIgnoreCase("PULAR")) {
					pular(jogada);
					ok = false;
				}
			}

		}

		imprimirLinha();
		out.println("Resultados");
		exibirResultados();
		String ganhador = getGanhador();
		imprimirLinha();
		out.println("O " + ganhador + " Venceu !!!!");
		// continuarJogando();

	}

	public static void jogar(int jogada) {

		out.println("Carta do jogador: " + controller.showCartaJogador(jogada));

		controller.playTurno(jogada);

	}

	public static void pular(int jogador) {

		if (pular[jogador] >= 2) {
			imprimirLinha();
			out.println("Você não pode mais pular");
			jogar(jogador);

		} else {
			pular[jogador]++;
			controller.pularRodada(jogador);
			pular[jogador]++;
		}

	}

	public static void imprimirLinha() {
		out.println("----------------------------------------");
	}
}
