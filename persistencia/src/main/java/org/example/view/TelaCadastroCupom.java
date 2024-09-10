package org.example.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.example.controller.GerenteController;

public class TelaCadastroCupom extends TelaPadrao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField tfCupom;
	private JTextField tfPorcentagem;

	public TelaCadastroCupom() {
		super("Cadastrar do Cupom", "Cadastrar do Cupom");
		adicionarLabel();
		adicionarTextFields();
		adicionarBotoes();
		setVisible(true);
	}

	private class OuvinteCadastrarProduto implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Enviar":
				String nome = tfCupom.getText();
			
				int codigo = Integer.parseInt(tfPorcentagem.getText());
				
				new GerenteController().enviarEmailComCupomDeDesconto(nome, codigo);
				
				JOptionPane.showMessageDialog(null, "Cupom Enviado!");
				
				new TelaMenuGerente();
				dispose();
				break;
			case "Voltar":
				new TelaMenuGerente();
				dispose();
				break;

			}
		}
	}

	public void adicionarLabel() {
		Font font = new Font("Georgia", Font.ITALIC, 20);

		JLabel lbNome = new JLabel("Código do Cupom:");
		lbNome.setBounds(420, 130, 200, 30);
		lbNome.setFont(font);
		lbNome.setForeground(Color.BLACK);
		add(lbNome);

		JLabel lbLogin = new JLabel("Porcentagem de Desconto:");
		lbLogin.setBounds(420, 180, 260, 30);
		lbLogin.setFont(font);
		lbLogin.setForeground(Color.BLACK);
		add(lbLogin);

	}

	public void adicionarTextFields() {

		

		tfCupom = new JTextField();
		tfCupom.setBounds(690, 130, 160, 30);
		add(tfCupom);

		tfPorcentagem = new JTextField();
		tfPorcentagem.setBounds(690, 180, 160, 30);
		add(tfPorcentagem);

	}

	public void adicionarBotoes() {
		OuvinteCadastrarProduto ouvinteDoBotaoCadastrar = new OuvinteCadastrarProduto();

		JButton btCadastar = new JButton("Enviar");
		btCadastar.setBounds(440, 400, 150, 40);
		btCadastar.addActionListener(ouvinteDoBotaoCadastrar);
		add(btCadastar);

		JButton btVoltar = new JButton("Voltar");
		btVoltar.setBounds(670, 400, 150, 40);
		btVoltar.addActionListener(ouvinteDoBotaoCadastrar);
		add(btVoltar);
	}

}
