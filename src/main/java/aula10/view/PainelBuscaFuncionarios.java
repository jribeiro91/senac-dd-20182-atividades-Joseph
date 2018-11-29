package aula10.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import aula10.controller.FuncionarioController;
import aula10.vo.Funcionario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelBuscaFuncionarios extends JPanel {
	private JTable tbFuncionarios;
	private JTextField textNome;
	private JTextField textMatricula;
	private JTextField textCpf;
	private DefaultTableModel model;
	private Funcionario fSelecionado;

	/**
	 * Create the panel.
	 */
	public PainelBuscaFuncionarios() {
		
		tbFuncionarios = new JTable();
		tbFuncionarios.setBounds(10, 144, 430, 233);
		
		
		model = new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
				},
				new String[] {
					"Nome", "CPF", "Matrícula",
				}
			);
		
		populaTabela();
		
		tbFuncionarios.setModel(model);
		
		JLabel lblNewLabel = new JLabel("Buscar Funcion\u00E1rio");
		lblNewLabel.setBounds(10, 11, 90, 14);
		
		textNome = new JTextField();
		textNome.setBounds(66, 31, 209, 20);
		textNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 34, 52, 14);
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(10, 60, 52, 14);
		lblMatricula.setHorizontalAlignment(SwingConstants.LEFT);
		
		textMatricula = new JTextField();
		textMatricula.setBounds(66, 57, 209, 20);
		textMatricula.setColumns(10);
		
		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setBounds(10, 86, 52, 14);
		lblCpf.setHorizontalAlignment(SwingConstants.LEFT);
		
		textCpf = new JTextField();
		textCpf.setBounds(66, 83, 209, 20);
		textCpf.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar tabela");
		btnAtualizar.setBounds(265, 388, 175, 23);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(178, 110, 98, 23);
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
//				buscaComFiltro(fSelecionado);
				
			}

			
		});
		setLayout(null);
		add(tbFuncionarios);
		add(lblNewLabel);
		add(lblMatricula);
		add(textMatricula);
		add(lblNome);
		add(textNome);
		add(lblCpf);
		add(btnAtualizar);
		add(textCpf);
		add(btnBuscar);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textCpf.setText("");
				textMatricula.setText("");
				textNome.setText("");
			}
		});
		btnApagar.setBounds(66, 110, 98, 23);
		add(btnApagar);
		
		tbFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int linha = tbFuncionarios.getSelectedRow();
				
				System.out.println(linha);
				
				
				if (linha > 1) {
				textNome.setText(tbFuncionarios.getValueAt(linha, 0) + "");
				textMatricula.setText(tbFuncionarios.getValueAt(linha, 2) + "");
				textCpf.setText(tbFuncionarios.getValueAt(linha, 1) + "");
				}
			}
		});
		
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				populaTabela();
//				
			}

			
			
		});
		
		populaTabela();
	}
	
	public void populaTabela() {
		resetaTabela();
		
		
		
		FuncionarioController controle = new FuncionarioController();
		ArrayList<Funcionario> funcionarios = controle.listarFuncionarios();
		
		model.addRow(new Object[] {"NOME", "CPF", "MATRICULA"});
		for(int i = 0; i < funcionarios.size(); i++) {
			
			model.addRow(new Object[] {funcionarios.get(i).getNome(),funcionarios.get(i).getCpf() + "", funcionarios.get(i).getNumeroMatricula() + ""});
		}
		revalidate();
	}
	
	
	public void resetaTabela() {
		for (int i = tbFuncionarios.getRowCount()-1; i > 0 ; i-- ) {
			model.removeRow(i);
		}
		revalidate();
	}
}
