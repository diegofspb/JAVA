package br.com.rocketseat.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data // pertence a biblioteca lombok que inclui todos os geters and seters de todos os atributos abaixo sem precisar incluir explicitamente
@Entity(name = "tb_users")
public class UserModel {

    @Id    
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;

    @Column(unique = true)
    private String username;   

    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;


}
