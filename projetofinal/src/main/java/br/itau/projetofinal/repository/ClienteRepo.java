package br.itau.projetofinal.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import br.itau.projetofinal.model.Cliente;

public interface ClienteRepo extends CrudRepository<Cliente, Long>{
    
    public List<Cliente> findAll();

    public Cliente findByNome(String nome);

    public List<Cliente> findAllByNome(String nome);

    public List<Cliente> findAllByOrderByNome();

    // utiliza o conceito de páginas (paginação) para retornar as informações
    public Page<Cliente> findAll(Pageable pageable);
}
