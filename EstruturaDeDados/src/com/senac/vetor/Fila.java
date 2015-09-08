package com.senac.vetor;

public class Fila<T> {

	private Object[] objetos;
	private int numObjetos;
	private int H;
	private int T;

	public Fila() {

		this.objetos = new Object[1];
		this.numObjetos = 1;
	}

	// Remove
	public void push(T objeto) {
		if (!isCheia()) {
			this.objetos[this.T] = objeto;
		}

	}

	//
	public void pop() {

		if (!isCheia()) {

		}
	}

	//
	public void peek() {

		if (!isCheia()) {

		}
	}

	public boolean isVazia() {

		return this.H == this.T;
	}

	public boolean isCheia() {

		return this.T == objetos.length;
	}
	
	public int proximo(){
		
		numObjetos++;
		
		return numObjetos % objetos.length;
		
	}
	
}
