package Modelo.muitosParaMuitos.filme;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "filmes")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double nota;
    @ManyToMany(cascade = CascadeType.PERSIST) // quando salvar o filme, já que está é a classe Filme, então em cascata ele salvará também os atores
    @JoinTable( // no método @JoinTable é possível setar: (nome da tabela de junção + nome das colunas + o que será adicionado em cada coluna)
            name = "atores_filmes",  // aqui é possível personalizar o nome da tabela auxiliar (tabela de junção)
            joinColumns = @JoinColumn(name = "filme_id", referencedColumnName = "id"), //nome da coluna 'mapeadora' + 'id' desta classe que é a referenciada / quem mapeia
            inverseJoinColumns = @JoinColumn(name = "ator_id", referencedColumnName = "id") // nome da coluna que será mapeada + o dado adicionado que será o 'id' dela
    )
    private List<Ator> atores = new ArrayList<>();

    public Filme() {
    }

    public Filme(String nome, Double nota) {
        this.nome = nome;
        this.nota = nota;
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

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public void adicionarAtor(Ator ator){ // considerando que ao chamar este método você é obrigado a informar o nome do 'ator'
        if (ator != null && !getAtores().contains(ator)){ // aqui verifica se na lista de atores 'List<Ator> atores' está vazia e trás resposta boleana
            getAtores().add(ator); // getAtores() é um método desta classe 'Filmes' e retorna uma lista de atores: 'List<Ator> ator;' aqui ele adiciona 1 ator '.add(ator)'
            if (!ator.getFilmes().contains(this)) {
                ator.getFilmes().add(this); // 'getFilmes()' é um método da classe 'Ator', por isso é obrigatório usar o objeto 'ator' ates do método ficando: 'ator.getFilmes()'
            // note que estamos na classe 'Filme', então você só pode chamar este método 'adicionarAtor(Ator ator)', depois que instanciar/criar/adicionar um 'filme' e um 'ator'
            // por isso que agora é possível usar 'this', pois 'ator.getFilmes()' é executado na clase Ator e retorna uma lista de filmes: 'List<Filme> filmes'
            // e para adicionar um filme na lista de filmes bastou usar '.add(this)', adicionando este filme 'this' este que está intanciado para ser adicionado
            // '.add(this)' adiciona 'isto', ou seja, adiciona o objeto atual, que é um filme, a lista de filmes
    }
        }
    }
}
