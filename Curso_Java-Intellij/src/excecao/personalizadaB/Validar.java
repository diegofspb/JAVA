package excecao.personalizadaB;

import excecao.Aluno;

public class Validar {

	private Validar() {
		
	}
	
	public static void alunoValidado(Aluno aluno) throws StringVaziaException, NumeroForaIntevaloException {
		if(aluno == null) {
			throw new IllegalArgumentException("O aluno esta nulo !"); // caso o ojbeto não exista = não tenha sido instanciado
		}
		if(aluno.nome == null || aluno.nome.trim().isEmpty()) { //objeto criado, porém nome vazio
			throw new StringVaziaException("nome");
		}
		if(aluno.nota < 0 || aluno.nota>10) { // caso a nota seja negativo ou maior que 0
			throw new NumeroForaIntevaloException("nota");
		}
	}
}
