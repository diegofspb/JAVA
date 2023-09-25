package generics;

import java.util.Arrays;
import java.util.List;

public class ListaTeste {

    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("Maria", "João");
        String exibir = Lista.getUltimo(nomes);
        System.out.println(exibir);

        List<Integer> numeros = Arrays.asList(5,6,8);
        int ultimoNumero = Lista.getUltimo(numeros);
        System.out.println(ultimoNumero);
    }
}
