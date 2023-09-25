package generics;

public class CaixaNumeroTeste {
    public static void main(String[] args) {

        // na classe CaixaNumero já foi definido que a variável será do tipo Number, isso estendeu a Classe Caixa que é 'generics' definindo que
        // agora a classe CaixaNumeroTeste limita a criação de objetos para Double, Integer, etc, pois Number é uma classe abstrata
        // pai das classes de numeros em geral

        CaixaNumero<Integer> numero = new CaixaNumero<>();
        numero.guardar(5);
        System.out.println(numero.abrir());
    }
}
