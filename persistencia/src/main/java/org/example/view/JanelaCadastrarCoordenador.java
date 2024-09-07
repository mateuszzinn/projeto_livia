package org.example.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.example.controller.GerenteController;
import org.example.model.Produto;

public class JanelaCadastrarCoordenador extends TelaPadraoImagem {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextField tfNome;
    private JTextField tfEmail;
    private JPasswordField pfSenha;
    private JPasswordField pfConfirmarSenha;

    public JanelaCadastrarCoordenador() {
        super("Cadastro do coordenador", "Cadastrar Coordenador");
        adicionarLabel();
        adicionarTextFields();
        adicionarBotoes();
        setVisible(true);
    }

    private class OuvinteCadastrarCoordenador implements ActionListener {

        public void actionPerformed(ActionEvent cliqueCadastrar) {
            String nome = tfNome.getText();
            String email = tfEmail.getText();
            int idade = Integer.parseInt(email);

            //Produto p = new Produto(nome, idade);

            //GerenteController.create(p);

            try {
                new JanelaLogin();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            dispose();

        }

    }

    // So permite ser digitado letra
    private class OuvinteDeTecladoDoCampoNome implements KeyListener {
        public void keyTyped(KeyEvent e) {
            char letra = e.getKeyChar();
            if (Character.isDigit(letra))
                e.consume();
        }

        public void keyPressed(KeyEvent e) {

        }

        public void keyReleased(KeyEvent e) {

        }

    }

    public void adicionarLabel() {
        Font font = new Font("Georgia", Font.ITALIC, 15);

        JLabel lbNome = new JLabel("Nome: ");
        lbNome.setBounds(160, 120, 100, 30);
        lbNome.setFont(font);
        lbNome.setForeground(Color.BLACK);
        add(lbNome);

        JLabel lbEmail = new JLabel("E-mail: ");
        lbEmail.setBounds(158, 170, 100, 30);
        lbEmail.setFont(font);
        lbEmail.setForeground(Color.BLACK);
        add(lbEmail);

        JLabel lbSenha = new JLabel("Senha: ");
        lbSenha.setBounds(320, 200, 100, 30);
        lbSenha.setFont(font);
        lbSenha.setForeground(Color.BLACK);
        add(lbSenha);

        JLabel lbConfirmarSenha = new JLabel("Confirmar senha: ");
        lbConfirmarSenha.setBounds(290, 260, 200, 30);
        lbConfirmarSenha.setFont(font);
        lbConfirmarSenha.setForeground(Color.BLACK);
        add(lbConfirmarSenha);
    }

    public void adicionarTextFields() {

        OuvinteDeTecladoDoCampoNome ouvinteDoCampoNome = new OuvinteDeTecladoDoCampoNome();

        tfNome = new JTextField();
        tfNome.setBounds(220, 120, 270, 25);
        tfNome.addKeyListener(ouvinteDoCampoNome);
        add(tfNome);

        tfEmail = new JTextField();
        tfEmail.setBounds(220, 170, 270, 25);
        add(tfEmail);

        pfSenha = new JPasswordField();
        pfSenha.setBounds(250, 230, 200, 25);
        add(pfSenha);

        pfConfirmarSenha = new JPasswordField();
        pfConfirmarSenha.setBounds(250, 290, 200, 25);
        add(pfConfirmarSenha);
    }

    public void adicionarBotoes() {
        OuvinteCadastrarCoordenador ouvinteDoBotaoCadastrar = new OuvinteCadastrarCoordenador();

        JButton btCadastar = new JButton("Cadastrar");
        btCadastar.setBounds(450, 340, 100, 30);
        btCadastar.addActionListener(ouvinteDoBotaoCadastrar);
        add(btCadastar);
    }

}