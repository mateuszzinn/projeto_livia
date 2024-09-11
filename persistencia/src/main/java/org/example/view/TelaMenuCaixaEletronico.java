package org.example.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.example.controller.CaixaEletronicoController;

public class TelaMenuCaixaEletronico extends TelaPadrao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TelaMenuCaixaEletronico() {
		super("Menu Caixa Eletronico", "Menu Caixa Eletronico");
		adicionarBotoes();
		setVisible(true);
	}

	private class OuvinteDosBotoes implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Casdastrar Cliente":
				new TelaCadastrarCliente("Caixa Eletronico");
				dispose();
				break;
			case "Realizar Venda":
				new TelaRealizarVenda();
				dispose();
				break;
			case "Emitir Nota de Venda":
				CaixaEletronicoController caixaEletronicoController = new CaixaEletronicoController();
				//caixaEletronicoController.
				JOptionPane.showMessageDialog(null, "Nota de Venda Emitida!");
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
		JButton btCadastrarEdital = new JButton("Casdastrar Cliente");
		btCadastrarEdital.setBounds(500, 130, 250, 30);
		btCadastrarEdital.setFont(new Font("Georgia", Font.ITALIC, 20));
		btCadastrarEdital.addActionListener(ouvinte);
		add(btCadastrarEdital);

		// Botão de Cadastrar Produto
		JButton btCadastrarProduto = new JButton("Realizar Venda");
		btCadastrarProduto.setBounds(500, 180, 250, 30);
		btCadastrarProduto.setFont(new Font("Georgia", Font.ITALIC, 20));
		btCadastrarProduto.addActionListener(ouvinte);
		add(btCadastrarProduto);

		// Botão de Listar Produtos
		JButton btListarProdutos = new JButton("Emitir Nota de Venda");
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
