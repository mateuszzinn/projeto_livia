package org.example.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.example.controller.GerenteController;
import org.example.model.Cliente;
import org.example.model.Usuario;

public class TelaCadastrarCliente extends TelaPadrao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String usuario;

	private JTextField tfNome;
	private JTextField tfCPF;
	private JTextField tfEmail;
	private JTextField tfEndereco;

	private JComboBox<Usuario> cbUsuario;

	public TelaCadastrarCliente(String usuario) {
		super("Cadastrar Cliente", "Cadastrar Cliente");
		this.usuario = usuario;
		adicionarLabel();
		adicionarTextFields();
		adicionarBotoes();
		setVisible(true);
	}

	private class OuvinteCadastrarUsuario implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Cadastrar":
				GerenteController gerenteController = new GerenteController();

				String nome = tfNome.getText();
				int cpf = Integer.parseInt(tfCPF.getText());
				String email = tfEmail.getText();
				String endereco = tfEndereco.getText();

				gerenteController.cadastrarCliente(new Cliente(nome, cpf, email, endereco));
				JOptionPane.showMessageDialog(null, "Cliente Cadastrado!");

				if (getUsuario().equals("Gerente")) {
					new TelaCadastrarUsuario();
					dispose();
					// falta criar para as outras
				}
				break;
			case "Voltar":
				if (getUsuario().equals("Gerente")) {
					new TelaCadastrarUsuario();
					
				} else if(getUsuario().equals("Almoxerife")) {
					new TelaMenuAlmoxerife();
				}
				dispose();
				break;

			}
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

		JLabel lbLogin = new JLabel("CPF: ");
		lbLogin.setBounds(440, 180, 100, 30);
		lbLogin.setFont(font);
		lbLogin.setForeground(Color.BLACK);
		add(lbLogin);

		JLabel lbEmail = new JLabel("E-mail: ");
		lbEmail.setBounds(440, 230, 100, 30);
		lbEmail.setFont(font);
		lbEmail.setForeground(Color.BLACK);
		add(lbEmail);

		JLabel lbNis = new JLabel("Endereço: ");
		lbNis.setBounds(440, 280, 100, 30);
		lbNis.setFont(font);
		lbNis.setForeground(Color.BLACK);
		add(lbNis);

	}

	public void adicionarTextFields() {

		OuvinteDeTecladoDoCampoNome ouvinteDoCampoNome = new OuvinteDeTecladoDoCampoNome();

		tfNome = new JTextField();
		tfNome.setBounds(530, 130, 290, 30);
		tfNome.addKeyListener(ouvinteDoCampoNome);
		add(tfNome);

		tfCPF = new JTextField();
		tfCPF.setBounds(530, 180, 290, 30);
		add(tfCPF);

		tfEmail = new JTextField();
		tfEmail.setBounds(530, 230, 290, 30);
		add(tfEmail);

		tfEndereco = new JTextField();
		tfEndereco.setBounds(530, 280, 290, 30);
		add(tfEndereco);

	}

	public void adicionarBotoes() {
		OuvinteCadastrarUsuario ouvinteDoBotaoCadastrar = new OuvinteCadastrarUsuario();

		JButton btCadastar = new JButton("Cadastrar");
		btCadastar.setBounds(440, 500, 150, 40);
		btCadastar.addActionListener(ouvinteDoBotaoCadastrar);
		add(btCadastar);

		JButton btVoltar = new JButton("Voltar");
		btVoltar.setBounds(670, 500, 150, 40);
		btVoltar.addActionListener(ouvinteDoBotaoCadastrar);
		add(btVoltar);
	}

	public String getUsuario() {
		return usuario;
	}

}
