package streams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Map {

	public static void main(String[] args) {
		
		Consumer<String> print = System.out::print;
		
		List<String> marcas = Arrays.asList("Bmw ", "Audi ", "Honda ");
		
		marcas.stream().map(m -> m.toUpperCase()).forEach(print);
		
/*	UnaryOperator é uma INTERFACE que recebe um valor de entrada e retorna um valor de saída do mesmo tipo.
 Ela possui um único método abstrato chamado apply que recebe um argumento do tipo T */
		UnaryOperator<String> maiuscula = n -> n.toUpperCase();
/*O método charAt() é usado para obter o caractere presente em uma posição específica (índice) dentro de uma string.*/
		UnaryOperator<String> primeiraLetra = n -> n.charAt(0) + "";
		UnaryOperator<String> grito = n -> n + "!!!";
		System.out.println("\n\nUsando composicao: \n");
		marcas.stream().map(maiuscula).map(primeiraLetra).map(grito).forEach(print);
		
	}
}
