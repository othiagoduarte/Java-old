package com.senac.jogos.apps.Matching.model;

import com.senac.jogos.Jogador;
import com.senac.jogos.cartas.Baralho;
import com.senac.jogos.cartas.Carta;

public class MatchingCardGame {

	private Baralho baralho;
	private Jogador[] jogador;

	private Carta mesa;

	public MatchingCardGame(int jogadores) {
		
		baralho = new Baralho();
		mesa = baralho.drawCarta();

		jogador = new Jogador[jogadores];
		
		for (int i = 0; i < jogadores; i++)
			this.jogador[i] = new Jogador("Player "+(i+1));

	}

	public int matchCarta(Carta carta) {
		
		int score = -2;

		if (carta.getNaipe() == mesa.getNaipe())
			score = 1;
			
		if (carta.getValor() == mesa.getValor())
			score = 4;

		return score;
	}

	public void setMesa(Carta carta) {
		mesa = carta;
	}

	public Carta getMesa() {
		return mesa;
	}

	public Carta drawCarta() {
		return baralho.drawCarta();
	}

	public Jogador getJogador(int jogador) {
		return this.jogador[jogador];
	}
	
	public String getNomeJogador(int jogador){
		
		return this.jogador[jogador].getNome();
	}

	
}
