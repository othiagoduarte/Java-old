package com.senac.data;

import java.io.FileWriter;
import java.io.IOException;

public class SalvarArquivo {

	private FileWriter arquivo;
	
		public SalvarArquivo(String filename)
		{
			try {
				arquivo = new FileWriter(filename);
			} catch (IOException e) {
				e.printStackTrace();
				arquivo = null;
			}
		}
	
		public void gravar(String msg) {
			if (arquivo == null)
				return;
			try {
				arquivo.write(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		public void close() {
			if (arquivo == null)
				return;
			try {
				arquivo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	

	
	
	
}
