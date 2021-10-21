package br.itau.projetofinal.dto;

import br.itau.projetofinal.model.Conta;

public class ContaDTO {
    private long numero;
    private long agencia;
    private long tipo;
    private double saldo;

    public ContaDTO(Conta conta) {
        this.numero = conta.getNumero();
        this.agencia = conta.getAgencia();
        this.tipo = conta.getTipo();
        this.saldo = conta.getSaldo();
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
