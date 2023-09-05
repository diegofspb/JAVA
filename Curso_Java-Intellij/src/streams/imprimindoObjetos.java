package streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class imprimindoObjetos {

	public static void main(String[] args) {
		
		/*
		List: List é uma interface em Java,  é representada pela classe 'java.util.List.' 
		representa uma lista ordenada de elementos, onde cada elemento pode ser acessado por um índice. 
	
		Uma lista permite elementos duplicados e pode crescer ou encolher
		<String>: especifica que a lista aprovados irá conter apenas elementos do tipo String.

		Arrays.asList("Lu", "Gui", "Luca", "Ana"): É um método estático da classe Arrays que converte uma lista de 
		elementos em um ArrayList, que é uma implementação da interface <List>. 
		Os elementos que estão entre parênteses são os elementos que serão adicionados à lista. 
		*/
		
		List<String> aprovados = Arrays.asList("Lu", "Gui", "Luca", "Ana");
		
		System.out.println("Usando o foreach..."); //iteração comum
		for(String nome: aprovados) {
			System.out.println(nome);
		}
		/*
		 * Iterator é uma interface do Java (java.util.Iterator). 
		 * percorre sequencialmente os elementos de uma coleção sem expor a estrutura interna. 
		 */
		System.out.println("\nUsando Iterator"); 
		Iterator<String> iterator = aprovados.iterator(); //iteração usando interface Iterator
		// a INTERFACE ITERATOR possui 3 métodos, abaixo apenas exemplo de 1 que é o .hasNext()
		//iterator.hasNext() retorna valor booleano true se ainda tiver algum elemento a ser iterado
		// obs.: Iterator é a interface, mas neste exemplo usamos o iterator como nome da classe = nao confundi
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("\nUsando Stream...");
		Stream<String> stream = aprovados.stream();
//O método stream() é um método fornecido pela interface List<>, que retorna um Stream dos elementos da lista.
		stream.forEach(System.out::println);
		/*
 * com o uso da interface Stream, podemos realizar operações funcionais nos elementos da lista sem a 
 * necessidade de usar estruturas de controle tradicionais, tornando o código mais expressivo e conciso. 
 * Além disso, o Stream oferece várias outras operações, como filter, reduce, collect, que podem ser usadas 
 * para manipular e processar dados de forma poderosa e flexível.
 */
		
	}
}
