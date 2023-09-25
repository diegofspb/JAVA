package generics;

import java.util.List;

public class Lista {

    public static <E> E getUltimo(List<E> lista){
        return  lista.get(lista.size() - 1);
    }
}
