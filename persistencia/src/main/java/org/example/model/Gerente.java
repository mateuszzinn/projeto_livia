package org.example.model;

public class Gerente extends AdministradorMercado{

    public Gerente(){
    }

    // Construtor com dados obrigatórios de preenchimento
    public Gerente(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    // Construtor com dados opcionais de preenchimento
    public Gerente(String nome, String login, String senha, String email, int nis) {
        super(nome, login, senha, email, nis);
    }

}
