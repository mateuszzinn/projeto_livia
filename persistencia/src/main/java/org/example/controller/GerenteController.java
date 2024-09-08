package org.example.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.*;
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
        List<Gerente> gerentes = lerArquivoGerente();

        if (gerentes == null) {
            gerentes = new ArrayList<>();
        }

        gerentes.add(gerente);
        escreverNoArquivo(Path.GERENTE_PATH, gerentes);
    }

    // 2- Fazer login
    public boolean fazerLogin(Gerente gerente) throws IOException {
        List<Gerente> lista = (List<Gerente>) lerArquivoGerente();

        if (lista == null) {
            lista = new ArrayList<>();
        }

        for(Gerente g : lista){
            if(g.getLogin().equals(gerente.getLogin()) && g.getSenha().equals(gerente.getSenha())){
                return true;
            }
        }
        return false;
    }


    // 3- Cadastro de almoxerife
    public void cadastrarAlmoxerife(Almoxerife almoxerife){
        criarArquivo(Path.ALMOXERIFE_PATH);

        List<Almoxerife> lista = lerArquivoAlmoxerife();
        if(lista == null){
            lista = new ArrayList<>();
        }
        lista.add(almoxerife);
        escreverNoArquivo(Path.ALMOXERIFE_PATH, lista);
    }

    // 3- Cadastro de Caixa Eletrônico
    public void cadastrarCaixaEletronico(CaixaEletronico caixa){
        criarArquivo(Path.CAIXA_PATH);

        List<CaixaEletronico> lista = (List<CaixaEletronico>) lerArquivoCaixaEletronico();
        if(lista == null){
            lista = new ArrayList<>();
        }

        lista.add(caixa);
        escreverNoArquivo(Path.CAIXA_PATH, lista);
    }

    // 4- Cadastro de produtos
    public void cadastrarProduto(Produto produto) {
        criarArquivo(Path.PRODUTOS_PATH);
        List<Produto> lista = lerArquivoProduto();

        if (lista == null) {
            lista = new ArrayList<>();
        }

        lista.add(produto);
        escreverNoArquivo(Path.PRODUTOS_PATH, lista);
    }

    // 5- Listar Produtos
    public List<Produto> listarProdutos(){
        return lerArquivoProduto();
    }

    // 6- Exibir detalhes de um produto
    public Produto exibirDetalhesProduto(int codigo){
        Produto entidade = null;
        List<Produto> lista = lerArquivoProduto();

        if (lista == null) {
            lista = new ArrayList<>();
        }

        for(Produto p : lista){
            if(p.getCodigo() == codigo){
                entidade = p;
            }
        }

        return entidade;
    }

    // 7- Editar produto
    public void editarProduto(int codigo, Produto atualizacao) {
        List<Produto> produtos = lerArquivoProduto();

        if (produtos != null) {
            for (int i = 0; i < produtos.size(); i++) {
                if (produtos.get(i).getCodigo() == codigo) {
                    produtos.set(i, atualizacao);
                    escreverNoArquivo(Path.PRODUTOS_PATH,produtos);
                    System.out.println("Produto atualizado");
                    return;
                }
            }
            System.out.println("Produto não encontrado");
        }
    }

    // 8- Registrar valor unitário de venda de produto

    // 9- Cadastro de cliente
    public void cadastrarCliente(Cliente cliente) {
        criarArquivo(Path.CLIENTE_PATH);
        List<Cliente> lista = lerArquivoCliente();

        if (lista == null) {
            lista = new ArrayList<>();
        }

        lista.add(cliente);
        escreverNoArquivo(Path.CLIENTE_PATH, lista);
    }

    // 10- Enviar email com cupom de desconto

    // 11- Gerar relatório de balanço mensal

    // Método para ler todas as pessoas do arquivo JSON GERENTE
    public List<Gerente> lerArquivoGerente() {
        try {
            return objectMapper.readValue(new File(Path.GERENTE_PATH), new TypeReference<List<Gerente>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para ler todas as pessoas do arquivo JSON ALMOXERIFE
    public List<Almoxerife> lerArquivoAlmoxerife() {
        try {
            return objectMapper.readValue(new File(Path.ALMOXERIFE_PATH), new TypeReference<List<Almoxerife>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para ler todas as pessoas do arquivo JSON CAIXA ELETRÔNICO
    public List<CaixaEletronico> lerArquivoCaixaEletronico() {
        try {
            return objectMapper.readValue(new File(Path.CAIXA_PATH), new TypeReference<List<CaixaEletronico>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para ler todas as pessoas do arquivo JSON PRODUTO
    public List<Produto> lerArquivoProduto() {
        try {
            return objectMapper.readValue(new File(Path.PRODUTOS_PATH), new TypeReference<List<Produto>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para ler todas as pessoas do arquivo JSON CLIENTE
    public List<Cliente> lerArquivoCliente() {
        try {
            return objectMapper.readValue(new File(Path.PRODUTOS_PATH), new TypeReference<List<Cliente>>() {
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
