package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Match {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("Ana", 7.1);
		Aluno a2 = new Aluno("Luna", 6.1);
		Aluno a3 = new Aluno("Gui", 8.1);
		Aluno a4 = new Aluno("GAbi", 10.1);
		// match é o mesmo do tinder, 'deu match?' e também é uma função terminal como foreach
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4);
		Predicate<Aluno> aprovado = a -> a.nota >= 7;
		// allMatch retorna booleando, ou seja, todos os alunos foram aprovados ?
		System.out.println(alunos.stream().allMatch(aprovado));
		// anyMatch, algum aluno reprovado ?
		System.out.println(alunos.stream().anyMatch(aprovado));
		// noneMatch, todos reprovados ?
		System.out.println(alunos.stream().noneMatch(aprovado));
	}
}
