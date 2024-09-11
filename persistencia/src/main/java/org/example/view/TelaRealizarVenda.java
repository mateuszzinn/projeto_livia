package org.example.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.example.controller.CaixaEletronicoController;
import org.example.controller.GerenteController;


public class TelaRealizarVenda extends TelaPadrao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfCPF;
	private JTextField tfCodigoProduto;
	private JTextField tfQtd;
	private JTextField tfCupomDesconto;

	public TelaRealizarVenda() {
		super("Realizar Venda", "Realizar Venda");
		adicionarLabel();
		adicionarTextFields();
		adicionarBotoes();
		setVisible(true);
	}

	private class OuvinteCadastrarUsuario implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Finalizar Venda":
				CaixaEletronicoController caixaEletronicoController = new CaixaEletronicoController();
				
				int cpf = Integer.parseInt(tfCPF.getText());
				int codigoProduto = Integer.parseInt(tfCodigoProduto.getText());
				int quantidade = Integer.parseInt(tfQtd.getText());
				String cupom = tfCupomDesconto.getText();
				
				// falta fazer o metodo da venda
				// ele fica aqui é so chamar o merodo 
				// e passar os parametro a cima
				//caixaEletronicoController.realizarVenda();
				JOptionPane.showMessageDialog(null, "Venda Realizada!");
				new TelaMenuCaixaEletronico();
				dispose();
				break;
			case "Voltar":
				new TelaMenuCaixaEletronico();
				dispose();
				break;

				
			}
		}
	}


	public void adicionarLabel() {
		Font font = new Font("Georgia", Font.ITALIC, 20);

		JLabel lbNome = new JLabel("CPF: ");
		lbNome.setBounds(440, 130, 200, 30);
		lbNome.setFont(font);
		lbNome.setForeground(Color.BLACK);
		add(lbNome);

		JLabel lbLogin = new JLabel("Código do Produto: ");
		lbLogin.setBounds(440, 180, 200, 30);
		lbLogin.setFont(font);
		lbLogin.setForeground(Color.BLACK);
		add(lbLogin);

		JLabel lbEmail = new JLabel("Quantidade: ");
		lbEmail.setBounds(440, 230, 200, 30);
		lbEmail.setFont(font);
		lbEmail.setForeground(Color.BLACK);
		add(lbEmail);

		JLabel lbNis = new JLabel("Cupom de Desconto: ");
		lbNis.setBounds(440, 280, 200, 30);
		lbNis.setFont(font);
		lbNis.setForeground(Color.BLACK);
		add(lbNis);

	}

	public void adicionarTextFields() {

		tfCPF = new JTextField();
		tfCPF.setBounds(630, 130, 200, 30);
		add(tfCPF);

		tfCodigoProduto = new JTextField();
		tfCodigoProduto.setBounds(630, 180, 200, 30);
		add(tfCodigoProduto);

		tfQtd = new JTextField();
		tfQtd.setBounds(630, 230, 200, 30);
		add(tfQtd);

		tfCupomDesconto = new JTextField();
		tfCupomDesconto.setBounds(630, 280, 200, 30);
		add(tfCupomDesconto);

	}

	public void adicionarBotoes() {
		OuvinteCadastrarUsuario ouvinteDoBotaoCadastrar = new OuvinteCadastrarUsuario();

		JButton btCadastar = new JButton("Finalizar Venda");
		btCadastar.setBounds(440, 400, 150, 40);
		btCadastar.addActionListener(ouvinteDoBotaoCadastrar);
		add(btCadastar);
		

		JButton btVoltar = new JButton("Voltar");
		btVoltar.setBounds(670, 400, 150, 40);
		btVoltar.addActionListener(ouvinteDoBotaoCadastrar);
		add(btVoltar);
	}

}