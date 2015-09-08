package com.senac.controller;

import com.senac.pilha.Pilha;
import com.senac.view.ConsoleView;

public class Binario {

	private Pilha<Integer> pilha;
	private ConsoleView view;

	public Binario() {

		pilha = new Pilha<Integer>();
		view = new ConsoleView();

	}

	public static void main(String[] args) {

		new Binario().run();
	}

	private void run() {

		view.showMessage(converterNumero(view.readInt("Digite um número")));

	}

	public String converterNumero(int numero) {

		String bin = "";
		int resto = 0;

		while (numero > 0) {

			resto = numero % 2;

			numero /= 2;

			pilha.push(resto);

		}

		while (pilha.size() > 0) {

			bin = bin + pilha.pop();

		}

		return bin;
	}

}
