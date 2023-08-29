package classe;
// esta classe não possui método main, pois ela será utilizada em outra classe que é a AreaCircTeste
public class AreaCirc {
    /*
     * A palavra-chave 'final' é usada para declarar uma constante, ou seja, uma variável cujo valor não pode ser alterado
     * após a sua atribuição inicial. Quando uma variável é declarada como final, não é possível atribuir um novo valor a
     * ela posteriormente. A declaração final é usada para indicar que o valor de uma variável não deve ser alterado
     * ao longo do programa.
     *
     * A palavra-chave 'static' é usada para declarar uma variável como sendo compartilhada entre todas as instâncias
     * de uma classe. Uma variável estática pertence à classe em si, e não a uma instância específica da classe.
     * Ela é inicializada apenas uma vez, quando a classe é carregada, e todas as instâncias da classe compartilham o
     * mesmo valor dessa variável, significa que, se o valor desta variável for alterada em uma instância,
     * todas as outras instâncias terão acesso ao novo valor.
     * */

    double raio;
    final static double PI = 3.14; // 'pi' foi alterado para 'PI' por ter se tornado uma constante

    AreaCirc(double raioInicial) { // método construtor
        raio = raioInicial;
    }

    double area() {
        return PI * Math.pow(raio, 2);
        //Math.pow serve para elevar o número, neste caso é raio elevado ao quadrado;
    }
}
