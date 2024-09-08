package org.example.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class TelaListarProdutos extends TelaPadrao{

	public TelaListarProdutos() {
		super("Listar Produtos","Listar Produtos");
		
		adicionarBotoes();
		setVisible(true);
		
	}
	private class OuvinteListarProduto implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Cadastrar":

				
				break;
			case "Voltar":
				new TelaMenuGerente();
				dispose();
				break;

			}
		}
	}
	
	
	public void adicionarBotoes() {
		OuvinteListarProduto ouvinteDoBotaoCadastrar = new OuvinteListarProduto();
		
		JButton btVoltar = new JButton("Voltar");
		btVoltar.setBounds(670, 500, 150, 40);
		btVoltar.addActionListener(ouvinteDoBotaoCadastrar);
		add(btVoltar);
	}
}
