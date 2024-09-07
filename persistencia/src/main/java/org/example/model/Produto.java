package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Produto {

    @JsonProperty("codigo")
    private int codigo;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("unidade")
    private int unidade;
    @JsonProperty("valorUnitario")
    private double valorUnitario;
    @JsonProperty("valorUnitarioVenda")
    private double valorUnitarioVenda;

    public Produto(int codigo, String nome, int unidade, double valorUnitario, double valorUnitarioVenda) {
        this.codigo = codigo;
        this.nome = nome;
        this.unidade = unidade;
        this.valorUnitario = valorUnitario;
        this.valorUnitarioVenda = valorUnitarioVenda;
    }

    public Produto() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorUnitarioVenda() {
        return valorUnitarioVenda;
    }

    public void setValorUnitarioVenda(double valorUnitarioVenda) {
        this.valorUnitarioVenda = valorUnitarioVenda;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", unidade=" + unidade +
                ", valorUnitario=" + valorUnitario +
                ", valorUnitarioVenda=" + valorUnitarioVenda +
                '}';
    }
}