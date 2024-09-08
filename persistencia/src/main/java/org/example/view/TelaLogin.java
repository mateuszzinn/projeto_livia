package org.example.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.example.controller.GerenteController;
import org.example.model.Produto;
import org.example.utils.paths.Path;


public class TelaLogin extends TelaPadrao {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextField tfLogin;
    private JPasswordField pfSenha;

    public TelaLogin() throws IOException {
        super("Fazer Login", "Fazer Login");
        adicionarLabel();
        adicionarTextFields();
        adicionarBotoes();
        setVisible(true);
    }

    private class OuvinteDosBotoes implements ActionListener {

        GerenteController gerenteController = new GerenteController();

        private OuvinteDosBotoes() throws IOException {
        }

        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Entrar":
                    String email = tfLogin.getText();

                    List<Produto> produtos = (List<Produto>) gerenteController.readPessoas(Path.PRODUTOS_PATH);
                    for (Produto p : produtos) {
                        if (p.getNome().equals(email)) {
                            System.out.println("Menu");
                            dispose();
                            break;
                        }
                    }
                    System.out.println("user not");

                    dispose();
                    break;


                case "Recuperar senha":

                    break;

                case "Nova Conta":
                    break;

            }

        }
    }


    public void adicionarBotoes() throws IOException {
        //Ouvinte interno
        OuvinteDosBotoes ouvinte = new OuvinteDosBotoes();

        JButton btSalvar = new JButton("Entrar");
        btSalvar.setBounds(400, 330, 100, 30);
        btSalvar.addActionListener(ouvinte);
        add(btSalvar);

        JButton btRecuperarSenha = new JButton("Recuperar senha");
        btRecuperarSenha.setBounds(220, 205, 140, 20);
        btRecuperarSenha.addActionListener(ouvinte);
        add(btRecuperarSenha);

        JButton btNovaConta = new JButton("Nova Conta");
        btNovaConta.setBounds(220, 230, 100, 20);
        btNovaConta.addActionListener(ouvinte);
        add(btNovaConta);

    }

    public void adicionarTextFields() {
    	tfLogin = new JTextField();
    	tfLogin.setBounds(220, 120, 270, 25);
        add(tfLogin);

        pfSenha = new JPasswordField();
        pfSenha.setBounds(220, 160, 270, 25);
        add(pfSenha);

    }

    public void adicionarLabel() {
        Font font = new Font("Georgia", Font.ITALIC, 15);

        JLabel lbEmail = new JLabel("E-mail: ");
        lbEmail.setBounds(160, 120, 100, 30);
        lbEmail.setFont(font);
        add(lbEmail);

        JLabel lbSenha = new JLabel("Senha: ");
        lbSenha.setBounds(158, 160, 100, 30);
        lbSenha.setFont(font);
        add(lbSenha);

    }
    
}