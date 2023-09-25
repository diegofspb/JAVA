package generics;

public class CaixaObjetoTeste {
    public static void main(String[] args) {
        CaixaObjeto caixa1 = new CaixaObjeto();
        caixa1.guardar(2.3);
        // foi obrigatório o uso de casting (Double), pois o método abrir() retorna um objeto do tipo 'object' e abaixo temos a variável 'coisa' que é do tipo Double
        // então a operação de casting (ou conversão explícita), o que é retornado do método abrir(), que é um objeto do tipo 'object', é transformado em objeto do tipo Double
        Double coisa1 = (Double) caixa1.abrir();
        System.out.println(coisa1);

        CaixaObjeto caixa2 = new CaixaObjeto();
        caixa2.guardar("uma string qualquer");
        // foi obrigatório o uso de casting (String), pois o método abrir() retorna um objeto tipo 'object' e abaixo temos a variável 'coisa' que é do tipo String
        // então a operação de casting (ou conversão explícita), o que é retornado do método abrir(), que é um objeto do tipo 'object', é transformado em objeto do tipo Double
        String coisa2 = (String) caixa2.abrir();
        System.out.println(coisa2);

    }
}
