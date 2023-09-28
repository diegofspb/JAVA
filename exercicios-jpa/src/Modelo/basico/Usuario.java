package Modelo.basico;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue //cria automaticamente o próximo ID
    private Long id;
    private String nome;
    private String email;

    public Usuario() {
        /*
            Construtor padrão vazio
            O Hibernate precisa de um construtor sem argumentos para criar instâncias da classe ao recuperar dados do banco de dados.
            se não tiver este construtor vazio, não funciona
         */
    }


    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
