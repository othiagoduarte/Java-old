package com.senac.jogos.apps.Matching.controller;

import com.senac.jogos.apps.Matching.model.MatchingCardGame;
import com.senac.jogos.cartas.Carta;

public class JogoController {

	private MatchingCardGame jogo;
	private Carta[] cartaJogador;

	public JogoController(int jogadores) {

		jogo = new MatchingCardGame(jogadores);

		cartaJogador = new Carta[jogadores];

		for (int i = 0; i < jogadores; i++) {

			this.cartaJogador[i] = null;

		}

	}

	public void playTurno(int jogador) {

		int pontos = 0;
		pontos = jogo.matchCarta(cartaJogador[jogador]);

		jogo.getJogador(jogador).addPontos(pontos);
		// descartar carta

		jogo.setMesa(cartaJogador[jogador]);

		cartaJogador[jogador] = null;

	}

	public void pularRodada(int jogador) {

		jogo.getJogador(jogador).subtractPontos(1);

	}

	public String showJogador(int jogador) {

		return String.format("%s Pontos : %d",

		jogo.getJogador(jogador).getNome(), jogo.getJogador(jogador)
				.getPontos());

	}

	public int getPontosJogador(int jogador) {

		return jogo.getJogador(jogador).getPontos();
	}

	private String showCarta(Carta carta) {

		return String.format("%d%c", carta.getValor(), carta.getNaipe());
	}

	public String showMesa() {
		return showCarta(jogo.getMesa());
	}

	public String showCartaJogador(int jogador) {

		if (cartaJogador[jogador] == null)
			cartaJogador[jogador] = jogo.drawCarta();
		return showCarta(cartaJogador[jogador]);
	}

	public String getNomeJogador(int jogador) {

		return jogo.getNomeJogador(jogador);
	}

	public MatchingCardGame getJogo() {

		return this.jogo;
	}

}
