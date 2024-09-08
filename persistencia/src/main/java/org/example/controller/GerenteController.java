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

public class GerenteController extends MetodosGerenteAlmoxerife {

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



    // 8- Registrar valor unitário de venda de produto
    public void registrarValorDeVenda(int codigo, double valorDeVenda){
        List<Produto> lista = lerArquivoProduto();

        for (Produto produto : lista){
            if(produto.getCodigo() == codigo){
                produto.setValorUnitarioVenda(valorDeVenda);
            }
        }
        escreverNoArquivo(Path.PRODUTOS_PATH, lista);
    }

    // 10- Enviar email com cupom de desconto

    // 11- Gerar relatório de balanço mensal



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
