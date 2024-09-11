package org.example.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.example.controller.AlmoxerifeController;
import org.example.controller.CaixaEletronicoController;
import org.example.controller.GerenteController;
import org.example.model.Almoxerife;
import org.example.model.CaixaEletronico;
import org.example.model.Gerente;

public class TelaLogin extends TelaPadrao {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfLogin;
	private JPasswordField pfSenha;

	public TelaLogin() {
		super("Fazer Login", "Fazer Login");
		adicionarLabel();
		adicionarTextFields();
		adicionarBotoes();
		setVisible(true);
	}

	private class OuvinteDosBotoes implements ActionListener {

		GerenteController gerenteController = new GerenteController();
		AlmoxerifeController almoxerifeController = new AlmoxerifeController();
		CaixaEletronicoController caixaEletronicoController = new CaixaEletronicoController();
		
		public void actionPerformed(ActionEvent e) {
			String login = tfLogin.getText();
			String senha = new String(pfSenha.getPassword());
			
			try {
				if(gerenteController.fazerLogin(new Gerente("Gleison pop100", login, senha))) {
					new TelaMenuGerente();
					dispose();
				} else if(almoxerifeController.fazerLogin(new Almoxerife("Cleytinho", login, senha))) {
					new TelaMenuAlmoxerife();
					dispose();
				} else if(caixaEletronicoController.fazerLogin(new CaixaEletronico("Livinha do Grau", login, senha))) {
					new TelaMenuCaixaEletronico();
					dispose();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	public void adicionarBotoes() {
		// Ouvinte interno
		OuvinteDosBotoes ouvinte = new OuvinteDosBotoes();

		JButton btSalvar = new JButton("Entrar");
		btSalvar.setBounds(590, 330, 110, 40);
		btSalvar.addActionListener(ouvinte);
		add(btSalvar);

	}

	public void adicionarTextFields() {
		tfLogin = new JTextField();
		tfLogin.setBounds(530, 140, 270, 30);
		add(tfLogin);

		pfSenha = new JPasswordField();
		pfSenha.setBounds(530, 190, 270, 30);
		add(pfSenha);

	}

	public void adicionarLabel() {
		Font font = new Font("Georgia", Font.ITALIC, 20);

		JLabel lbLogin = new JLabel("Login: ");
		lbLogin.setBounds(460, 140, 100, 30);
		lbLogin.setFont(font);
		add(lbLogin);

		JLabel lbSenha = new JLabel("Senha: ");
		lbSenha.setBounds(460, 190, 100, 30);
		lbSenha.setFont(font);
		add(lbSenha);

	}
	
}