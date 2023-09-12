package nota_aula3.questao1;
public class Carro extends Veiculo {
    int numPortas;
    public String imprimirDetalhes(){
        return "Carro tem " + numPortas + " portas " +
                " Marca: " + marca +
                " Modelo: " + modelo +
                " Fabricação: " + anoFabricacao + ".";
    }
}
