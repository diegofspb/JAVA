package streams;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class desafioFilter {
	public static void main(String[] args) {
		// tenho um site com produtos, destacar os produtos com mais de 30% desconto + frete gratis
		
		produtoDesafio produto1 = new produtoDesafio("copo", 7.0, 0.22, true);
		produtoDesafio produto2 = new produtoDesafio("copo", 7.5, 0.22, false);
		produtoDesafio produto3 = new produtoDesafio("retrato", 3.9, 0.4, true);
		produtoDesafio produto4 = new produtoDesafio("quadro", 9.5, 0.31, false);
		produtoDesafio produto5 = new produtoDesafio("garfo", 7.8, 0.13, true);
		produtoDesafio produto6 = new produtoDesafio("faca", 6.3, 0.10, false);
		
		List<produtoDesafio> produtos = Arrays.asList(produto1, produto2, produto3, produto4, produto5, produto6);		
		Predicate<produtoDesafio> promocao = p -> p.desconto >= 0.3;
		Predicate<produtoDesafio> freteGratis = p -> p.frete == true;
		Function<produtoDesafio, String> resultado = p -> p.nome;
		
		produtos.stream().filter(promocao).filter(freteGratis).map(resultado).forEach(System.out::println);
		
	}
}
