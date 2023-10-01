package Modelo.umPraUm;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
    private String nome;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // agora a classe Assento que referencia a tabela 'assentos' se tornou uma relação 1 para 1, aqui corresponde ao FK de 'assentos'
    @OneToOne (cascade = CascadeType.PERSIST) // significa que quando for persistir(salvar) está classe no banco de dados, ele vai em cascada procurando dependecias e fazer PERSIST
    // FOI realizado exemplo de incluir apenas Cliente sem incluir assento e deu erro, porém depois de incluir o 'Cascade' funcionou
    @JoinColumn(name = "assento_id", unique = true) //se não colocar nada em 'name' ele pega o nome do atributo e soma com '_id'.
    // é obrigatorio usar o 'unique' aqui, porque a relação é 1 para 1, OneToOne, ou seja, 1 cliente só senta em 1 cadeira e 1 cadeira só pode ter 1 cliente
    // se não usar o 'unique = true' então esta chave estrangeira poderá se repetir causando inconsistencia no banco de dados
    private Assento assento;

    public Cliente(){}

    public Cliente(String nome, Assento assento) {
        this.nome = nome;
        this.assento = assento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // lembrando que Assento é OneToOne, então estes métodos abaixo permitem acessar os dados de Assento apartir desta classe aqui (Cliente)
    // isso corre do mesmo jeito na classe Assento
    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }
}
