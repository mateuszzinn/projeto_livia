package org.example.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
<<<<<<< Updated upstream
=======
import javax.swing.JOptionPane;

>>>>>>> Stashed changes
import org.example.model.Produto;

public class TelaVerProduto extends TelaPadrao{

<<<<<<< Updated upstream
	Produto produto;
	
	public TelaVerProduto(Produto produto) {
		super("Detalhar produto", "Detalhes do produto");
		this.produto = produto;
		
		adicionarLabel();
		adicionarBotoes();
		setVisible(true);
		
=======
	private Produto produto;
	
	public TelaVerProduto(Produto produto) {
		super("Detalhes do Produto","Detalhes do Produto");
		this.produto = produto;
		adicionarLabel();
		adicionarBotoes();
		setVisible(true);
>>>>>>> Stashed changes
	}
	
	private class OuvinteDosBotoes implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Voltar":
				new TelaListarProdutos();
				dispose();
				break;
<<<<<<< Updated upstream
			case "Editar Perfil":
				
=======
			case "Editar Valor de Venda":
				String var = JOptionPane.showInputDialog("Digite o Valor de venda");
				try {
					double valor = Double.parseDouble(var);
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Não foi possivel alterar o valor!");
				}
				
				new TelaVerProduto(produto);
>>>>>>> Stashed changes
				dispose();
				break;
			}

		}

	}
<<<<<<< Updated upstream
	public void adicionarLabel() {
		Font font = new Font("Georgia", Font.ITALIC, 20);

		JLabel lbNome = new JLabel("Codigo: " + produto.getCodigo());
=======
	
	public void adicionarLabel() {
		Font font = new Font("Georgia", Font.ITALIC, 20);

		JLabel lbNome = new JLabel("codigo: " + produto.getCodigo());
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
	
>>>>>>> Stashed changes
	public void adicionarBotoes() {
		// Ouvinte interno
		OuvinteDosBotoes ouvinte = new OuvinteDosBotoes();

<<<<<<< Updated upstream
		JButton btEditar = new JButton("Editar valor de Venda ");
		btEditar.setBounds(440, 400, 160, 30);
		btEditar.addActionListener(ouvinte);
		add(btEditar);

		JButton btVoltar = new JButton("Voltar");
		btVoltar.setBounds(700, 400, 90, 30);
=======
		JButton btSalvar = new JButton("Editar Valor de Venda");
		btSalvar.setBounds(440, 400, 180, 30);
		btSalvar.addActionListener(ouvinte);
		add(btSalvar);

		JButton btVoltar = new JButton("Voltar");
		btVoltar.setBounds(730, 400, 90, 30);
>>>>>>> Stashed changes
		btVoltar.addActionListener(ouvinte);
		add(btVoltar);

	}
<<<<<<< Updated upstream
=======


>>>>>>> Stashed changes
}
