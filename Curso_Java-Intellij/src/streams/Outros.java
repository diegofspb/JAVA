package streams;

import java.util.Arrays;
import java.util.List;

public class Outros {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("Ana", 7.1);
		Aluno a2 = new Aluno("Luna", 6.1);
		Aluno a3 = new Aluno("Gui", 8.1);
		Aluno a4 = new Aluno("GAbi", 10.1);
		Aluno a5 = new Aluno("Ana", 7.1);
		Aluno a6 = new Aluno("Luna", 6.1);
		Aluno a7 = new Aluno("Gui", 8.1);
		Aluno a8 = new Aluno("GAbi", 10.1);
		
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4);
		// distinct serve para não repetir os objetos que possuem os mesmos valores
		System.out.println("distinct...");
		alunos.stream().distinct().forEach(System.out::println);
		// usando o SKIP e o LIMIT
		System.out.println("\nSkip/Limit...");
		alunos.stream()
			.distinct()
			.skip(2) //skip vc diz quantos elementos vai querer que sejam pulados
			.limit(3) //você aqui limita quantos elementos serão exibidos
			.forEach(System.out::println);
		// takeWhile parece com o filter
		System.out.println("\ntakeWhile...");
		alunos.stream()
			.distinct()			
			.takeWhile(a -> a.nota >=7) //você aqui limita quantos elementos serão exibidos
			.forEach(System.out::println);
	}
}
