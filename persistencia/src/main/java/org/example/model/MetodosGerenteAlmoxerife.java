package org.example.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.utils.paths.Path;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MetodosGerenteAlmoxerife {

    private static ObjectMapper objectMapper = new ObjectMapper();

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
}