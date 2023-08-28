package fundamentos;

public class StringManipular {
    public static void main(String[] args) {

        // .charAt(0) serve para informar o que tem na posição 0, ou seja, o index:
        System.out.println("Olá pessoal!".charAt(0));

        String s = "Boa tarde";

        // .concat() serve para concatenar a string, ou seja, adicionar algo:
        System.out.println(s.concat("!!!!!"));
        // .statsWith()  serve para verificar se a string começa com ... e retorna booleano:
        System.out.println(s.startsWith("Boa"));
        // para evitar que a palavra inicie com letra maiuscula e isso atrapalhe, então deve ficar assim:
        System.out.println(s.toLowerCase().startsWith("boa"));
        // .endsWith() o contrário da anterior, ou seja, se a string termina com ....
        System.out.println(s.toUpperCase().endsWith("TARDE"));
        // .length() assim como em toda linguagem = contar o tamanho:
        System.out.println(s.length());
        // .equals() serve para saber se a string é a mesma coisa que ...:
        System.out.println(s.toLowerCase().equals("boa tarde"));
    }
}

