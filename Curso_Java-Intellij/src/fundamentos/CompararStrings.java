package fundamentos;

import java.util.Scanner;

public class CompararStrings {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Teste para comprar Strings, informe uma palavra");
        String palavra1 = entrada.next();

        System.out.println("Informe outra palavra para verificar se são idênticas");
        String palavra2 = entrada.next();

        if (palavra1.equals(palavra2)){
            System.out.println("As lavaras 1 e 2 são iguais");
        }else{
            System.out.println("As lavaras 1 e 2 são diferentes");
        }
        entrada.close();
    }
}
