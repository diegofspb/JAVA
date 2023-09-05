package classe;

public class Data {

    // estas variáveis que estão fora dos métodos tem escopo global, ou seja, podem ser utilizadas em qualquer método
    // que esteja dentro desta classe, já as variáveis que estão dentro dos métodos só podem ser utilizadas dentro dos métodos
    // se você tentar acessar a variável de um método em outro método vai dar erro.
    int dia;
    int mes;
    int ano;
    // não é preciso estas variáveis globais estarem aqui, podem estar em qualquer lugar da classe, porém fora de qualquer método

    Data(){ // método construtor vazio, lembrando que o método construtor pode ter mais de um
        // dia = 1;
        // mes = 2;
        // ano = 1970;
        this(1,2,1970); // 'this()' é uma função que chama um método contrutor já existente, neste caso está abaixo
        // note que o this() está com 3 parâmetros, exatamente no formato do método construtor abaixo
        // neste exemplo o this() chama o metodo construtor abaixo já setando os valores dos parametros
    }

    Data(int dia, int mes, int ano){ // outro método construtor, porém não pode ter a mesma assinatura (nome + parametros iguais)
        this.dia = dia; //this.dia se refere a variável da classe(atributo), já o 'dia;' se refere a variável do método (parâmetro dia)
        this.mes = mes;
        this.ano = ano;
        // this(1,2,1970); se deixar isso ele dá erro, pois lá em cima o this() já chama este método,
        // então ficaria em loop, pois este método chama o de cima e o de cima chama o de baixo.
    }

    String obterDataFormatada() {
        return String.format("%d/%d/%d",dia, mes,ano);
    }

    void imprimirDataFormatada() {
        System.out.println(this.obterDataFormatada());
    }
}
