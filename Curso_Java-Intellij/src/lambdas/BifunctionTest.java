package lambdas;

import java.util.function.BiFunction;

public class BifunctionTest {
    public static void main(String[] args) {
        // aceita 3 parâmetros diferentes, 2 de entrada e 1 de saída, todos podendo ser diferentes
        BiFunction<Double, Double, String> aprovado = (n1,n2) -> {
            double media = (n1+n2)/2;
            return media >= 5 ? "Aprovado":"Reprovado";
        };
        System.out.println(aprovado.apply(5.5,6.6));


    }
}
