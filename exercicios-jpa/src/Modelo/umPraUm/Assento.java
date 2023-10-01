package Modelo.umPraUm;

import javax.persistence.*;

@Entity
@Table(name = "assentos")
public class Assento {
    private String nome;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "assento") // aqui informa que a relação 1 para 1 está mapeada pela Classe cliente com nome "assento"
    private Cliente cliente;

    public Assento(){}

    public Assento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // lembrando que cliente é OneToOne, então estes métodos abaixo permitem acessar os dados de cliente apartir desta classe aqui (ASSENTO)
    // isso corre do mesmo jeito na classe Cliente
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
