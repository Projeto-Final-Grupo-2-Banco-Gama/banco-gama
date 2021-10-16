package br.itau.projetofinal.dto;

import br.itau.projetofinal.model.Cliente;

public class ClienteDTO {
    private long codigo; 
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    public ClienteDTO(Cliente user) {
        this.codigo = user.getCodigo();
        this.nome = user.getNome();
        this.cpf = user.getCpf();
        this.email = user.getEmail();
        this.telefone = user.getTelefone();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

}
