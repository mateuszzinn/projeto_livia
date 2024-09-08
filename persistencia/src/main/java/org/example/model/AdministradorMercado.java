package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdministradorMercado {

    @JsonProperty("nome")
    private String nome;
    @JsonProperty("login")
    private String login;
    @JsonProperty("senha")
    private String senha;
    @JsonProperty("email")
    private String email;
    @JsonProperty("nis")
    private int nis;

    public AdministradorMercado(){

    }

    // Construtor com dados obrigatórios de preenchimento
    public AdministradorMercado(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    // Construtor com dados opcionais de preenchimento
    public AdministradorMercado(String nome, String login, String senha, String email, int nis) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.nis = nis;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNis() {
        return nis;
    }

    public void setNis(int nis) {
        this.nis = nis;
    }

    @Override
    public String toString() {
        return "AdministradorMercado{" +
                "nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", nis=" + nis +
                '}';
    }
}
