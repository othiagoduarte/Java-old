package test.com.senac.pilha;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.senac.pilha.Pilha;

public class PilhaTest {

	Pilha<String> nomesPilha;

	@Before
	public void setUp() throws Exception {

		nomesPilha = new Pilha<String>();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testInserirElementosNaPilhaERetornarOTamanhoDaPilha() {

		// Preparar ambiente

		// Executar operacoes

		// Avaliar Resultado

		nomesPilha.push("nome");

		assertEquals(1, nomesPilha.size());

		nomesPilha.push("nome");

		assertEquals(2, nomesPilha.size());

		nomesPilha.push("nome");

		assertEquals(3, nomesPilha.size());

	}

	@Test
	public void testarOtamanhoDaPilhaQuandoRemoveElemento() {

		// Preparar ambiente
		nomesPilha.push("nome1");
		nomesPilha.push("nome2");
		nomesPilha.push("nome2");
		nomesPilha.push("nome3");
		nomesPilha.push("nome4");

		// Executar operacoes
		nomesPilha.pop();// 1
		nomesPilha.pop();// 2
		nomesPilha.pop();// 3

		// Avaliar Resultado

		assertEquals(2, nomesPilha.size());
		assertEquals("nome2", nomesPilha.pop());

	}

	@Test
	public void testarInserirObjetodeTipoDiferente() {

		nomesPilha.push("12345");

	}

	@Test
	public void testarInstaciarPilhaComTamanhoFixo() {

		Pilha<String> nome = new Pilha<String>(3);

		nome.push("nome1");
		assertEquals(1, nome.size());
		nome.pop();
		assertEquals(0, nome.size());

		nome.push("nome1");
		assertEquals(1, nome.size());
		nome.push("nome2");
		assertEquals(2, nome.size());

	}

	@Test
	public void testarInstanciarPilhaPassandoUmaColeçãoNoConstrutor() {

		// Preparar ambiente

		String[] Vetornome = { "nome1", "nome2", "nome3", "nome4", "nome5",
				"nome6" };

		Pilha<String> pilhanome = new Pilha<String>(Vetornome);
		// Executar operacoes

		assertEquals("nome6", pilhanome.pop());

		// Avaliar Resultado

		assertEquals(5, pilhanome.size());

	}

}
