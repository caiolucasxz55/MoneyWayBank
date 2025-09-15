package com.fiap.MoneyWayBank.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/home")
@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<String> home() {
        String response = """
            Projeto: Projeto Bank
            Integrantes: 
            - Caio Lucas Silva Gomes (RM560077)
            - João Gabriel Fuchs Grecco (RM67890) //Muda teu RM ai
            """;
        return ResponseEntity.ok(response);
    }
}
