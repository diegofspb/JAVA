package excecao.personalizadaB;

import excecao.Aluno; // import da classe Aluno para poder usá-la, pois está em outro pacote

public class TestandoValidacoes {

	public static void main(String[] args) {
		
		
		try {
			Aluno aluno = new Aluno("  ", -7);		
			Validar.alunoValidado(aluno); //alunoValidado é o nome da subclasse da classe Validar
		} catch (StringVaziaException e) { // StringVaziaException é o nome da exceção personalizada que criamos
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NumeroForaIntevaloException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("FIM!");
	}
}
