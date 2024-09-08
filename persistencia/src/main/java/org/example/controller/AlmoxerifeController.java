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
