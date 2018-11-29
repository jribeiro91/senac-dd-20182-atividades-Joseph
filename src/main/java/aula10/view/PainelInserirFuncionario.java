package aula10.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import aula10.controller.FuncionarioController;
import aula10.dao.FuncionarioDAO;
import aula10.vo.Funcionario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PainelInserirFuncionario extends JPanel {
	private JTextField textCpf;
	private JTextField textMatricula;
	private JTextField textNome;
	private Funcionario funcionarioTemp;

	/**
	 * Create the panel.
	 */
	public PainelInserirFuncionario() {
		
		JLabel lblInserirFuncionario = new JLabel("Inserir Funcion\u00E1rio");
		
		JLabel label = new JLabel("Nome");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_1 = new JLabel("Matr\u00EDcula");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_2 = new JLabel("CPF");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textCpf = new JTextField();
		textCpf.setColumns(10);
		
		textMatricula = new JTextField();
		textMatricula.setColumns(10);
		
		textNome = new JTextField();
		
		textNome.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textNome.setText("");
				textMatricula.setText("");
				textCpf.setText("");
			}
		});
		
		JButton btnInserir = new JButton("Inserir");
		
		btnInserir.setEnabled(false);
		
		
		JLabel lblInfo = new JLabel("info");
		
		JButton btnAtualizar = new JButton("Atualizar");
		
		btnAtualizar.setEnabled(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblInfo, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
					.addContainerGap(75, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblInserirFuncionario)
					.addGap(351))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnInserir, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(31)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textCpf, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
								.addComponent(textMatricula, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNome, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInserirFuncionario)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label)))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1)))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnAtualizar)
						.addComponent(btnLimpar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblInfo)
					.addGap(133))
		);
		setLayout(groupLayout);
		
		textNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				FuncionarioController controle = new FuncionarioController();
				Funcionario f = controle.buscaFuncionarioPorNome(textNome.getText());
				funcionarioTemp = f;

				
				if (f != null) {
					textMatricula.setText(funcionarioTemp.getNumeroMatricula());
					textCpf.setText(funcionarioTemp.getCpf());
					btnAtualizar.setEnabled(true);
					btnInserir.setEnabled(false);
					lblInfo.setText("Usuário inserido com sucesso" + f.toString() );

					
					
				} else {
					btnAtualizar.setEnabled(false);
					btnInserir.setEnabled(true);
				}
				
			}
		});
		
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FuncionarioController controle = new FuncionarioController();
				Funcionario f = new Funcionario();
				f.setIdFuncionario(funcionarioTemp.getIdFuncionario());
				f.setNome(textNome.getText());
				f.setNumeroMatricula(textMatricula.getText());
				f.setCpf(textCpf.getText());
				
				
				if (controle.atualizarFuncionario(f)) {
					lblInfo.setText("Usuário atualizado com sucesso");
				};
				
				
			}
		});
		

		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FuncionarioController controle = new FuncionarioController();
				
				Funcionario f = new Funcionario();
				f.setNome(textNome.getText());
				f.setCpf(textCpf.getText());
				f.setNumeroMatricula(textMatricula.getText());
				controle.salvar(f);
				lblInfo.setText(f.toString() + "inserido com sucesso!");
				
				
			}
		});

	}
}
