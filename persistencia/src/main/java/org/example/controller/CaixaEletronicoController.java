package org.example.controller;

import org.example.model.Almoxerife;
import org.example.model.CaixaEletronico;
import org.example.model.MetodosGerenteCaixa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CaixaEletronicoController extends MetodosGerenteCaixa {

    // 1- Fazer login
    public boolean fazerLogin(CaixaEletronico caixa) throws IOException {
        List<CaixaEletronico> lista =  lerArquivoCaixaEletronico();

        if (lista == null) {
            lista = new ArrayList<>();
        }

        for(CaixaEletronico c : lista){
            if(c.getLogin().equals(caixa.getLogin()) && c.getSenha().equals(caixa.getSenha())){
                return true;
            }
        }
        return false;
    }

    // Realizar uma venda
    public void realizarVenda(){

    }

    //Emitir nota de venda
    public void emitirNotaDeVenda(){

    }
}
