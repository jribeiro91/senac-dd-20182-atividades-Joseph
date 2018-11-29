package aula10.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import aula10.bo.ProdutoBO;
import aula10.controller.ProdutoController;
import aula10.vo.Produto;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelBuscaProduto extends JPanel {
	private JTextField textNome;
	private JTextField textid;
	private JTable tbProdutos;
	private JComboBox cmbFabricante;

	/**
	 * Create the panel.
	 */
	public PainelBuscaProduto() {
		
		JLabel lblBuscarProdutos = new JLabel("Buscar Produtos");
		lblBuscarProdutos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblId = new JLabel("id");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		
		textid = new JTextField();
		textid.setColumns(10);
		
		JLabel lblFabricante = new JLabel("Fabricante");
		lblFabricante.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				
				
			}

			

			
		});
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
	
				ProdutoController controle = new ProdutoController();
				
				
			}
		});
		
		tbProdutos = new JTable();
		tbProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				if (tbProdutos.getCellSelectionEnabled()) {
//					int row = tbProdutos.getSelectedRow();
//					
//				}
				if (tbProdutos.getSelectedRow() > 0) {
					btnDeletar.setEnabled(true);
				}
				
				
				
			}
		});
		
		tbProdutos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Nome", "Fabricante", "Valor", "Peso"
			}
		));
		

		//Popula a tabela
		
		populaTabelaProdutos();
		
		
		
		
		JComboBox cmbFabricante = new JComboBox();
		cmbFabricante.setModel(new DefaultComboBoxModel(new String[] {}));
		ProdutoBO bo = new ProdutoBO();
		
		ArrayList<String> fabricantes = bo.buscaFabricantesProduto();
		cmbFabricante.addItem(" ");
		for (String fabricante: fabricantes) {
			
			cmbFabricante.addItem(fabricante);
			
		}
		populaCbProdutos();
		
		
		
		
		btnDeletar.setEnabled(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblFabricante, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
								.addComponent(cmbFabricante, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNome, 220, 220, 220)
								.addComponent(textid, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
							.addGap(450))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblBuscarProdutos, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
							.addGap(301))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnDeletar)
							.addComponent(tbProdutos, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBuscarProdutos)
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblId)
							.addGap(17)
							.addComponent(lblNome)
							.addGap(12)
							.addComponent(lblFabricante))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(cmbFabricante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(tbProdutos, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDeletar)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {btnAtualizar, btnBuscar, btnDeletar});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnAtualizar, btnBuscar, btnDeletar});
		setLayout(groupLayout);
		
		

	}
	
	public void populaCbProdutos() {
		
		
		
	}

	public void populaTabelaProdutos() {
		ProdutoController controle = new ProdutoController();
		ArrayList<Produto> produtos =  controle.listarProdutos();
		
		DefaultTableModel model = (DefaultTableModel) tbProdutos.getModel();
		model.addRow(new Object[]{"NOME","FABRICANTE", "VALOR","PESO"});

		for (Produto produto:produtos) {
			model.addRow(new Object[]{produto.getNome() + "", produto.getFabricante() + "", produto.getValor() + "", produto.getValor() + ""});
		}
		
	}

	public void atualizaTabela() {
		tbProdutos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {"Nome", "Fabricante", "Valor", "Peso"
				}
				
			));
		ProdutoController controle = new ProdutoController();
		ArrayList<Produto> produtos =  controle.listarProdutos();
		
		
		DefaultTableModel model = (DefaultTableModel) tbProdutos.getModel();
		model.addRow(new Object[]{"NOME","FABRICANTE", "VALOR","PESO"});

		for (Produto produto:produtos) {
			model.addRow(new Object[]{produto.getNome() + "", produto.getFabricante() + "", produto.getValor() + "", produto.getValor() + ""});
		}
		
		
		
		
	}
}
