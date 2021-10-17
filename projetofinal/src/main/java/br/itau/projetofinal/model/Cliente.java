package br.itau.projetofinal.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private long codigo;

    @Column(name = "nome", length = 200, nullable = false) 
    private String nome;

    @Column(name = "cpf", length = 200, nullable = false, unique = true) 
    private String cpf;

    @Column(name = "telefone", length = 200)
    private String telefone;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "titular")
    @JsonIgnoreProperties("titular")
    private List<Conta> clientes;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Conta> getClientes() {
        return clientes;
    }

    public void setClientes(List<Conta> clientes) {
        this.clientes = clientes;
    }

    

}
