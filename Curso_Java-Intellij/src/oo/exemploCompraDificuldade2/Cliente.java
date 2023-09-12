package oo.exemploCompraDificuldade2;
import java.util.ArrayList;
public class Cliente {
    String nome;
    ArrayList<Compra> compras = new ArrayList<>();
    public double obterValorTotal(){
        double total = 0;
        for(Compra compra: compras){
            total += compra.obterValorTotal();
        }
        return total;
    }


}
