package org.example.view;

import java.awt.Font;

import javax.swing.JLabel;

public class TelaPadraoImagem extends TelaPadrao {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public TelaPadraoImagem(String titulo, String tituloPadrao) {
        super(titulo);

        //Titulo
        JLabel lbTitulo = new JLabel(tituloPadrao);
        lbTitulo.setBounds(180, 25, 300, 30);
        lbTitulo.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 20));
        lbTitulo.setHorizontalAlignment(JLabel.CENTER);
        add(lbTitulo);


    }

}
