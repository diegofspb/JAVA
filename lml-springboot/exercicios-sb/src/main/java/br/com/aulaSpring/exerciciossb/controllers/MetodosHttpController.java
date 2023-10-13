package br.com.aulaSpring.exerciciossb.controllers;

import org.springframework.web.bind.annotation.*;

@RestController // define a classe como um 'controller' e corresponde a soma de @controller + @ResponseBody (json)
@RequestMapping("/metodos")
public class MetodosHttpController {

    @GetMapping
    public  String get(){  // busca dados no banco de dados
        return "Requisição GET";
    }
    @PostMapping
    public  String post(){ // inclui dados no banco de dados = cria novos registros
        return "Requisição POST";
    }
    @PutMapping
    public  String put(){ // altera registros/dados existentes no banco de dados
        return "Requisição PUT";
    }
    @PatchMapping
    public  String patch(){ // altera registros/dados existentes no banco de dados
        return "Requisição PATCH";
    }
    @DeleteMapping
    public  String delete(){
        return "Requisição DELETE";
    }
}
