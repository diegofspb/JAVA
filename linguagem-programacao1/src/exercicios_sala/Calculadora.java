package exercicios_sala;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean loop = true;

        do{
            System.out.println("#### exercicios_sala.Calculadora ####");
            System.out.println("Primeiro número: ");
            double num1 = entrada.nextDouble();
            System.out.println("Segundo número: ");
            double num2 = entrada.nextDouble();

            System.out.println("Escolha uma das opções:\n1 - somar\n2 - diminuir\n3 - multiplicar\n4 - dividir");
            int escolha = entrada.nextInt();

            System.out.println("Calculo: ");

            switch (escolha) {
                case 1:
                    System.out.println( num1 + " + " + num2 + " = " + (num1 + num2));
                    break;
                case 2:
                    System.out.println( num1 + " - " + num2 + " = " + (num1 - num2));
                    break;
                case 3:
                    System.out.println( num1 + " * " + num2 + " = " + (num1 * num2));
                    break;
                case 4:
                    System.out.println( num1 + " / " + num2 + " = " + (num1 / num2));
                    break;
            }
            System.out.println("########################");
            System.out.println("Escolha uma das opções:\n1 - Sair\n0 - Continuar");
            int permanecer = entrada.nextInt();

            if(permanecer == 1){
                loop = false;
            }

        }while (loop);

        System.out.println("Finalizando exercicios_sala.Calculadora");
    }
}
