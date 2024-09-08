package org.example;

import org.example.controller.GerenteController;
import org.example.model.Gerente;
import org.example.utils.paths.Path;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        GerenteController controller = new GerenteController();
        //controller.cadastrarGerente(new Gerente("Mateus", "mateuslima74", "123", "mateus@gmail.com", 1231));
        System.out.println(controller.fazerLogin(new Gerente("Mateus", "mateuslima74", "123", "mateus@gmail.com", 1231)));
    }
}
