package lambdas;

import java.util.function.Function;

public class Funcao {

	public static void main(String[] args) {
		// ao digitar Function + crt ele mostrou isso Function<T, R>
		// T = tipo e R = resultado, ou seja, T é o valor que será utilizado e R é o que terá de resposta
		// abaixo foram concatenadas as <Function>, prestar atenção que o tipo de retorno de uma 
		//Function terá que ser o tipo da entrada da função de outra Function para o .andThen funcionar
		Function<Integer, String> parOuImpar = numero -> numero % 2 == 0 ? "Par":"impar";
		// apply permite vc executar o método diretamente informando um parâmetro, como a Function<Integer, String>
		// repetindo, significa que vai entrar um número inteiro e a resposta será string
		System.out.println(parOuImpar.apply(33));
		///////////////////////////////////		
		Function<String, String> aResposta = resposta ->"A resposta eh = " + resposta;
		// .andThen() é uma função que permite vc concatenar resultados de funções e é utilizada no meio de uma função
		System.out.println(parOuImpar.andThen(aResposta).apply(33));
		///////////////////////////////////	
		Function<String, String> empolgado = valor -> valor + "!!!";
		System.out.println(parOuImpar.andThen(aResposta).andThen(empolgado).apply(33));
	}
}
