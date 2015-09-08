package com.senac.view;

import static java.lang.System.*;

import java.util.Scanner;

public class ConsoleView {

	private static Scanner teclado = new Scanner(System.in);

	public ConsoleView() {

	}

	public void showMessage(String msg) {

		out.println(msg);

	}

	public void showMenu(String[] msg) {

		linha();
		for (int i = 0; i < msg.length; i++) {

			showMessage((i+1)+" - "+msg[i]);
		}
		linha();
	}

	public String readLine(String msg) {
		boolean validar = true;
		String ret = "";
		while (validar) {
			showMessage(msg);

			ret = teclado.nextLine();
			teclado.reset();
			if (ret.length() >= 2) {

				validar = false;
			}
		}

		return ret;
	}

	public int readInt(String msg) {

		showMessage(msg);
		int ret = teclado.nextInt();
		teclado.reset();
		return ret;
	}

	public double readDouble(String msg) {

		showMessage(msg);
		double ret = teclado.nextDouble();
		teclado.reset();
		return ret;
	}

	public void limparTela() {

		showMessage("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

	}

	public void validarOperação(boolean operação) {

		if (operação) {
			showMessage("Operação Realizada com sucesso");
		} else {
			showMessage("Operação invalida");
		}

	}

	public void linha() {
		showMessage("=========================");
	}
}
