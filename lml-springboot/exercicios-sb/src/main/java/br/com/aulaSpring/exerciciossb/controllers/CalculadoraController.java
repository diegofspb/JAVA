package br.com.aulaSpring.exerciciossb.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    // para executar usei a url http://http://localhost:8080/calculadora/somar/2/3
    @GetMapping("/somar/{a}/{b}")
    public int somar(@PathVariable int a, @PathVariable int b){
        return a + b;
    }
    // para executar usei a url http://localhost:8080/calculadora/subtrair?b=100&a=130
    @GetMapping("/subtrair")
    public int subtrair(@RequestParam(name="a") int numero1, @RequestParam(name="b") int numero2){
        return numero1 - numero2;
    }
}
