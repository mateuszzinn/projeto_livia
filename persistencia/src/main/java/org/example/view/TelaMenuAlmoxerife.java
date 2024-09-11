package org.example.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;


public class TelaMenuAlmoxerife extends TelaPadrao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TelaMenuAlmoxerife() {
		super("Menu Almoxerife", "Menu Almoxerife");
		adicionarBotoes();
		setVisible(true);
	}

	private class OuvinteDosBotoes implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Casdastrar Cliente":
				new TelaCadastrarCliente("Almoxerife");
				dispose();
				break;
			case "Casdastrar Produto":
				new TelaCadastrarProduto("Almoxerife");
				dispose();
				break;
			case "Listar Produtos":
				new TelaListarProdutos("Almoxerife");
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

		// Botão de Cadastrar Usuario
		JButton btCadastrarCliente = new JButton("Casdastrar Cliente");
		btCadastrarCliente .setBounds(500, 130, 250, 30);
		btCadastrarCliente .setFont(new Font("Georgia", Font.ITALIC, 20));
		btCadastrarCliente .addActionListener(ouvinte);
		add(btCadastrarCliente);

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

		// Botão de Sair
		JButton btSair = new JButton("Sair");
		btSair.setBounds(660, 400, 90, 30);
		btSair.setFont(new Font("Georgia", Font.ITALIC, 20));
		btSair.addActionListener(ouvinte);
		add(btSair);
	}

}
