package classe;

public class DataTeste {

    public static void main(String[] args) {
        //exemplo 1:
        Data d1 = new Data(); //existem 2 métodos construtores, este não recebe parâmetro, pois já tem 'this(1,2,1970)' preenchendo automaticamente
        d1.ano = 2021;

        //exemplo 2:
        var d2 = new Data(31,12,2020);	// esse é o outro método construtor que possui parâmetros

        String dataFormatada1 = d1.obterDataFormatada()	;

        System.out.println(dataFormatada1);
        System.out.println(d2.obterDataFormatada());

        d2.imprimirDataFormatada();
        d1.imprimirDataFormatada();
    }
}
