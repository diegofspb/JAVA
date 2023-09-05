package lambdas;

import java.util.Arrays;
import java.util.List;

// abaixo é exibido várias formas de usar o forEach, não desconsidere, pois cara forma resolve um problema diferente
public class Foreach {
	public static void main(String[] args) {		
     // Classe <List> do tipo string (String) com nome aprovados que recebe uma classe (Arrays) que auxilia a criar uma lista
		List<String> aprovados = Arrays.asList("Ana", "Bia","Lia", "Gui" );
	 // Executando um 'Foreach' na forma TRADICIONAL
		for(String nome: aprovados) {
			System.out.println(nome);
		}
	 // Executando um 'Foreach' junto com função lambda
		System.out.println("forEach + Funcao lambda - 01");		
		aprovados.forEach(nome-> System.out.println(nome));
	// executando um 'Method Reference' que torna o código ainda menor:
		System.out.println("\n Method Reference - usando System.out::println");
		aprovados.forEach(System.out::println); // não dá para concatenar com outras palavras ou variáveis
		//esse método acima busca uma função string da classe, aqui não encontrei classe importada então ele exibe só o loop
		System.out.println("forEach + Funcao lambda - 02");
		aprovados.forEach(nome -> meuImprimir(nome));
		System.out.println("\n Method Reference - 02");			
		aprovados.forEach(Foreach::meuImprimir);
		}
	// fora do método main, foi criado um outro método apenas para imprimir na tela um texto com um parâmetro em formato de String 
	static void meuImprimir(String nome) {
		System.out.println("oi meu nome eh = " + nome);	
	}
}
