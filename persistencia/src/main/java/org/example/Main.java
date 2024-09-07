package org.example;

import org.example.controller.GerenteController;
import org.example.model.Gerente;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        GerenteController controller = new GerenteController();
        controller.cadastrarGerente(new Gerente("Mateus", "mateuslima74", "1234"));
    }
}
