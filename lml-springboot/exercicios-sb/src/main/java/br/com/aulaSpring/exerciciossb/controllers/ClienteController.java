package br.com.aulaSpring.exerciciossb.controllers;

import br.com.aulaSpring.exerciciossb.models.entities.Cliente;
import org.springframework.web.bind.annotation.*;


@RestController // define a classe como um 'controller' e corresponde a soma de @controller + @ResponseBody (json)
@RequestMapping("/clientes") // Classe mãe dos métodos abaixo, então todos terão path inicial "/clientes"
public class ClienteController {

    // tanto o @RequestMapping quanto o @GetMapping podem usar explicitamente o (path = "/clientes/qualquer")
    @GetMapping("/qualquer")
    public Cliente obterCliente(){
        return new Cliente(28, "Pedro", "152.54545.458-90");
    }

    /*
        A anotação @PathVariable serve para mapear variáveis de caminho de uma URL para parâmetros de método.
        Ela permite que você extraia valores da parte variável de uma URL e os utilize como argumentos em métodos de controlador.
    */

    // exemplo da url que usei para testar o código abaixo: http://localhost:8080/clientes/328
    // o 328 é aleatório
    @GetMapping("/{id}") // @GetMapping diz que após o a url "/clientes/{o que digitar aqui será o id}"
    public Cliente obterClientePorId1(@PathVariable int id){
        return new Cliente(id, "Maria", "546546.54545.45");
    }

    /*
        A anotação @RequestParam é usada para mapear parâmetros de consulta (query parameters) de uma solicitação HTTP
         como parte da URL após o ponto de interrogação (?) e separados por &.
         exemplo:

                http://localhost:8080/clientes?id=33
    */

    @GetMapping
    public Cliente obterClientePorId2(@RequestParam(name="id") int id){
        return new Cliente(id, "João", "23444.34344.11");
    }

}
