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
import org.example.model.Gerente;

public class TelaCadastroGerente extends TelaPadrao {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfLogin;
	private JTextField tfEmail;
	private JTextField tfNIS;
	private JPasswordField pfSenha;
	private JPasswordField pfConfirmarSenha;

	public TelaCadastroGerente() {
		super("Cadastro do Gerente", "Cadastrar Gerente");
		adicionarLabel();
		adicionarTextFields();
		adicionarBotoes();
		setVisible(true);
	}

	private class OuvinteCadastrarGerente implements ActionListener {

		public void actionPerformed(ActionEvent cliqueCadastrar) {
			String nome = tfNome.getText();
			String login = tfLogin.getText();
			String email = tfEmail.getText();
			int nis = Integer.parseInt(tfNIS.getText());
			String senha = new String(pfSenha.getPassword());
			String cfSenha = new String(pfConfirmarSenha.getPassword());

			
			try {
				new GerenteController().cadastrarGerente(
						new Gerente(nome, login, senha, email, nis));
			} catch (IOException e) {
				e.printStackTrace();
			};
			new TelaLogin();
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

        JLabel lbEmail = new JLabel("E-mail: ");
        lbEmail.setBounds(440, 230, 100, 30);
        lbEmail.setFont(font);
        lbEmail.setForeground(Color.BLACK);
        add(lbEmail);

        JLabel lbNis = new JLabel("NIS/PIS: ");
        lbNis.setBounds(440, 280, 100, 30);
        lbNis.setFont(font);
        lbNis.setForeground(Color.BLACK);
        add(lbNis);

		JLabel lbSenha = new JLabel("Senha: ");
		lbSenha.setBounds(530, 330, 100, 30);
		lbSenha.setFont(font);
		lbSenha.setForeground(Color.BLACK);
		add(lbSenha);

		JLabel lbConfirmarSenha = new JLabel("Confirmar senha: ");
		lbConfirmarSenha.setBounds(530, 400, 200, 30);
		lbConfirmarSenha.setFont(font);
		lbConfirmarSenha.setForeground(Color.BLACK);
		add(lbConfirmarSenha);
	}

	public void adicionarTextFields() {

		OuvinteDeTecladoDoCampoNome ouvinteDoCampoNome = new OuvinteDeTecladoDoCampoNome();

		tfNome = new JTextField();
		tfNome.setBounds(530, 130, 290, 30);
		tfNome.addKeyListener(ouvinteDoCampoNome);
		add(tfNome);

		tfLogin = new JTextField();
		tfLogin.setBounds(530, 180, 290, 30);
		add(tfLogin);

		tfEmail = new JTextField();
		tfEmail.setBounds(530, 230, 290, 30);
		add(tfEmail);
		
		tfNIS = new JTextField();
		tfNIS.setBounds(530, 280, 290, 30);
		add(tfNIS);
	
		pfSenha = new JPasswordField();
		pfSenha.setBounds(530, 365, 200, 30);
		add(pfSenha);

		pfConfirmarSenha = new JPasswordField();
		pfConfirmarSenha.setBounds(530, 435, 200, 30);
		add(pfConfirmarSenha);
	}

	public void adicionarBotoes() {
		OuvinteCadastrarGerente ouvinteDoBotaoCadastrar = new OuvinteCadastrarGerente();

		JButton btCadastar = new JButton("Cadastrar");
		btCadastar.setBounds(560, 500, 150, 40);
		btCadastar.addActionListener(ouvinteDoBotaoCadastrar);
		add(btCadastar);
	}

}
