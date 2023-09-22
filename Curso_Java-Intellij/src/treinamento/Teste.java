package treinamento;


public class Teste {
    public static void main(String[] args) {

        try {
            Aluno aluno = new Aluno("MARIA", -5.6);
            Validar.validarTeste(aluno);
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("código continou");;
    }
}
