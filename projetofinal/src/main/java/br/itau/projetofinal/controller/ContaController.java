package br.itau.projetofinal.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.projetofinal.model.Conta;
import br.itau.projetofinal.repository.ContaRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/Conta")
public class ContaController {

    @Autowired
    private ContaRepo repo;

    @GetMapping("/todos")
    public ResponseEntity<List<Conta>> listarTodos(){
        List<Conta> lista = (List<Conta>) repo.findAll();
        return ResponseEntity.ok(lista);
    }
}
