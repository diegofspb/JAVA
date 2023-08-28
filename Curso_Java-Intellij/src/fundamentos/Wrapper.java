package fundamentos;

public class Wrapper {
    public static void main(String[] args) {

        /*
         * Wrapper é a versão objeto dos tipos primitivos;
         * tudo é objeto em Java com exceção dos tipos primitivos;
         * Wrapper = aquilo que envolve = permite que um tipo primitivo se transforme em uma classe;
         * Wrapper é utilizar um tipo primitivo iniciando com letra MAÚSCULA;
         *
         * todos os tipos primitivos abaixo iniciam com Maiúscula, pois assim
         * o JAVA entente que esses tipos primitivos se forem iniciados com letra minuscula
         * serão só valores de tipos primitivos, porém se iniciarem com letra maiuscula = classe;
         * */

        Byte b = 100;  //byte
        Short s = 1000; //short
        Integer i = 10000;  //int
        Long l = 1000000L; //long
        Float f = 1000F; //float, lembre que java identifica primeiro o tipo do valor atribuido,
        // que neste caso é um inteiro de valor 1000, depois ele joga no tipo primitivo,
        // neste caso o inteiro 1000 precisa ser transformado em float para entrar no wrapper Float
        // e para isso basta usar o F no final do valor;
        Double d = 123.4555; // não precisou usar o D no final como exemplo anterior;

        System.out.println(b.byteValue());
        System.out.println(s.toString());
        System.out.println(i * 3);
        System.out.println(l / 3);

        Boolean bo = Boolean.parseBoolean("true");
        System.out.println(bo);


    }
}
