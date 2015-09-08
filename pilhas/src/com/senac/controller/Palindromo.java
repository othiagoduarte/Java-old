package com.senac.controller;

import com.senac.pilha.Pilha;
import com.senac.view.ConsoleView;

public class Palindromo {

	private Pilha<String> palavraPilha;
	private ConsoleView view;

	public Palindromo() {

		this.palavraPilha = new Pilha<String>();
		this.view = new ConsoleView();

	}

	public static void main(String[] args) {
		new Palindromo().run();
	}

	public void run() {

		String palavra = view.readLine("Digite uma palavra");
		String resultado = "";

		for (int i = 0; i < palavra.length(); i++) {

			char temp = palavra.charAt(i);
			String temp2 = String.valueOf(temp);
			palavraPilha.push(temp2);

		}

		int tamanho = palavraPilha.size();
		for (int i = 0; i < tamanho; i++) {

			resultado = resultado + palavraPilha.pop();

		}

		if (resultado.equalsIgnoreCase((palavra))) {

			view.showMessage("a palavra " + palavra + " é um palindromo");

		} else {
			view.showMessage("a palavra " + palavra + " não é um palindromo");
		}
		view.showMessage(resultado);
	}
}
