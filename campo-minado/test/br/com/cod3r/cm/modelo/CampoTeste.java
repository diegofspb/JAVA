package br.com.cod3r.cm.modelo;



import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
/*
para evitar importar várias coisas de  org.junit.jupiter.api.Assertions.
 
basta fazer assim:
	org.junit.jupiter.api.Assertions.*
*/
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cod3r.cm.excecao.ExplosaoException;

public class CampoTeste {

	private Campo campo;
	// o que é privado é o nome da variável = 'campo' que é do tipo 'Campo'
	// private campo = new Campo(3,3); de deixasse assim, apenas 1 valor seria testado
	// para fazer com que o valor seja renovado usa-se o @BeforeEach
	@BeforeEach // significa que para cada teste executado ele executará este aqui
	void iniciarCampo() {
		//obs.: a Classe Campo só aceita ela mesmo como parâmetro
		campo = new Campo(3,3);	// criado esta posição para comparar com QUALQUER outra posição	
	}

// agora temos uma posição para comparar todas as funções abaixo que é o objeto instanciado 'campo'
	
	@Test
	void testeVizinhoDistanciaEsquerda() {	
//novamente vamos intanciar um objeto do tipo Campo, aqui o nome da variável é = vizinho
// isso porque qualquer posição é um objeto e deve seguir o método construtor da classe 'Campo'
		// ou seja, tem que definir a posição (x,y)
		Campo vizinho = new Campo(3,2);	// posição 3,2 é manualmente digitado a posição esquerda	
		//comparando uma posição com outra posição
		boolean resultado = campo.adicionarVizinho(vizinho);		
		assertTrue(resultado);
		//assertTrue só espera resultado true, se for false dá erro no teste
	}
	
	@Test
	void testeVizinhoDistanciaDireita() {		
		Campo vizinho = new Campo(3,4);	 // posição 3,4 é manualmente digitado a posição direita	
		boolean resultado = campo.adicionarVizinho(vizinho);		
		assertTrue(resultado);		
	}
	
	@Test
	void testeVizinhoDistanciaCima() {		
		Campo vizinho = new Campo(2,3);		
		boolean resultado = campo.adicionarVizinho(vizinho);		
		assertTrue(resultado);		
	}
	@Test
	void testeVizinhoDistanciaBaixo() {		
		Campo vizinho = new Campo(4,3);		
		boolean resultado = campo.adicionarVizinho(vizinho);		
		assertTrue(resultado);		
	}
	@Test
	void testeNaoVizinho() {		
		Campo vizinho = new Campo(1,1);		
		boolean resultado = campo.adicionarVizinho(vizinho);		
		assertFalse(resultado);		
	}
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao(); // marcado inicia = false, porém aqui ele fica true
		campo.alternarMarcacao(); // ao chamar novamente, o marcado = false por isso funciona abaixo
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {		
		assertTrue(campo.abrir());
	}
	@Test
	void testeAbrirNaoMinadoMarcado() {	
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	@Test
	void testeAbrirMinadoMarcado() {	
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	@Test
	void testeAbrirMinadoNaoMarcado() {			
		campo.minar();
		
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
;		});
		
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrircomVizinhos1() {
		Campo campo11 = new Campo(1,1);
		Campo campo22 = new Campo(2,2);
		
		campo22.adicionarVizinho(campo11);
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());
		
	}
	
	@Test
	void testeAbrircomVizinhos2() {
		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1,1);
		campo12.minar();
		
		
		Campo campo22 = new Campo(2,2);		
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && !campo11.isFechado());
		
	}
	
	
	
}
