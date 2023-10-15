package br.com.rocketseat.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data // pertence a biblioteca lombok que inclui todos os geters and seters de todos os atributos abaixo sem precisar incluir explicitamente
@Entity(name = "tb_tasks")
public class TaskModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id; // id da tarefa
    private String description; // descrição da tarefa
    @Column(length = 50)
    private String title; // titulo da tarefa
    private LocalDateTime startAt; //horário que inicia a tarefa
    private LocalDateTime endAt; //horário que finaliza a tarefa
    private String priority;

    private UUID idUser;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public void setTitle(String title) throws Exception{
        if (title.length() > 50) {
            throw new Exception(" O campo title deve contar no máximo 50 caracteres")
        }
        this.title = title;
    }
    
    

}
