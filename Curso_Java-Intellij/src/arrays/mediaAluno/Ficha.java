package arrays.mediaAluno;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ficha {
    public static void main(String[] args) {
        Aluno a1 = new Aluno();

        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o nome do aluno: ");
        a1.setNome(entrada.next());
        a1.notas = new double[3];

        for (int i = 0; i < a1.notas.length; i++) {
            boolean condicao = false;
            while (!condicao) {
                try {
                    System.out.printf("Informe a %d nota do aluno: \n", (i + 1));
                    a1.notas[i] = entrada.nextDouble();
                    condicao = true;
                } catch (InputMismatchException e) { // foi necessário importar essa exceção
                    System.out.println("Entrada inválida. Por favor, insira um número válido.");
                    entrada.next(); // Limpar a entrada incorreta
                }
            }
        }
        double media = a1.media(a1.notas);
        System.out.println("A média do aluno é " + media);
        if(media < 6){
            System.out.println("Aluno Reprovado!");
        }else{
            System.out.println("Aluno Aprovado!");
        }
    }
}
