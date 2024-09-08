package org.example.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Almoxerife;
import org.example.model.CaixaEletronico;
import org.example.model.Gerente;
import org.example.model.Produto;
import org.example.utils.paths.Path;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenteController {

    private static ObjectMapper objectMapper = new ObjectMapper();

    // 1- Cadastro de Gerente
    public void cadastrarGerente(Gerente gerente) throws IOException {
        criarArquivo(Path.GERENTE_PATH);
        List<Gerente> gerentes = lerArquivoGerente(Path.GERENTE_PATH);

        if (gerentes == null) {
            gerentes = new ArrayList<>();
        }

        gerentes.add(gerente);
        escreverNoArquivo(Path.GERENTE_PATH, gerentes);
    }

    // 2- Fazer login
    public boolean fazerLogin(Gerente gerente) throws IOException {
        List<Gerente> gerentes = lerArquivoGerente(Path.GERENTE_PATH);

        if (gerentes == null) {
            gerentes = new ArrayList<>();
        }

        for(Gerente g : gerentes){
            if(g.getLogin().equals(gerente.getLogin()) && g.getSenha().equals(gerente.getSenha())){
                return true;
            }
        }
        return false;
    }

    /*
    // 3- Cadastro de almoxerife
    public void cadastrarAlmoxerife(Almoxerife almoxerife){
        criarArquivo(Path.ALMOXERIFE_PATH);

        List<Almoxerife> lista = (List<Almoxerife>) lerArquivo(Path.ALMOXERIFE_PATH);

        lista.add(almoxerife);
        escreverNoArquivo(Path.ALMOXERIFE_PATH, lista);
    }

    // 3- Cadastro de Caixa Eletrônico
    public void cadastrarCaixaEletronico(CaixaEletronico caixa){
        criarArquivo(Path.CAIXA_PATH);

        List<CaixaEletronico> lista = (List<CaixaEletronico>) lerArquivo(Path.CAIXA_PATH);

        lista.add(caixa);
        escreverNoArquivo(Path.CAIXA_PATH, lista);
    }

    // 4- Cadastro de produtos
    public void cadastrarProduto(Produto produto) {
        criarArquivo(Path.PRODUTOS_PATH);
        List<Produto> lista = (List<Produto>) lerArquivo(Path.PRODUTOS_PATH);

        if (lista == null) {
            lista = new ArrayList<>();
        }

        lista.add(produto);
        escreverNoArquivo(Path.PRODUTOS_PATH, lista);
    }
    */


    // Método para ler todas as pessoas do arquivo JSON
    public List<Gerente> lerArquivoGerente(String path) {
        try {
            return objectMapper.readValue(new File(path), new TypeReference<List<Gerente>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    // Método para escrever a lista de pessoas no arquivo JSON
    public void escreverNoArquivo(String path, List<?> list) {
        try {
            objectMapper.writeValue(new File(path), list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






























    public boolean criarArquivo(String path){
        File file = new File(path);

        if(!file.exists()){
            try {
                file.createNewFile();
                return true;
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /*



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
