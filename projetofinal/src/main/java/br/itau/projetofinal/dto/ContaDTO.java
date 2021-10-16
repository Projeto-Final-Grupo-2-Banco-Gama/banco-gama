package br.itau.projetofinal.dto;

import br.itau.projetofinal.model.Cliente;
import br.itau.projetofinal.model.Conta;

public class ContaDTO {
    private long numero;
    private long agencia;
    private long tipo;
    private Cliente titular;
    private double saldo;


    public ContaDTO(Conta user) {
        this.numero = user.getNumero();
        this.agencia = user.getAgencia();
        this.tipo = user.getTipo();
        this.titular = user.getTitular();
        this.saldo = user.getSaldo();
    }


    public long getNumero() {
        return numero;
    }


    public void setNumero(long numero) {
        this.numero = numero;
    }


    public long getAgencia() {
        return agencia;
    }


    public void setAgencia(long agencia) {
        this.agencia = agencia;
    }


    public long getTipo() {
        return tipo;
    }


    public void setTipo(long tipo) {
        this.tipo = tipo;
    }


    public Cliente getTitular() {
        return titular;
    }


    public void setTitular(Cliente titular) {
        this.titular = titular;
    }


    public double getSaldo() {
        return saldo;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
