package com.senac.pilha;

public class Pilha<T> {

	private Object[] objetos;
	private int numObjetos;
	private int numeroLimite;
	private boolean limitado;

	public Pilha() {

		this.objetos = new Object[1];
		this.numObjetos = 0;
		this.limitado = false;
		this.numeroLimite = 0;
	}

	public Pilha(int valorLimite) {

		if (valorLimite <= 0) {
			valorLimite = 1;
		}
		this.objetos = new Object[1];
		this.numObjetos = 0;
		this.limitado = true;
		this.numeroLimite = valorLimite;
	}

	public Pilha(Object[] colection) {

		this.objetos = colection;
		this.numObjetos = this.objetos.length;
		this.limitado = false;
		this.numeroLimite = 0;

	}

	public int size() {

		return this.numObjetos;
	}

	// Push: insere um objeto (recebido como parâmetro) no fim da lista.

	public void push(T objeto) {

		aumentarPilha();
		objetos[numObjetos] = objeto;
		this.numObjetos++;
	}

	// Pop: retorna e remove o elemento do topo da pilha, ou seja, o último que
	// foi inserido.

	public Object pop() {

		Object temp = objetos[numObjetos - 1];

		if (!isEmpyt()) {

			objetos[numObjetos - 1] = null;

			this.numObjetos--;

			return temp;

		} else {

			return null;

		}

	}

	// Pull : remove o elemento do topo da pilha, ou seja, o último que
	// foi inserido.
	public void pull() {

		if (!isEmpyt()) {
			objetos[objetos.length - 1] = null;

			this.numObjetos--;
		}

	}

	// Peek: retorna o elemento do topo da pilha, porém sem que este seja
	// removido.

	public Object peek() {

		Object temp = objetos[numObjetos - 1];
		if (!isEmpyt()) {
			return temp;
		} else {
			return null;
		}
	}

	public boolean isEmpyt() {

		return this.numObjetos <= 0;

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

		if (this.limitado) {

			if (numObjetos <= this.numeroLimite) {

				return false;

			} else {

				return true;
			}
		} else {

			return true;
		}
	}
}