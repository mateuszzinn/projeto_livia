package org.example.model;

public class Gerente {

    private String nome;
    private String login;
    private String senha;
    private String email;
    private int nis;

    // Construtor com dados obrigatórios de preenchimento
    public Gerente(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    // Construtor com dados opcionais de preenchimento
    public Gerente(String nome, String login, String senha, String email, int nis) {
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
        return "Gerente{" +
                "nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", nis=" + nis +
                '}';
    }
}
