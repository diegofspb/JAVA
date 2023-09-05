package streams;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/*
O método filter() é utilizado para realizar uma operação de filtragem nos elementos de um Stream 
com base em um predicado (uma expressão lambda que retorna um valor booleano). 
O método cria um novo Stream contendo apenas os elementos que atendem ao critério especificado no predicado.
 */
public class Filter {
	public static void main(String[] args) {		
		Aluno a1 = new Aluno("Ana", 7.8);
		Aluno a2 = new Aluno("Bia", 5.8);
		Aluno a3 = new Aluno("Daniel", 9.8);
		Aluno a4 = new Aluno("Gui", 6.8);
		Aluno a5 = new Aluno("Rebeca", 7.1);
		Aluno a6 = new Aluno("Pedro", 8.8);
		// se no lugar de List<Aluno> fosse  List<Integer>, então a lista seria apenas de números e não de objetos 
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5, a6); 
		// obs.: o código abaixo funcionaria se a lista alunos fosse de números tipo Integer, porém é uma lista de objeto
		// Predicate<Integer> aprovado = a -> a.nota >= 7; não funcionou por que a = integer e aluno é um objeto 
		// já no código abaixo, filter(a -> a.nota >= 7), este 'a' realmente é um objeto
		// o método filter() só funciona com uso anterior de uma interface Predicate<>
		Predicate<Aluno> estaAprovado = a -> a.nota >= 7; // aqui sim, estou dizendo que o 'a' é um objeto do tipo Aluno
		Function<Aluno, String> saudacaoAprovado = a -> "Parabens " + a.nome + " Voce foi aprovado";
		alunos.stream()
			// .filter(a -> a.nota >= 7) funciona assim também			   
			.filter(estaAprovado)
			// .map(a -> "Parabens " + a.nome + " Voce foi aprovado") funciona assim também	
			.map(saudacaoAprovado)
			.forEach(System.out::println);		
	}
}
