package org.example.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.example.controller.GerenteController;

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

		public void actionPerformed(ActionEvent e) {

			String email = tfLogin.getText();

//                    List<Produto> produtos = (List<Produto>) gerenteController.(Path.PRODUTOS_PATH);
//                    for (Produto p : produtos) {
//                        if (p.getNome().equals(email)) {
//                            System.out.println("Menu");
//                            dispose();
//                            break;
//                        }
//                    }
			System.out.println("user not");

			dispose();

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

	public static void main(String[] args) {
		new TelaLogin();
	}

}