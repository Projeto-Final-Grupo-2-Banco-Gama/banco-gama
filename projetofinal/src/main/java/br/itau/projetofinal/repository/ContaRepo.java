package br.itau.projetofinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.itau.projetofinal.model.Conta;

public interface ContaRepo extends CrudRepository <Conta, Long> {
    
    public List<Conta> findAll();
}
