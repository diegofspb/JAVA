package fundamentos;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args){

        System.out.println("###### Calculadora ######");

        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o primeiro número");
        double numero1 = entrada.nextDouble();
        System.out.println("Informe o segundo número");
        double numero2 = entrada.nextDouble();
        System.out.println("Informe a operação: +-/*");
        String operacao = entrada.next();

        double resultado = "+".equals(operacao) ? numero1 + numero2 : 0;
        resultado = "-".equals(operacao) ? numero1 - numero2 : resultado;
        resultado = "/".equals(operacao) ? numero1 / numero2 : resultado;
        resultado = "*".equals(operacao) ? numero1 * numero2 : resultado;

        System.out.printf("%.2f %s %.2f = %.2f", numero1, operacao, numero2, resultado);
        entrada.close();
    }
}
