package fundamentos;


import java.util.Scanner;

public class Printf {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe seu nome");
        String nome = entrada.next();

        System.out.println("Informe sua idade");
        Integer idade = entrada.nextInt();

        System.out.printf("seu nome é %s e sua idade é %d", nome, idade);

    }
}

/*
%d: Inteiro decimal.
%f: Ponto flutuante (números decimais).
%c: Caractere.
%s: String.
%b: Booleano.
%x ou %X: Inteiro hexadecimal (minúsculas ou maiúsculas).
%o: Inteiro octal.
%e ou %E: Notação científica (minúsculas ou maiúsculas).
%n: Nova linha de plataforma independente.
%t: Data e hora (usado com conversões específicas, como %tH para hora em formato de 24 horas).
%%: Para imprimir um sinal de porcentagem literal ("%").
* */