package org.example.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TelaMenuGerente extends TelaPadrao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TelaMenuGerente() {
		super("Menu Gerente", "Menu Gerente");
		adicionarBotoes();
		setVisible(true);
	}

	private class OuvinteDosBotoes implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Casdastrar Usuários":
				new TelaCadastrarUsuario();
				dispose();
				break;
			case "Casdastrar Produto":
				new TelaCadastrarProduto();
				dispose();
				break;
			case "Listar Produtos":
				new TelaListarProdutos();
				dispose();
				break;
			case "Sair":
				new TelaLogin();
				dispose();
				break;
			}

		}
	}

	public void adicionarBotoes() {
		OuvinteDosBotoes ouvinte = new OuvinteDosBotoes();

		// Botão de Cadastrar Edital de Monitoria
		JButton btCadastrarEdital = new JButton("Casdastrar Usuários");
		btCadastrarEdital.setBounds(500, 130, 250, 30);
		btCadastrarEdital.setFont(new Font("Georgia", Font.ITALIC, 20));
		btCadastrarEdital.addActionListener(ouvinte);
		add(btCadastrarEdital);

		// Botão de Listar Editais
		JButton btListarEditais = new JButton("Casdastrar Produto");
		btListarEditais.setBounds(500, 180, 250, 30);
		btListarEditais.setFont(new Font("Georgia", Font.ITALIC, 20));
		btListarEditais.addActionListener(ouvinte);
		add(btListarEditais);

		// Botão de Listar todos os Alunos
		JButton btListarAlunos = new JButton("Listar Produtos");
		btListarAlunos.setBounds(500, 230, 250, 30);
		btListarAlunos.setFont(new Font("Georgia", Font.ITALIC, 20));
		btListarAlunos.addActionListener(ouvinte);
		add(btListarAlunos);

		// Botão de Sair
		JButton btSair = new JButton("Sair");
		btSair.setBounds(650, 350, 90, 30);
		btSair.setFont(new Font("Georgia", Font.ITALIC, 20));
		btSair.addActionListener(ouvinte);
		add(btSair);
	}
	
	public static void main(String[] args) {
		new TelaMenuGerente();
	}

}
