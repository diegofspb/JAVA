package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ExercicioOperadorBinario {
    public static void main(String[] args) {

        List<Integer> lista1 = Arrays.asList(1,2,3);
        List<Integer> lista2 = Arrays.asList(4,5,6);
        List<Integer> somaListas = new ArrayList<>();
        BinaryOperator<Integer> soma = (x,y) -> x+y;

        for(int i = 0; i < lista1.size(); i++){
            somaListas.add(soma.apply(lista1.get(i), lista2.get(i)));
            System.out.println(lista1.get(i) + " + " + lista2.get(i) + " = " + somaListas.get(i));
        }

        System.out.println("Nova lista formada com a soma das listas 1 e 2 = " + somaListas);
    }

}
