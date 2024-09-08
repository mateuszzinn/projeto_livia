package org.example.model;

public class Almoxerife extends AdministradorMercado {

    public Almoxerife(){

    }

    // Construtor com dados obrigatórios de preenchimento
    public Almoxerife(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    // Construtor com dados opcionais de preenchimento
    public Almoxerife(String nome, String login, String senha, String email, int nis) {
        super(nome, login, senha, email, nis);
    }
}
