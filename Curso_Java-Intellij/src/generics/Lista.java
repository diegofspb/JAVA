package generics;

import java.util.List;

public class Lista {

    public static <E> E getUltimo(List<E> lista){ // método é 'static' para poder ser utilizado em outra classe sem precisar instanciar = uso direto, ex: Lista.getUltimo()
        return  lista.get(lista.size() - 1);
    }
    /*
        Explicando o uso dos três `<E>` no método `getUltimo`:

            1. Primeiro `<E>`:  é a declaração do tipo do método.

            2. Segundo `<E>` é a declaração do método em si

            3. Terceiro `<E>` List<E>: é a declaração do tipo genérico do argumento `lista` que o método `getUltimo` aceita.
            Isso significa que o método espera uma lista de elementos do tipo genérico `E`.

            ####obs.: aqui é interpretado ao contrário, quando se utiliza o método fica assim:
                1 - inicia com o uso do parâmetro 'List<E>', se for uma lista de inteiros, fica assim: 'List<Int>'
                2 - o primeiro <E> agora recebe o tipo da lista List<int>, ficando '<Int> E getUltimo(List<Int> lista)'
                3 - para finalizar o segundo 'E' recebe a declaração do tipo do método <E> ficando:
                        '<Int> Int getUltimo(List<Int> lista)'

            Portanto, o método `getUltimo` aceita uma lista de elementos do tipo genérico `E` como argumento (o terceiro `<E>`) e
            retorna um elemento do mesmo tipo genérico `E` (o primeiro `<E>`).
            O segundo `<E>` no nome do método é apenas uma convenção de nomenclatura para indicar que o método é genérico.
            O importante é o primeiro `<E>` antes do tipo de retorno e o terceiro `<E>` na declaração dos argumentos do método.
     */
}
