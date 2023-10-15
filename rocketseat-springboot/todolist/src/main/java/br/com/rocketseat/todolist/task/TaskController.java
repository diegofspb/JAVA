package br.com.rocketseat.todolist.task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rocketseat.todolist.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    // este método cria uma tarefa  
    @PostMapping("/")
    public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request){
        
        var idUser = request.getAttribute("idUser");
        taskModel.setIdUser((UUID) idUser);           

        // validando valores de entrada de data para evitar que uma tarefa seja inserida com data passada, ou seja, cadastrar tarefa vencida

        var currentDate = LocalDateTime.now(); // pega data atual

        if (currentDate.isAfter(taskModel.getStartAt()) || currentDate.isAfter(taskModel.getEndAt())) { // se a data atual for maior que a data de início da tarefa
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: A data de início ou término deve ser superior a data atual");
        }
                
        if (taskModel.getStartAt().isAfter(taskModel.getEndAt())) { // se a data de início for menor que a data do término
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: A data de início deve ser menor que a data do término");
        }           

        // salvando a tarefa
        var task = this.taskRepository.save(taskModel);

        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @GetMapping("/")
    public List<TaskModel> list(HttpServletRequest request){
        var idUser = request.getAttribute("idUser");
        var tasks = this.taskRepository.findByIdUser((UUID) idUser);
        return tasks;
    }

    @PutMapping("/{id}") // este id sejá lançado no @PathVariable UUID id
    public ResponseEntity update(@RequestBody TaskModel taskModel, HttpServletRequest request, @PathVariable UUID id){
       
        // faz pesquisa para saber quais taferas pertencem a este usuário logado
        var task = this.taskRepository.findById(id).orElse(null);
        // verifica se a tarefa existe
        if(task == null){
             return ResponseEntity.status((HttpStatus.BAD_REQUEST)).body("Tarefa não encontrada");
        }
        // apenas identifica o usuário logado através da ID
        var idUser = request.getAttribute("idUser");
        // caso o usuário logado não seja o o dono/criador da task(tarefa) então ele não poderá alterar a tarefa
        if(!task.getIdUser().equals(idUser)){
            return ResponseEntity.status((HttpStatus.BAD_REQUEST)).body("Usuário não tem permissão para alterar essa tarefa");
        }

        Utils.copyNonNullProperties(taskModel, task); // Utils foi uma classe criada por nós para ser utilizada sem precisar instanciar 'static'
        
        var taskUpdated = this.taskRepository.save(task);
  
        return ResponseEntity.ok().body(taskUpdated);

    }
    
}
