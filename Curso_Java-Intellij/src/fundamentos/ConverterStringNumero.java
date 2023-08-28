package fundamentos;

import javax.swing.*;

public class ConverterStringNumero {

    public static void main(String[] args) {
        String valor1 = JOptionPane.showInputDialog("Digite o primeiro número: ");
        String valor2 = JOptionPane.showInputDialog("Digite o segundo número: ");

        System.out.println(valor1 + valor2); //até aqui serve para mostrar que os numeros acima são na verdade strings

        double numero1 = Double.parseDouble(valor1);
        double numero2 = Double.parseDouble(valor2);

        System.out.println(numero1);
        System.out.println(numero2);

        double soma = numero2 + numero1;

        System.out.printf("A soma entre os dois numeros é %.2f", soma);
    }
}
