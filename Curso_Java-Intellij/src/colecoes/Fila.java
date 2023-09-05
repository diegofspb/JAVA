package colecoes;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {

	public static void main(String[] args) {
		
		Queue<String> fila = new LinkedList<String>();
		
		// .add, caso vc adicione um nome na fila e não tenha mais espaço ele retorna um "erro"
		fila.add("Ana");
		// offer retorna verdadeiro se tiver espaço na fila ou falso caso não tenha espaço disponível
		fila.offer("Bia");
		fila.add("Carlos");
		fila.offer("Daniel");
		fila.add("Rafael");
		fila.offer("Gui");
		
		// .peek returna null se a fila estiver vazia
		System.out.println(fila.peek()); //.peek exibe o primeiro elemento da fila
		System.out.println(fila.element()); // .element também exibe o primeiro elemento
		// porém se a fila estiver vazio = error!
		System.out.println(fila.isEmpty()); // verifica se a fila está vazia
		System.out.println(fila.poll()); //.poll remove o elemento da lista
		System.out.println(fila.remove()); //..remove remove o elemento da lista
		// a diferença entre poll e remove é que o poll returna null se a fila estiver vazia
		 // e o remove retorna error! ou exceção, se a fila estiver vazia
		
	}
}
