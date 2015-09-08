package com.senac.jogos;

public class Jogador {
	
	private int pontos;
	private String nome;
	
	public Jogador(String nome)
	{
		this.pontos = 0;
		this.nome = nome;
		
	}
	
	public int getPontos()
	{
		return this.pontos;
	}

	public void addPontos(int amount)
	{
		this.pontos += amount;
	}
	
	public void subtractPontos(int amount)
	{
		this.pontos -= amount;
	}
	
	public void setPontos(int pontos)
	{
		this.pontos = pontos;
	}
	
	public String getNome(){
		
		return this.nome;
	}
	
}










