package colecoes;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoBaguncado {

	public static void main(String[] args) {
		
		// estudando a coleção SET
		
		/*
		 * Set pode ser:
		 * 	- heretogeneo;
		 *  - homogêneo;
		 *  - só aceita objeto ou Caster (nome errado), pode notar abaixo que ele pega o double e transforma em Double
		 *  - nao aceita duplicados
		 *  - pode ser ordenado
		 *  - não é indexado
		 * */
		
		HashSet conjunto = new HashSet();
		// exemplo de conjunto de dados heterogêneo
		conjunto.add(1.2); // double -> Double
		conjunto.add(true); // boolean -> Boolean
		conjunto.add("teste"); // string -> String
		conjunto.add(1); // int -> Integer
		conjunto.add("x"); // char -> Caractere
		
		System.out.println("Tamanho do conjunto = " + conjunto.size() + " elementos");
		// vamos tentar acrescentar o elemento "x" e exibir o tamanho, vc verá que ele não aceita repetição e 
		 // o tamanho continuará o mesmo
		conjunto.add("x");
		System.out.println("Tamanho do conjunto = " + conjunto.size() + " elementos");
		// agora removendo um elemento do conjunto
		conjunto.remove("x");
		System.out.println("Tamanho do conjunto = " + conjunto.size() + " elementos");
		
		//criando um novo conjunto, porém utilizando apenas o Set
		
		Set nums = new HashSet();
		
		nums.add(1);
		nums.add(2);
		nums.add(3);
		
		System.out.println(nums);
		System.out.println(conjunto);
		// agora somando os dois conjuntos
		conjunto.addAll(nums);
		System.out.println(conjunto);
		// agora interceção entre os dois conjuntos
		conjunto.retainAll(nums);
		System.out.println(conjunto);
		//esvaziando o conjunto
		conjunto.clear();
		System.out.println(conjunto);
		
	}
	
}
