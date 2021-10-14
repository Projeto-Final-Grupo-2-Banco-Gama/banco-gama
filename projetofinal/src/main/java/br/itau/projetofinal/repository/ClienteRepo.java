package br.itau.projetofinal.repository;

import org.springframework.data.repository.CrudRepository;

import br.itau.projetofinal.model.Cliente;

public interface ClienteRepo extends CrudRepository<Cliente, Long>{
    
}
