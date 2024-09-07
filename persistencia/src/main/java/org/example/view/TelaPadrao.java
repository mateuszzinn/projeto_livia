package org.example.view;

import java.awt.Color;

import javax.swing.JFrame;

public class TelaPadrao extends JFrame {

	//teste GitHub
    public TelaPadrao(String titulo) {
        setTitle(titulo);
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        Color minhaCor = new Color(229, 229, 229);
        getContentPane().setBackground(minhaCor);
    }
}
