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


public class TelaCadastroGerente extends TelaPadrao {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextField tfNome;
    private JTextField tfLogin;
    private JPasswordField pfSenha;
    private JPasswordField pfConfirmarSenha;

    public TelaCadastroGerente() {
        super("Cadastro do Gerente", "Cadastrar Gerente");
        adicionarLabel();
        adicionarTextFields();
        adicionarBotoes();
        setVisible(true);
    }

    private class OuvinteCadastrarCoordenador implements ActionListener {

        public void actionPerformed(ActionEvent cliqueCadastrar) {
            String nome = tfNome.getText();
            String login = tfLogin.getText();
            int idade = Integer.parseInt(login);

            //Produto p = new Produto(nome, idade);

            //GerenteController.create(p);

            try {
            	
                new TelaLogin();
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
        Font font = new Font("Georgia", Font.ITALIC, 20);

        JLabel lbNome = new JLabel("Nome: ");
        lbNome.setBounds(440, 130, 100, 30);
        lbNome.setFont(font);
        lbNome.setForeground(Color.BLACK);
        add(lbNome);

        JLabel lbLogin = new JLabel("Login: ");
        lbLogin.setBounds(440, 180, 100, 30);
        lbLogin.setFont(font);
        lbLogin.setForeground(Color.BLACK);
        add(lbLogin);
        
//        JLabel lbEmail = new JLabel("E-mail: ");
//        lbEmail.setBounds(440, 180, 100, 30);
//        lbEmail.setFont(font);
//        lbEmail.setForeground(Color.BLACK);
//        add(lbEmail);

        JLabel lbSenha = new JLabel("Senha: ");
        lbSenha.setBounds(550, 220, 100, 30);
        lbSenha.setFont(font);
        lbSenha.setForeground(Color.BLACK);
        add(lbSenha);

        JLabel lbConfirmarSenha = new JLabel("Confirmar senha: ");
        lbConfirmarSenha.setBounds(550, 290, 200, 30);
        lbConfirmarSenha.setFont(font);
        lbConfirmarSenha.setForeground(Color.BLACK);
        add(lbConfirmarSenha);
    }

    public void adicionarTextFields() {

        OuvinteDeTecladoDoCampoNome ouvinteDoCampoNome = new OuvinteDeTecladoDoCampoNome();

        tfNome = new JTextField();
        tfNome.setBounds(520, 130, 290, 30);
        tfNome.addKeyListener(ouvinteDoCampoNome);
        add(tfNome);

        tfLogin = new JTextField();
        tfLogin.setBounds(520, 180, 290, 30);
        add(tfLogin);

        pfSenha = new JPasswordField();
        pfSenha.setBounds(550, 250, 200, 30);
        add(pfSenha);

        pfConfirmarSenha = new JPasswordField();
        pfConfirmarSenha.setBounds(550, 320, 200, 30);
        add(pfConfirmarSenha);
    }

    public void adicionarBotoes() {
        OuvinteCadastrarCoordenador ouvinteDoBotaoCadastrar = new OuvinteCadastrarCoordenador();

        JButton btCadastar = new JButton("Cadastrar");
        btCadastar.setBounds(560, 400, 150, 50);
        btCadastar.addActionListener(ouvinteDoBotaoCadastrar);
        add(btCadastar);
    }

	public static void main(String[] args) {
		new TelaCadastroGerente();
	}
}
