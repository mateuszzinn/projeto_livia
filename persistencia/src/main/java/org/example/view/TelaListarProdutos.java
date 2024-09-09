package org.example.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.example.controller.GerenteController;
import org.example.model.Produto;

public class TelaListarProdutos extends TelaPadrao {

	private List<Produto> produtos = new GerenteController().listarProdutos();
	private List<Produto> listaProdutos;
	private JTable tabela;

	public TelaListarProdutos() {
		super("Listar Produtos", "Listar Produtos");
		adicionarTabela();
		adicionarBotoes();
		setVisible(true);

	}

	private class OuvinteListarProduto implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Ver Produto":
				int produtoSelecionado = tabela.getSelectedRow();
				if (produtoSelecionado == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um Produto!");
				} else {
					Produto produto = listaProdutos.get(produtoSelecionado);
					new TelaVerProduto(produto);
					dispose();
				}
				
				break;
			case "Voltar":
				new TelaMenuGerente();
				dispose();
				break;

			}
		}
	}

	public void adicionarTabela() {
		listaProdutos = new ArrayList<Produto>();

		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("Codigo");
		modelo.addColumn("Nome");
		modelo.addColumn("Unidade");
		modelo.addColumn("Estoque");
		// Lista com os Produtos
		if (produtos != null) {
			for (Produto produto : produtos) {
				listaProdutos.add(produto);
				Object[] linha = new Object[4];
				linha[0] = produto.getCodigo();
				linha[1] = produto.getNome();
				linha[2] = produto.getUnidade();
				linha[3] = produto.getNome();
				modelo.addRow(linha);
			}
		}

		tabela = new JTable(modelo);
		JScrollPane jsNomes = new JScrollPane(tabela);
		jsNomes.setBounds(460, 120, 340, 300);
		jsNomes.createVerticalScrollBar();
		add(jsNomes);

	}

	public void adicionarBotoes() {
		OuvinteListarProduto ouvinteDoBotaoCadastrar = new OuvinteListarProduto();

		JButton btVoltar = new JButton("Voltar");
		btVoltar.setBounds(670, 500, 150, 40);
		btVoltar.addActionListener(ouvinteDoBotaoCadastrar);
		add(btVoltar);
		
		JButton btVer = new JButton("Ver Produto");
		btVer.setBounds(480, 500, 150, 40);
		btVer.addActionListener(ouvinteDoBotaoCadastrar);
		add(btVer);
	}
}
