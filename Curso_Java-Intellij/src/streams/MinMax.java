package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinMax {

	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("Ana", 7.1);
		Aluno a2 = new Aluno("Luna", 6.1);
		Aluno a3 = new Aluno("Gui", 8.1);
		Aluno a4 = new Aluno("GAbi", 10.1);
		
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4);
		
		Comparator<Aluno> melhorNota = (aluno1,aluno2) -> {
			if (aluno1.nota > aluno2.nota) return 1; //caso a nota do aluno1 for maior que aluno2 = retornar 1
			if (aluno1.nota < aluno2.nota) return -1; //caso a nota do aluno1 for menor  que aluno2 = retornar -1
			return 0; // caso nenhuma situação acima seja verdadeira, ou seja, caso as notas sejam iguais retorne 0;
		};
		Comparator<Aluno> piorNota = (aluno1,aluno2) -> {
			if (aluno1.nota > aluno2.nota) return -1; //caso a nota do aluno1 for maior que aluno2 = retornar 1
			if (aluno1.nota < aluno2.nota) return 1; //caso a nota do aluno1 for menor  que aluno2 = retornar -1
			return 0; // caso nenhuma situação acima seja verdadeira, ou seja, caso as notas sejam iguais retorne 0;
		};
		// .max(Comparator) e .min(Comparator) só funcionam com uso do comparator, então tem que usar o Comparator sempre antes
		System.out.println(alunos.stream().max(melhorNota).get());
		System.out.println(alunos.stream().min(piorNota).get());
		
		System.out.println(alunos.stream().min(melhorNota).get());
		System.out.println(alunos.stream().max(piorNota).get());
	}
}
