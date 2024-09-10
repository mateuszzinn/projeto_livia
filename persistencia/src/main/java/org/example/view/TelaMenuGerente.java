package org.example.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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
			case "Envio de Cupons":
				new TelaCadastroCupom();
				dispose();
				break;
			case "Balanço do Mês":
				JOptionPane.showMessageDialog(null, "Balanço do Mês Gerado!");
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

		// Botão de Cadastrar Usuario
		JButton btCadastrarEdital = new JButton("Casdastrar Usuários");
		btCadastrarEdital.setBounds(500, 130, 250, 30);
		btCadastrarEdital.setFont(new Font("Georgia", Font.ITALIC, 20));
		btCadastrarEdital.addActionListener(ouvinte);
		add(btCadastrarEdital);

		// Botão de Cadastrar Produto
		JButton btCadastrarProduto = new JButton("Casdastrar Produto");
		btCadastrarProduto.setBounds(500, 180, 250, 30);
		btCadastrarProduto.setFont(new Font("Georgia", Font.ITALIC, 20));
		btCadastrarProduto.addActionListener(ouvinte);
		add(btCadastrarProduto);

		// Botão de Listar Produtos
		JButton btListarProdutos = new JButton("Listar Produtos");
		btListarProdutos.setBounds(500, 230, 250, 30);
		btListarProdutos.setFont(new Font("Georgia", Font.ITALIC, 20));
		btListarProdutos.addActionListener(ouvinte);
		add(btListarProdutos);
		
		JButton btEnviarCupons = new JButton("Envio de Cupons");
		btEnviarCupons.setBounds(500, 280, 250, 30);
		btEnviarCupons.setFont(new Font("Georgia", Font.ITALIC, 20));
		btEnviarCupons.addActionListener(ouvinte);
		add(btEnviarCupons);
		
		JButton btBalanco = new JButton("Balanço do Mês");
		btBalanco.setBounds(500, 330, 250, 30);
		btBalanco.setFont(new Font("Georgia", Font.ITALIC, 20));
		btBalanco.addActionListener(ouvinte);
		add(btBalanco);

		// Botão de Sair
		JButton btSair = new JButton("Sair");
		btSair.setBounds(660, 400, 90, 30);
		btSair.setFont(new Font("Georgia", Font.ITALIC, 20));
		btSair.addActionListener(ouvinte);
		add(btSair);
	}

}
