package lambdas;

import java.util.function.Predicate;

public class Predicado {

	public static void main(String[] args) {
/* Predicate é uma função do tipo interface funcional com retorno booleano.
o que a função Predicate faz é:
recebe um valor (T), ou seja, Predicate<T>, verifica uma situação e 
retorna booleano =  Tipo(valor) -> Boolean 

'isCaro' é a mesma coisa que dizer 'é caro ?' é o nome de uma variável qualquer
'prod' é um parâmetro do tipo <Produto>, é como se automaticamente vc também tivesse 
instanciando Produto
e o parâmetro 'prod' é a própria instancia de Produto, ou seja, é o objeto de Produto
por isso vc pode usar prod.nome, prod.preco ou prod.desconto
			Exemplo simples:
 Predicate<Produto> isCaro = prod -> false; se usar assim, vc está dizendo que o valor do objeto 'prod' ja é falso
	    	Exemplo:
*/
		Predicate<Produto> isCaro = prod -> (prod.preco * (1-prod.desconto)) >=750 ;
// explicando acima é caso o preço do produto com desconto é maior que 750 então é = true, 
		// ou seja = caro
// resumindo o preço com desconto é maior que 750, verdade ou mentira ?
		
		Produto produto = new Produto("Notebook", 3893.89, 0.15);
		System.out.println(isCaro.test(produto));
		
	}
}
