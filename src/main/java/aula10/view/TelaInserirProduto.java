package aula10.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import aula10.controller.ProdutoController;
import aula10.vo.Produto;

public class TelaInserirProduto extends JInternalFrame {

	private JPanel contentPaneProduto;
	private JTextField txtNome;
	private JTextField txtFabricante;
	private JTextField txtValor;
	private JTextField txtPeso;
	private Produto pTemp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInserirProduto frame = new TelaInserirProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInserirProduto() {
		setTitle("Inserir Produto");
		setBounds(100, 100, 391, 215);
		contentPaneProduto = new JPanel();
		contentPaneProduto.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneProduto);

		txtNome = new JTextField();
		txtNome.setColumns(10);

		txtFabricante = new JTextField();
		txtFabricante.setColumns(10);

		txtValor = new JTextField();
		txtValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				verificaCampoSomenteNumeros(arg0, txtValor, 20);
			}


		});
		txtValor.setColumns(10);

		JLabel lbl = new JLabel("Valor (R$)");
		lbl.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblMatricula = new JLabel("Fabricante");
		lblMatricula.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);

		txtPeso = new JTextField();
		txtPeso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				verificaCampoSomenteNumeros(arg0, txtPeso, 10);
			}
		});
		txtPeso.setColumns(10);

		JLabel lblPeso = new JLabel("Peso (Kg)");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);

		JButton btnInserir = new JButton("Inserir");

		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ProdutoController controlador = new ProdutoController();
				Produto produto = construirProduto();

			}


		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaTela();
			}
		});
		GroupLayout gl_contentPaneProduto = new GroupLayout(contentPaneProduto);
		gl_contentPaneProduto.setHorizontalGroup(
			gl_contentPaneProduto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneProduto.createSequentialGroup()
					.addGroup(gl_contentPaneProduto.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPaneProduto.createSequentialGroup()
							.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnInserir, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPaneProduto.createSequentialGroup()
							.addGroup(gl_contentPaneProduto.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lbl, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addComponent(lblPeso, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addComponent(lblNome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblMatricula, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPaneProduto.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFabricante, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPeso, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_contentPaneProduto.setVerticalGroup(
			gl_contentPaneProduto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneProduto.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneProduto.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPaneProduto.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNome)))
					.addGap(11)
					.addGroup(gl_contentPaneProduto.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFabricante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMatricula))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPaneProduto.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPaneProduto.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPeso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPeso))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPaneProduto.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnLimpar))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		contentPaneProduto.setLayout(gl_contentPaneProduto);
	


	btnInserir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			ProdutoController controlador = new ProdutoController();
			Produto produto = new Produto();
			produto.setNome(txtNome.getText() + "");
			produto.setFabricante(txtFabricante.getText() + "");
			if (produto.getPeso() > 0) {
				produto.setPeso(Double.parseDouble(txtPeso.getText()));
			}
			if(produto.getValor() > 0) {
				produto.setValor(Double.parseDouble(txtValor.getText()));
			}


			try {
				pTemp = controlador.salvar(produto);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			limpaTela();

		}
	
	});
	
	
	}
	private Produto construirProduto() {
		Produto produto = new Produto();

		produto.setNome(txtNome.getText() + "");
		produto.setFabricante(txtFabricante.getText() + "");
		produto.setValor(Double.parseDouble(txtValor.getText().replaceAll(",", ".")));
		produto.setPeso(Double.parseDouble(txtPeso.getText()));
		return null;
	}

	private void verificaCampoSomenteNumeros(KeyEvent arg0, JTextField txt, int tamanhoMaximo) {
		String tecla = arg0.getKeyChar() + "";
		String texto = txt.getText() + "";
		System.out.println(tecla);
		//		if (tecla.indexOf("0123456789,.") > -1) {
		//			txt.setText(txt.getText().replaceAll(tecla, ""));
		//
		//		}

		//		if (!((arg0.getKeyCode() > 47 && arg0.getKeyCode() < 58))) {
		txt.setText(txt.getText().replaceAll(tecla, ""));
		//		}

		if (txtValor.getText().length() > tamanhoMaximo ) {
			//			String texto = txt.getText().substring(0, tamanhoMaximo);
			txt.setText(txt.getText().substring(0, tamanhoMaximo));
		}
	}
	private void limpaTela() {
		txtNome.setText("");
		txtFabricante.setText("");
		txtPeso.setText("");
		txtValor.setText("");

	}

}
