package org.example.model;

public class Cliente {

    private String nome;
    private int CPF;
    private String email;
    private String endereco;

    // Construtor com dados obrigatórios de preenchimento
    public Cliente(String nome, int CPF, String email) {
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
    }

    // Construtor com dados opcionais de preenchimento
    public Cliente(String nome, int CPF, String email, String endereco) {
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", CPF=" + CPF +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
