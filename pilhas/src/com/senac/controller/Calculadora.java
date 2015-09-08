package com.senac.controller;

import com.senac.pilha.Pilha;
import com.senac.view.ConsoleView;

public class Calculadora {

	private ConsoleView view;
	private Pilha<Double> numeros;

	public Calculadora() {

		view = new ConsoleView();
		this.numeros = new Pilha<Double>();

	}

	public static void main(String[] args) {

		new Calculadora().run();
	}

	public void run() {

		System.out.println("Teste");
		System.out.println(transformarPosEmIn(""));

	}

	public String transformarPosEmIn(String inFixa) {

		String posFixa = "";
		char charAnterior = ' ';
		inFixa = "(32 + 4) * 2";

		Pilha<Character> operador = new Pilha<Character>();

		for (int i = 0; i < inFixa.length(); i++) {

			if (Character.isDigit(inFixa.charAt(i))) {

				
				if (isNumero(String.valueOf(charAnterior))) {

					posFixa.trim();
					System.out.println("é numero");
				}

				posFixa = posFixa + String.valueOf(inFixa.charAt(i));
				posFixa += " ";

			}
//
//			if (isOperador(String.valueOf(inFixa.charAt(i)))) {
//
//				char op = inFixa.charAt(i);
//
//				if (op == '(') {
//
//					operador.push(op);
//				}
//
//				else if (op == ')') {
//
//					while (!operador.isEmpyt()) {
//
//						if (operador.peek().equals("(")) {
//
//							
//								operador.pop();
//							
//						}
//
//						posFixa = posFixa + String.valueOf(operador.pop());
//						posFixa = posFixa + " ";
//					}
//
//				} else if (op == '+' || op == '-') {
//
//					if (!operador.isEmpyt()) {
//						
//						 if (operador.peek().equals("*") ||
//						 operador.peek().equals("/")) {
//						
//						 posFixa += String.valueOf(operador.pop());
//						 posFixa += " ";
//						 }
//
//						operador.push(op);
//					}
//				} else if (op == '*' || op == '/') {
//
//					posFixa += String.valueOf(operador.pop());
//					posFixa += " ";
//
//				}
//
//			}
//
		charAnterior = inFixa.charAt(i);
		System.out.println(charAnterior);

		}

		while (!operador.isEmpyt()) {

			posFixa += operador.pop();
			posFixa += " ";
		}

		return posFixa.trim();
	}

	public void executarExpreInFixa(String expressao) {

		expressao += "3 11 2 - + 2 * 12 10 + *";

		String numTemp = "";
		String oper = "";

		for (int i = 0; i < expressao.length(); i++) {

			// Verificar se o caracter é um número
			if (isNumero(String.valueOf(expressao.charAt(i)))) {

				numTemp = numTemp + String.valueOf(expressao.charAt(i));

			}
			// Verificar se o caracter é espaço
			if (String.valueOf(expressao.charAt(i)).equals(" ")) {

				if (!numTemp.equals("")) {
					numeros.push(Double.parseDouble(numTemp));
					numTemp = "";

				}

			}

			if (isOperador(String.valueOf(expressao.charAt(i)))) {

				calcular(String.valueOf(expressao.charAt(i)));

			}

		}

	}

	public boolean isNumero(String numeroString) {

		String[] numeros = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"." };
		boolean isNumero = false;

		for (int i = 0; i < numeros.length; i++) {

			if (numeroString.equals(numeros[i])) {

				isNumero = true;
			}

		}

		return isNumero;
	}

	public boolean isOperador(String operador) {

		String[] operadores = { "+", "-", "*", "/", ")", "(" };
		boolean isOperador = false;

		for (int i = 0; i < operadores.length; i++) {

			if (operador.equals(operadores[i])) {

				isOperador = true;
			}
		}

		return isOperador;
	}

	public void calcular(String op) {

		double valor2 = (double) numeros.pop();
		double valor1 = (double) numeros.pop();

		double resultado = 0;

		if (op.equals("+")) {

			resultado = valor1 + valor2;
			System.out.println(valor1 + " " + op + " " + valor2 + " = "
					+ resultado);
		}
		if (op.equals("-")) {

			resultado = valor1 - valor2;
			System.out.println(valor1 + " " + op + " " + valor2 + " = "
					+ resultado);
		}
		if (op.equals("*")) {

			resultado = valor1 * valor2;
			System.out.println(valor1 + " " + op + " " + valor2 + " = "
					+ resultado);
		}
		if (op.equals("/")) {

			resultado = valor1 / valor2;
			System.out.println(valor1 + " " + op + " " + valor2 + " = "
					+ resultado);
		}

		numeros.push(resultado);
	}

	private int getPrioridade(String operador) {

		if (operador.equals(")") || operador.equals("(")) {

			return 1;
		} else if (operador.equals("+") || operador.equals("-")) {

			return 2;
		}

		else if (operador.equals("*") || operador.equals("/")) {

			return 3;
		} else {

			return 0;
		}

	}

}