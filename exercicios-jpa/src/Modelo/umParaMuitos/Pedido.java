package Modelo.umParaMuitos;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    @OneToMany(mappedBy = "pedido") // aqui informa o nome do atributo que está na classe ItemPedido que vai mapear esta lista de 'itens'
    private List<ItemPedido> itens;

    public Pedido(){ //hibernate exige um construtor 'sem argumentos', porém é possível fazer algo dentro dele
        this(new Date());
    }

    public Pedido(Date data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}
