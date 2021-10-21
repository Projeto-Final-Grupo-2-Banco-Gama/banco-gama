package br.itau.projetofinal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.projetofinal.dto.ContaDTO;
import br.itau.projetofinal.model.Conta;
import br.itau.projetofinal.repository.ContaRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaRepo repo;
    
    // consultar a Conta pelo id (número da conta)
    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarConta(@PathVariable long id) {
        Conta conta = repo.findById(id).orElse(null);

        if(conta != null) { // achou a conta
            return ResponseEntity.ok(conta); // ok = 200 = sucesso
        }
        return ResponseEntity.notFound().build(); // notFoud = 404 = conta não encontrada
    }
        
    // listar todas as contas  
    @GetMapping
    public List<ContaDTO> listarContas() {
        List<Conta> listaContas = repo.findAll();
        List<ContaDTO> listaDTO = new ArrayList<>();

        for (Conta conta : listaContas) {
            listaDTO.add(new ContaDTO(conta));
        }
        return listaDTO;
    }

    // listar todas as contas e os clientes de cada conta
    @GetMapping("/todos")
    public ResponseEntity<List<Conta>> listarContasEclientesDaConta(){
        List<Conta> lista = (List<Conta>) repo.findAll();
        return ResponseEntity.ok(lista);
    }
}
