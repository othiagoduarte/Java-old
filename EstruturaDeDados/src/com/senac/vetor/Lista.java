package com.senac.vetor;

public class Lista<T> {

	private Object[] objetos;
	private int numObjetos;

	public Lista() {

		this.objetos = new Object[1];
		this.numObjetos++;
	}

	private void aumentarVetor() {

		Object[] objetosTemp = new Object[this.objetos.length];

		System.arraycopy(this.objetos, 0, objetosTemp, 0, this.objetos.length);

	}

	public void incluir(T objetos) {

		aumentarVetor();
		this.objetos[numObjetos] = objetos;
		this.numObjetos++;

	}

	public boolean inserir(int indice, T objeto) {

		boolean valido = false;

		if (indice <= numObjetos) {
			valido = true;

			aumentarVetor();
			Object[] objetosTemp = new Object[this.objetos.length];
			System.arraycopy(this.objetos, indice, objetosTemp, (indice + 1),
					(this.objetos.length - indice));
			this.objetos = objetosTemp;
			this.objetos[indice] = objeto;
			this.numObjetos++;

		}

		return valido;

	}

	public boolean remover(int indice) {

		boolean valido = false;

		if (indice < this.objetos.length) {

			System.arraycopy(this.objetos, indice, this.objetos, (indice - 1),
					this.objetos.length - indice);
			this.numObjetos--;
		}

		return valido;

	}

	public int size() {

		return this.numObjetos;
	}

}
