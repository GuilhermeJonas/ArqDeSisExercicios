package com.usjt.guilherme.caixaeletronico.caixaeletronico.model;

/**
 * Created by jonas_000 on 06/11/2016.
 */
public class Saque {
    private int tipoMovimento;
    private double valor;
   private int numConta;
    private int numAgencia;
    private int numBanco;
    private String data;

    public Saque(int tipoMovimento, double valor, int numConta, int numAgencia, int numBanco, String data) {
        super();
        this.tipoMovimento = tipoMovimento;
        this.valor = valor;
        this.numConta = numConta;
        this.numAgencia = numAgencia;
        this.numBanco = numBanco;
        this.data = data;
    }

    public int getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(int tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public int getNumAgencia() {
        return numAgencia;
    }

    public void setNumAgencia(int numAgencia) {
        this.numAgencia = numAgencia;
    }

    public int getNumBanco() {
        return numBanco;
    }

    public void setNumBanco(int numBanco) {
        this.numBanco = numBanco;
    }
}