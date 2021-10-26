package br.itau.projetofinal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    
    ////////////////   Novas consultas desenvolvidas   //////////////////
   
    // consultar contas por tipo
    @GetMapping("/tipo/{tipo}")
    public List<ContaDTO> listarContaPorTipoDTO(@PathVariable long tipo) {
        List<Conta> listaContas = repo.findByTipo(tipo);
        List<ContaDTO> listaDTO = new ArrayList<>();

        for (Conta conta : listaContas) {
            listaDTO.add(new ContaDTO(conta));
        }
        return listaDTO;
    }

    // listar todas as contas ordenadas por tipo
    @GetMapping("/todosordenadoportipo")
    public List<ContaDTO> listarOrdenadoPorTipo() {
        List<Conta> listaContas = repo.findAllByOrderByTipo();
        List<ContaDTO> listaDTO = new ArrayList<>();

        for (Conta conta : listaContas) {
            listaDTO.add(new ContaDTO(conta));
        }
        return listaDTO;
    }
    
    // listar todas as contas em paginas
    @GetMapping("/listarempaginas")
    public Page<Conta> listarTodos(Pageable pageable) {
        Page<Conta> contas = repo.findAll(pageable);

        return contas;
    }
   
    // adicionar novo conta
    @PostMapping("/novo")
    public ResponseEntity<Conta> inserir(@RequestBody Conta conta) {
        Conta novaConta = repo.save(conta);

        return ResponseEntity.status(HttpStatus.CREATED).body(novaConta);
    }

    // atualizar dados da conta, buscar da conta pelo número    
    @PutMapping("/atualizar")
    public ResponseEntity<Conta> atualizar(@RequestBody Conta conta) {

        long numero = conta.getNumero();
        if (numero == 0) { // não mandou o número da Conta
            return ResponseEntity.badRequest().build();
        }

        Conta contaEncontrada = repo.findById(numero).orElse(null);
        if (contaEncontrada == null) { // Conta não encontrado no BD
            return ResponseEntity.badRequest().build();
        }

        Conta contaAtualizada = repo.save(conta);
        return ResponseEntity.ok(contaAtualizada);
    }

    // deletar conta pelo seu número
    @DeleteMapping("/apagar/{numero}")
    public ResponseEntity<Void> apagar(@PathVariable long numero) {

        Conta contaEncontrada = repo.findById(numero).orElse(null);
        if (contaEncontrada == null) { // Conta não encontrado no BD
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        try {
            repo.deleteById(numero);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // OK, mas sem conteúdo no corpo
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
}
