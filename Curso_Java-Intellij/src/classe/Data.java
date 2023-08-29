package classe;

public class Data {

    // estas variáveis que estão fora dos métodos tem escopo global, ou seja, podem ser utilizadas em qualquer método
    // que esteja dentro desta classe, já as variáveis que estão dentro dos métodos só podem ser utilizadas dentro dos métodos
    // se você tentar acessar a variável de um método em outro método vai dar erro.
    int dia;
    int mes;
    int ano;
    // não é preciso estas variáveis globais estarem aqui, podem estar em qualquer lugar da classe, porém fora de qualquer método

    Data(){ // método construtor
        // dia = 1;
        // mes = 2;
        // ano = 1970;
        this(1,2,1970); // 'this' sendo utilizado como método, ou seja, já que aqui estamos em um método contrutor
        // o 'this' retorna que o método construtor terá 3 parâmetros que neste caso estão setados para (1,2,1970)
    }

    Data(int dia, int mes, int ano){ // tipo primitivo + parâmetro
        this.dia = dia; //this.dia se refere a variável da classe, já o 'dia' se refere a variável do método
        this.mes = mes;
        this.ano = ano;
    }

    String obterDataFormatada() {
        return String.format("%d/%d/%d",dia, mes,ano);
    }

    void imprimirDataFormatada() {
        System.out.println(this.obterDataFormatada());
    }


}
