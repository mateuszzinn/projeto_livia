package org.example.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Gerente;
import org.example.model.Produto;
import org.example.utils.paths.Path;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenteController {

    private static ObjectMapper objectMapper = new ObjectMapper();

    // Construtor
    public GerenteController() throws IOException {
        File file = new File("produtos.json");

        if (file.exists()) {
            return;
        } else {
            file.createNewFile();
        }

    }


    // MÉTODOS \/

    // Método para escrever a lista de pessoas no arquivo JSON
    public void writePessoas(String path, List<?> list) {
        try {
            objectMapper.writeValue(new File(path), list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para ler todas as pessoas do arquivo JSON
    public <T> List<?> readPessoas(String path) {
        try {
            return objectMapper.readValue(new File(path), new TypeReference<List<Produto>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Cadastro de Gerente
    public void cadastrarGerente(Gerente gerente) throws IOException {

        List<Gerente> gerentes = (List<Gerente>) readPessoas(Path.GERENTE_PATH);

        if (gerentes == null) {
            gerentes = new ArrayList<>();
        }

        gerentes.add(gerente);
        writePessoas(Path.GERENTE_PATH, gerentes);
    }


    /*
    // Método para criar um produto
    public void create(Produto produto) {
        List<Produto> produtos = (List<Produto>) readPessoas(Path.PRODUTOS_PATH);

        if (produtos == null) {
            produtos = new ArrayList<>();
        }

        produtos.add(produto);
        writePessoas(produtos);
    }


    // Método para realizar a atualização de uma pessoa
    public void update(String nome, Produto atualizacao) {
        List<Produto> produtos = (List<Produto>) readPessoas(Path.PRODUTOS_PATH);

        if (produtos != null) {
            for (int i = 0; i < produtos.size(); i++) {
                if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
                    produtos.set(i, atualizacao);
                    writePessoas(produtos);
                    System.out.println("Pessoa atualizada");
                    return;
                }
            }
            System.out.println("Pessoa não encontrada");
        }
    }

    public void delete(String nome) {
        List<Produto> produtos = (List<Produto>) readPessoas(Path.PRODUTOS_PATH);

        if (produtos != null) {
            produtos.removeIf(produto -> produto.getNome().equalsIgnoreCase(nome));
            writePessoas(produtos);
            System.out.println("Pessoa removida com sucesso");
        }
    }

    */
}
