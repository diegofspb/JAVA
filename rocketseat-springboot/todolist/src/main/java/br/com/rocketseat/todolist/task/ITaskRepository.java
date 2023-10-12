package br.com.rocketseat.todolist.task;

import java.util.List;
import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID>{

    //criar um filtro para trazer apenas as tarefas do usário que estiver logado
    List<TaskModel> findByIdUser(UUID idUser);
    
}
