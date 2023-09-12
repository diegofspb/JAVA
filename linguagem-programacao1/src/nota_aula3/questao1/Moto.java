package nota_aula3.questao1;
public class Moto extends Veiculo{
    int cilindradas;
    public String imprimirDetalhes(){
        return " Moto tem " + cilindradas + " Cilindradas " +
                " Marca: " + marca +
                " Modelo: " + modelo +
                " Fabricação: " + anoFabricacao + ".";
    }
}
