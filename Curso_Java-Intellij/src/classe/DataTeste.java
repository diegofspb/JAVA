package classe;

public class DataTeste {

    public static void main(String[] args) {
        //exemplo 1:
        Data d1 = new Data();
        d1.ano = 2021;

        //exemplo 2:
        var d2 = new Data(31,12,2020);	// Data possui um método construtor manipulado por um 'this';

        String dataFormatada1 = d1.obterDataFormatada()	;

        System.out.println(dataFormatada1);
        System.out.println(d2.obterDataFormatada());

        d1.imprimirDataFormatada();
        d2.imprimirDataFormatada();
    }
}
