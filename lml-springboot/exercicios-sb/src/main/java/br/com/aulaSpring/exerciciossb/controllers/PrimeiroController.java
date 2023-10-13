package br.com.aulaSpring.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // define a classe como um 'controller' e corresponde a soma de @controller + @ResponseBody (json)
public class PrimeiroController {

    @GetMapping
    public String ola(){
        return "Ola Spring Boot";
    }
}
