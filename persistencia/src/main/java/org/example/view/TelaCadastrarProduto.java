package org.example.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.example.controller.GerenteController;
import org.example.model.Gerente;
import org.example.model.Produto;

public class TelaCadastrarProduto extends TelaPadrao {

	private String usuario;
	private JTextField tfNome;
	private JTextField tfCodigo;

	public TelaCadastrarProduto(String usuario) {
		super("Cadastrar Produto", "Cadastrar Produto");
		this.usuario = usuario;
		adicionarLabel();
		adicionarTextFields();
		adicionarBotoes();
		setVisible(true);
	}

	private class OuvinteCadastrarProduto implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Cadastrar":
				String nome = tfNome.getText();
				int codigo = Integer.parseInt(tfCodigo.getText());

				new GerenteController().cadastrarProduto(new Produto(codigo, nome, 0, 0));
				JOptionPane.showMessageDialog(null, "Produto Cadastrado!");

				dispose();
				new TelaCadastrarProduto(usuario);
				break;
			case "Voltar":
				if(usuario.equals("Gerente")) {
					new TelaMenuGerente();
				} else if(usuario.equals("Almoxerife"))
					new TelaMenuAlmoxerife();
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

		JLabel lbLogin = new JLabel("Codigo: ");
		lbLogin.setBounds(440, 180, 100, 30);
		lbLogin.setFont(font);
		lbLogin.setForeground(Color.BLACK);
		add(lbLogin);

	}

	public void adicionarTextFields() {

		OuvinteDeTecladoDoCampoNome ouvinteDoCampoNome = new OuvinteDeTecladoDoCampoNome();

		tfNome = new JTextField();
		tfNome.setBounds(530, 130, 290, 30);
		tfNome.addKeyListener(ouvinteDoCampoNome);
		add(tfNome);

		tfCodigo = new JTextField();
		tfCodigo.setBounds(530, 180, 290, 30);
		add(tfCodigo);

	}

	public void adicionarBotoes() {
		OuvinteCadastrarProduto ouvinteDoBotaoCadastrar = new OuvinteCadastrarProduto();

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
