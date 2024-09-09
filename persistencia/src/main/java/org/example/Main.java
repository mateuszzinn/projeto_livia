package org.example;

import org.example.controller.GerenteController;
import org.example.model.*;
import org.example.utils.paths.Path;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        GerenteController controller = new GerenteController();

        //controller.cadastrarGerente(new Gerente("George", "mateuslima74", "123", "mateus@gmail.com", 1231));
        //System.out.println(controller.fazerLogin(new Gerente("Mateus", "mateuslima74", "123", "mateus@gmail.com", 1231)));
        //controller.cadastrarAlmoxerife(new Almoxerife("George ALMOXERIFE", "mateuslima74", "123", "mateus@gmail.com", 1231));
        //controller.cadastrarCaixaEletronico(new CaixaEletronico("George PASSA RÁPIDO", "mateuslima74", "123", "mateus@gmail.com", 1231));
        //controller.cadastrarProduto(new Produto(57, "Feijão", 100, 4.50));

        /*
        List<Produto> lista = controller.listarProdutos();
        for (Produto p : lista){
            System.out.println(p);
        }
          */

        //System.out.println(controller.exibirDetalhesProduto(5));
        //controller.editarProduto(5, new Produto(15, "Feijas", 12, 5.50));
        //controller.registrarValorDeVenda(15, 8.80);
        //controller.cadastrarCliente(new Cliente("George CLIENTE", 123123321, "george@gmail.com", "Coxixola"));
    }
}
