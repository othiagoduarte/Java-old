package com.senac.vetor;

public class Pilha<T> {

	private Object[] objetos;
	private int numObjetos;
	private int numeroLimite;
	private boolean limitado;

	/*
	 * Construtor: além do construtor original, sem parâmetros, existem duas
	 * sobrecargas. A primeira recebe uma coleção do tipo ICollection da qual os
	 * itens são copiados para a pilha. A segunda recebe um valor inteiro que
	 * define a capacidade inicial da lista. Sobre a capacidade inicial, valem
	 * os mesmos comentários feitos a respeito da outra classe.
	 */

	public Pilha() {

		this.objetos = new Object[1];
		this.numObjetos = 1;
		this.limitado = false;
		this.numeroLimite = 0;
	}

	public Pilha(int valorLimite) {

		if (valorLimite <= 0) {
			valorLimite = 1;
		}
		this.objetos = new Object[1];
		this.numObjetos = 1;
		this.limitado = true;
		this.numeroLimite = valorLimite;
	}

	public Pilha(Object[] colection) {

		this.objetos = colection;
		this.numObjetos = 1;
		this.limitado = false;
		this.numeroLimite = 0;

	}

	// Push: insere um objeto (recebido como parâmetro) no fim da lista.

	public void push(T objeto) {

		aumentarPilha();
		objetos[numObjetos] = objeto;
		numObjetos++;
	}

	// Pop: retorna e remove o elemento do topo da pilha, ou seja, o último que
	// foi inserido.

	public Object pop() {

		Object temp = objetos[objetos.length - 1];

		if (!isEmpyt()) {

			objetos[objetos.length - 1] = null;

			this.numObjetos--;

			return temp;

		} else {

			return null;

		}

	}

	// Peek: retorna o elemento do topo da pilha, porém sem que este seja
	// removido.

	public Object peek() {

		if (!isEmpyt()) {
			return objetos[objetos.length - 1];
		} else {
			return null;
		}
	}

	public boolean isEmpyt() {

		return this.numObjetos == 0;

	}

	private boolean aumentarPilha() {

		if (verificarTamanhoLimite()) {
			
			Object[] objetosTemp = new Object[objetos.length + 1];
			System.arraycopy(this.objetos, 0, objetosTemp, 0,
					this.objetos.length);
			this.objetos = objetosTemp;

			return true;
		} else {
			return true;
		}

	}

	private boolean verificarTamanhoLimite() {

		boolean teste = true;
		if (this.limitado) {

			if (objetos.length <= this.numeroLimite) {

				teste = false;

			}
		}
		return teste;
	}
}