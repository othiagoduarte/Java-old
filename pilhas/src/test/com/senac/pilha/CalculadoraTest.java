package test.com.senac.pilha;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import com.senac.controller.Calculadora;

public class CalculadoraTest {

	

	@Test
	public void test() {
		
		Calculadora calc = new Calculadora();
		
		calc.transformarPosEmIn("5 + 5 * 2");
		
		
	}

}
