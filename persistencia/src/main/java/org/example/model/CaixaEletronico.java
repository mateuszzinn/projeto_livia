package org.example.model;

public class CaixaEletronico extends AdministradorMercado {

    public CaixaEletronico(){

    }

    // Construtor com dados obrigatórios de preenchimento
    public CaixaEletronico(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    // Construtor com dados opcionais de preenchimento
    public CaixaEletronico(String nome, String login, String senha, String email, int nis) {
        super(nome, login, senha, email, nis);
    }
}
