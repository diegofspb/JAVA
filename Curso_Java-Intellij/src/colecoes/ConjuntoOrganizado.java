package colecoes;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ConjuntoOrganizado {

	public static void main(String[] args) {
		// a coleção Set iniciando apenas com 1 tipo de dado
		/*Set<String> lista = new HashSet<String>();
		 * */
		//tanto o SortedSet quanto o TreeSet organizam a lista, porém se fosse executado o
		// HashSet os nomes quando forem impressos não ficarão na ordem alfabética
		SortedSet<String> lista = new TreeSet<String>(); 
		lista.add("Ana");
		lista.add("Carlos");
		lista.add("Luca");
		lista.add("Pedro");
		
		// desta forma homogênea, é possível utilizar o foreach
		
		for(String nome: lista) {
			System.out.println(nome);
		}
	}
}
