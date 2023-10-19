package br.com.aulaSpring.exerciciossb.models.entities;

import lombok.Data;

@Data // pertence a biblioteca lombok que inclui todos os geters and seters de todos os atributos abaixo sem precisar incluir explicitamente
// para utilizar a biblioteca lombok pesquisa no google e copia e cola a dependencia para o maven no arquivo pom.xml
public class Cliente {

    private int id;
    private String nome;
    private String cpf;

    public Cliente(int id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
