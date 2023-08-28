package fundamentos;

public class ConverterNumeroString {

    public static void main(String[] args) {
        Integer numero = 100;
        System.out.println("O numero " + numero + " é do tipo Inteiro");

        System.out.println("Agora o " + numero.toString() + " é do tipo String");

        System.out.println("Para provar vamos utilizar a função length() que só conta quantidade de caracteres de string \n");

        System.out.println(numero.toString().length());

    }
}

/*
Em Java, um "wrapper" (ou invólucro) refere-se a uma classe que é usada para encapsular (envolver) tipos primitivos em um objeto.
Os tipos primitivos em Java (como int, char, boolean, etc.) não são objetos e não herdam funcionalidades de objetos,
que significa que eles não podem ser usados em algumas situações onde objetos são esperados.
Os wrappers são classes que fornecem uma representação de objeto para esses tipos primitivos, permitindo
que eles sejam tratados como objetos.

Existem oito classes wrapper no Java, uma para cada tipo primitivo:

Integer (int)
Long (long)
Short (short)
Byte (byte)
Character (char)
Float (float)
Double (double)
Boolean (boolean)
*
* */
