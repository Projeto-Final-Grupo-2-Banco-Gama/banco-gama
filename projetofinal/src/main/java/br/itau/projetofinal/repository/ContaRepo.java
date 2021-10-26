package br.itau.projetofinal.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import br.itau.projetofinal.model.Conta;

public interface ContaRepo extends CrudRepository <Conta, Long> {
    
    public List<Conta> findAll();
    
    public List<Conta> findAllByOrderByTipo();

    public List<Conta> findByTipo(long tipo);

    // utiliza o conceito de páginas (paginação) para retornar as informações
    public Page<Conta> findAll(Pageable pageable);
}
