package Modelo.muitosParaMuitos.familia;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sobrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToMany(mappedBy = "sobrinhos")  // aqui ele cria uma tabela chamada 'tio_sobrinho' ja se o mappedBy estivesse na classe Tio o nome da tabela seja 'sobrinho_tio'
    private List<Tio> tios = new ArrayList<>();
    // quem mapeia a relação é o Tio, sou seja, o sobrinho é mapeado por Tio
    // na classe Tio o atributo responsável por mapear é a lista List<> de nome "sobrinhos", por isso o código fica mappedBy = "sobrinhos"
    // lembrando que em uma relação muitos para muitos Many to Many, é obrigatório a criação de uma tabela extra para salvar as duas chaves primárias das tabelas em questão
    // como quem está mapeando é Tio e quem está sendo mapeado é Sobrinho, então o nome da tabela relação será Tio_sobrinho


    public Sobrinho() {
    }

    public Sobrinho(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Tio> getTios() {
        return tios;
    }

    public void setTios(List<Tio> tios) {
        this.tios = tios;
    }
}
