package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class desafioMap {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);		
		
		UnaryOperator<String> inverter = s -> new StringBuilder(s).reverse().toString();
		
		// Function<Integer, String> binaryString = n -> Integer.toBinaryString(n); desconsiderar isso pois ja existe uma
		// função java que é possível utilizar diretamente no map
		
		Function<String, Integer> binarioParaInt = s -> Integer.parseInt(s,2);
		// sempre que usar os dois pontos :: significa uma referência ao método sem invocar ele para utilizar
		// (Integer::toBinaryString) é a Referência do Método.
		nums.stream().map(Integer::toBinaryString).map(inverter).map(binarioParaInt).forEach(System.out::println);
		/* Integer.parseInt(s, 2): Essa parte realiza a conversão da String binária s para um valor Integer. 
		 * O segundo argumento 2 é a base numérica, que indica que a String está representando um número em base binária. 
		 * O método parseInt() analisa a String binária e retorna o valor Integer equivalente.
		 */
	}
}
