package testes_treinamento;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Teste {
    public static void main(String[] args) {

        Aluno a1 = new Aluno("Maria", 5.6);
        Aluno a2 = new Aluno("João", 8.0);
        Aluno a3 = new Aluno("Maria", 5.6);
        Aluno a4 = null;

        try {
            System.out.println(a4.nome);
        }catch (ArithmeticException e){
            System.out.println("Erro, o nome é " + e.getCause());
        }



    }
}
