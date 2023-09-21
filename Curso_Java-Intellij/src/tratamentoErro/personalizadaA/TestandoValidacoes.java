package tratamentoErro.personalizadaA;

import tratamentoErro.Aluno; // import da classe Aluno que está fora da package para poder usá-la

public class TestandoValidacoes {

	public static void main(String[] args) {
		
		
		try {
			Aluno aluno = new Aluno("  ", -7);		
			Validar.alunoValidado(aluno); //alunoValidado é o nome da subclasse da classe Validar, note que não foi preciso instanciar a classe Validar (veja explicação na classe Validar)
		} catch (StringVaziaException e) { // StringVaziaException é o nome da exceção personalizada que criamos
			System.out.println(e.getMessage());
		} catch (NumeroForaIntevaloException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		Validar.alunoValidado(null);
		
		System.out.println("FIM!");
	}
}
