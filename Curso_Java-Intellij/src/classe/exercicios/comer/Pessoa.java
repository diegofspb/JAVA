package classe.exercicios.comer;

public class Pessoa {
    // não contém método main, contém nome da pessoa, pesoa da pessoa, método comer que recebe como parâmetro que
    // recebe um objeto da classe comida
    // quando a pessoa receber a comida vai adicionar o peso da comida no peso da pessoa
    String nome;
    double peso;
    Pessoa(String nome, double peso){
        this.nome = nome;
        this.peso = peso;
    }
    void comer(Comida comida){
        if(comida != null){
            this.peso += comida.peso;
        }
    }
    String apresentar(){
        return "Olá eu sou " + nome + " e tenho " + peso + " quilos.";
    }
}
