package exercicios_sala;

import java.util.Scanner;

public class AlunoMain {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe o nome do aluno: ");
        String nomeAluno = entrada.nextLine();

        System.out.println("Qual a quantidade de notas? :");
        int numNotas = entrada.nextInt();

        Aluno aluno1 = new Aluno(nomeAluno, numNotas);

        aluno1.lerNotas(entrada);

        if(aluno1.aprovado()){
            System.out.println("O aluno foi aprovado! a média = " + aluno1.media());
        }else{
            System.out.println("O aluno foi reprovado! a média = " + aluno1.media());
        }

        entrada.close();


    }
}
