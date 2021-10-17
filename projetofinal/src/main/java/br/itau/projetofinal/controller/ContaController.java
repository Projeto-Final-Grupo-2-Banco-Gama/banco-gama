package br.itau.projetofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.projetofinal.model.Cliente;
import br.itau.projetofinal.model.Conta;
import br.itau.projetofinal.repository.ContaRepo;
import br.itau.projetofinal.repository.ClienteRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaRepo repo;
    @Autowired
    private ClienteRepo repo1;


    @GetMapping("/{numero}")
    public ResponseEntity<Conta> buscarConta(@PathVariable long numero) {
        Conta conta = repo.findById(numero).orElse(null);

        if(conta != null) { // achou a conta
            return ResponseEntity.ok(conta); // ok = 200 = sucesso
        }
        return ResponseEntity.notFound().build(); // notFoud = 404 = conta não encontrada
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Conta>> listarTodos(){
        List<Conta> lista = (List<Conta>) repo.findAll();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> listarClientes(){
        List<Cliente> lista = (List<Cliente>) repo1.findAll();
        return ResponseEntity.ok(lista);
    }
}
