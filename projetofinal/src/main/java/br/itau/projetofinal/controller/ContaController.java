package br.itau.projetofinal.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class ContaController {

    @GetMapping("/todos")
    public ResponseEntity<List<Conta>> listarTodos(){
        List<Conta> lista = (List<Conta>) repo.findAll();
        return ResponseEntity.ok(lista);
    }
}
