package org.example.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaPadrao extends JFrame {

    public TelaPadrao(String titulo, String tituloPadrao) {
        setTitle(titulo);
        setSize(1300, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setResizable(false);
        setResizable(true);
        setLocationRelativeTo(null);
        Color minhaCor = new Color(229, 229, 229);
        getContentPane().setBackground(minhaCor);
        
        JLabel lbTitulo = new JLabel(tituloPadrao);
        lbTitulo.setBounds(180, 50, 900, 30);
        lbTitulo.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 40));
        lbTitulo.setHorizontalAlignment(JLabel.CENTER);
        add(lbTitulo);
        
    }
}
