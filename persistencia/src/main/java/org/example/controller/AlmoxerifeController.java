package org.example.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Almoxerife;
import org.example.model.MetodosGerenteAlmoxerife;
import org.example.model.Produto;
import org.example.utils.paths.Path;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlmoxerifeController extends MetodosGerenteAlmoxerife {

    private static ObjectMapper objectMapper = new ObjectMapper();

    // 1- Fazer login
    public boolean fazerLogin(Almoxerife almoxerife) throws IOException {
        List<Almoxerife> lista =  lerArquivoAlmoxerife();

        if (lista == null) {
            lista = new ArrayList<>();
        }

        for(Almoxerife a : lista){
            if(a.getLogin().equals(almoxerife.getLogin()) && a.getSenha().equals(almoxerife.getSenha())){
                return true;
            }
        }
        return false;
    }

    // Registrar entrada de produto no estoque
    public void registrarEntrada(){

    }

    // 8- Registrar valor unitário de compra de produto
    public void registrarValorDeCompra(int codigo, double valorDeVenda){
        List<Produto> lista = lerArquivoProduto();

        for (Produto produto : lista){
            if(produto.getCodigo() == codigo){
                produto.setValorUnitarioVenda(valorDeVenda);
            }
        }
        escreverNoArquivo(Path.PRODUTOS_PATH, lista);
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
