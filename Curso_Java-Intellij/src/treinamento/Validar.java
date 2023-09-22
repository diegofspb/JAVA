package treinamento;

public class Validar {

    private Validar(){};

    public static void validarTeste(Aluno aluno){
        if (aluno == null){
            throw new IllegalArgumentException("Objeto está null");
        }
        if (aluno.nota < 0){
            throw new NumeroNegativoException("nota menor que zero (-)");
        }
    }
}
