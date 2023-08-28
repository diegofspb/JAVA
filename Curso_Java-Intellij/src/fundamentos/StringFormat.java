package fundamentos;

public class StringFormat {
    public static void main(String[] args) {

        var nome = "Pedro";
        var sobrenome = "Santos";
        var idade = 33;
        var salario = 151245.55;

        /*
         * agora vamos trocar o println pelo printf
         * o printf é igual ao format strings do python, porém utiliza:
         * %s para string
         * %d para inteiro
         * %f para float
         * */

        System.out.printf("O senhor %s %s tem %d e ganha R$ %f", nome, sobrenome, idade, salario);
        // agora apenas limitando o tamanho do salário para 2 casas após o ponto:
        System.out.printf("\nO senhor %s %s tem %d e ganha R$ %.2f", nome, sobrenome, idade, salario);
        // agora utilizando o String.format antes do system.out para poder utilizar o o println normal:

        String frase = String.format("\nO senhor %s %s tem %d e ganha R$ %.2f", nome, sobrenome, idade, salario);
        System.out.println(frase);

    }
}
