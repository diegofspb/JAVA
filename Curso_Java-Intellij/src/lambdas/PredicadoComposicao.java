package lambdas;

import java.util.function.Predicate;

public class PredicadoComposicao {

	public static void main(String[] args) {
		// lembrando que Predicate recebe um argumento e retorna booleano
		Predicate<Integer> isPar = num -> num% 2 == 0;
		Predicate<Integer> isTresDigitos = num -> num >= 100 && num <= 999;
		
		System.out.println(isPar.and(isTresDigitos).negate().test(123));
		System.out.println(isPar.or(isTresDigitos).test(123));
		
		// acima são possibilidades de uso do 'and' e do 'or' em uma composição usando Predicate
		
	}
}
