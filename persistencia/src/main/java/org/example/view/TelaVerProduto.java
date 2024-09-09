package org.example.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JOptionPane;

import org.example.model.Produto;

public class TelaVerProduto extends TelaPadrao {

	private Produto produto;

	public TelaVerProduto(Produto produto) {
		super("Detalhes do Produto", "Detalhes do Produto");
		this.produto = produto;
		adicionarLabel();
		adicionarBotoes();
		setVisible(true);

	}

	private class OuvinteDosBotoes implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Voltar":
				new TelaListarProdutos();
				dispose();
				break;


			case "Editar valor de Venda":
				String var = JOptionPane.showInputDialog("Digite o Valor de venda");
				try {
					double valor = Double.parseDouble(var);

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Não foi possivel alterar o valor!");
				}

				new TelaVerProduto(produto);

				dispose();
				break;
			}

		}

	}


	public void adicionarLabel() {
		Font font = new Font("Georgia", Font.ITALIC, 20);

		JLabel lbNome = new JLabel("codigo: " + produto.getCodigo());

		lbNome.setBounds(440, 120, 350, 30);
		lbNome.setFont(font);
		add(lbNome);

		JLabel lbMatricula = new JLabel("Nome: " + produto.getNome());
		lbMatricula.setBounds(440, 160, 350, 30);
		lbMatricula.setFont(font);
		add(lbMatricula);

		JLabel lbEmail = new JLabel("Unidade: " + produto.getUnidade());
		lbEmail.setFont(font);
		lbEmail.setBounds(440, 200, 350, 30);
		add(lbEmail);

		JLabel lbSexo = new JLabel("Valor de Compra: " + produto.getValorUnitario());
		lbSexo.setBounds(440, 240, 350, 30);
		lbSexo.setFont(font);
		add(lbSexo);

		JLabel lbSenha = new JLabel("Valor de Venda: " + produto.getValorUnitarioVenda());
		lbSenha.setBounds(440, 280, 350, 30);
		lbSenha.setFont(font);
		add(lbSenha);

	}

	public void adicionarBotoes() {
		// Ouvinte interno
		OuvinteDosBotoes ouvinte = new OuvinteDosBotoes();

		JButton btEditar = new JButton("Editar valor de Venda");
		btEditar.setBounds(440, 400, 160, 30);
		btEditar.addActionListener(ouvinte);
		add(btEditar);

		JButton btVoltar = new JButton("Voltar");
		btVoltar.setBounds(700, 400, 90, 30);
		btVoltar.addActionListener(ouvinte);
		add(btVoltar);

	}

}
