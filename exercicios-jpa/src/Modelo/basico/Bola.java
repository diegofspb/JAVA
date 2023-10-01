package Modelo.basico;

import javax.persistence.*;

@Entity
@Table(name = "bola")
public class Bola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String marca;
    String cor;

    public Bola(){

    }
    public Bola(String marca, String cor){
        this.marca = marca;
        this.cor = cor;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public String getMarca(){
        return this.marca;
    }
    public void setCor(String cor){
        this.cor = cor;
    }
    public String getCor(){
        return this.cor;
    }

}
