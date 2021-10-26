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

import br.itau.projetofinal.dto.ClienteDTO;
import br.itau.projetofinal.model.Cliente;
import br.itau.projetofinal.repository.ClienteRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepo repo;

    @GetMapping("/todos")
    public List<Cliente> listarTodos() {
        List<Cliente> lista = (List<Cliente>) repo.findAll();
        return lista;
    }

    
    ////////////////   Novas consultas desenvolvidas   //////////////////
       
       // listar todos os clientes ordenados por nome utilizando DTO
    @GetMapping("/todosordenadopornome")
    public List<ClienteDTO> listarPorNome() {
        List<Cliente> listaClientes = repo.findAllByOrderByNome();
        List<ClienteDTO> listaDTO = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
            listaDTO.add(new ClienteDTO(cliente));
        }
        return listaDTO;
    }

    // consultar cliente pelo código
    @GetMapping("/{codigo}")
    public ResponseEntity<Cliente> buscarConta(@PathVariable long codigo) {
        Cliente cliente = repo.findById(codigo).orElse(null);

        if(cliente != null) { // achou o cliente
            return ResponseEntity.ok(cliente); // ok = 200 = sucesso
        }
        return ResponseEntity.notFound().build(); // notFoud = 404 = conta não encontrada
    }

    // consultar cliente por nome
    @PostMapping("/nome")
    public ResponseEntity<ClienteDTO> buscaPorNome(@RequestBody Cliente cliente) {
        Cliente clienteEncontrado = repo.findByNome(cliente.getNome());

        if (clienteEncontrado != null) {
            ClienteDTO clienteDTO = new ClienteDTO(clienteEncontrado);
            return ResponseEntity.ok(clienteDTO);
        }
        return ResponseEntity.notFound().build();
    }

    // consultar todas as contas do cliente pelo nome do cliente
    @PostMapping("/contasdocliente")
    public List<Cliente> buscaPorNomeTodasAsContas(@RequestBody Cliente cliente) {
        List<Cliente> listaClientes = (List<Cliente>) repo.findAllByNome(cliente.getNome());       

        return listaClientes;
    }

    // listar todos os clientes em paginas
    @GetMapping("/listarempaginas")
    public Page<Cliente> listarTodos(Pageable pageable) {
        Page<Cliente> clientes = repo.findAll(pageable);

        return clientes;
    }
    
    // adicionar novo cliente
    @PostMapping("/novo")
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
        Cliente novoCliente = repo.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    // atualizar dados do cliente, busca do cliente pelo seu código
    @PutMapping("/atualizar")
    public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente) {

        long id = cliente.getCodigo();
        if (id == 0) { // não mandou o código do Cliente
            return ResponseEntity.badRequest().build();
        }

        Cliente clienteEncontrado = repo.findById(id).orElse(null);
        if (clienteEncontrado == null) { // Cliente não encontrado no BD
            return ResponseEntity.badRequest().build();
        }

        Cliente clienteAtualizado = repo.save(cliente);
        return ResponseEntity.ok(clienteAtualizado);

    }

    // deletar cliente pelo seu código
    @DeleteMapping("/apagar/{codigo}")
    public ResponseEntity<Void> apagar(@PathVariable long codigo) {

        Cliente clienteEncontrado = repo.findById(codigo).orElse(null);
        if (clienteEncontrado == null) { // Cliente não encontrado no BD
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        try {
            repo.deleteById(codigo);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // OK, mas sem conteúdo no corpo
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }    
}