package lista;

public class Pessoa {

    private String nome;

    // ao criar este método, toda vez que você tentar imprimir um objeto criado a partir desta classe, ele vai executar
    // o toString automaticamente sem precisar você digitar o texto abaixo outras vezes
    public String toString(){
        return "Meu nome é: " + this.nome + ".";
    }
    Pessoa(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
}
