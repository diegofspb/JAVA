package br.com.aulaSpring.exerciciossb.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data // =  @Getter, @Setter, @EqualsAndHashCode e @ToString.
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "produtos") // este name é o nome da entidade que será usado neste código
@Table(name = "produtos") // este name é efetivamente o nome da tabela no banco de dados
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // é um tipo de validação. Diz que a coluna 'nome' não pode estar em vazia
    @NotBlank(message = "O campo 'nome' não deve estar em branco")
    private String nome;
    @Min(0) // é um tipo de validação. Diz que o preço mínimo é 0, ou seja, não aceita valor negativo
    private double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
