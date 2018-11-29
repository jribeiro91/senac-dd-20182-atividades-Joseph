package aula10.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aula10.controller.FuncionarioController;
import aula10.vo.Funcionario;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Component;


public class TelaInsertFuncionario extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtnumeroMatricula;
	private JTextField txtCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInsertFuncionario frame = new TelaInsertFuncionario();
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
	public TelaInsertFuncionario() {
		setTitle("Inserir Funcion\u00E1rio");
		
		setBounds(100, 100, 384, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				String tecla = e.getKeyChar() + "";
				String texto = txtNome.getText() + "";
				if (e.getKeyCode() > 47 && e.getKeyCode() < 58) {
					
//					txtNome.setText("");
					txtNome.setText(texto.replaceAll(tecla, ""));
				};
			}
		});
		
		
		txtNome.setColumns(10);
		
		txtnumeroMatricula = new JTextField();
		txtnumeroMatricula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String tecla = e.getKeyChar() + "";
				String texto = txtnumeroMatricula.getText() + "";
				if (e.getKeyCode() > 47 && e.getKeyCode() < 58 == false) {
					
//					txtNome.setText("");
					txtnumeroMatricula.setText(texto.replaceAll(tecla, ""));
				}
				if (txtnumeroMatricula.getText().length() > 10 ) {
					String t = txtnumeroMatricula.getText().substring(0, texto.length() -1);
					txtnumeroMatricula.setText(t);
				}
			}
		});
		txtnumeroMatricula.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String tecla = e.getKeyChar() + "";
				String texto = txtCpf.getText() + "";
				if (e.getKeyCode() > 47 && e.getKeyCode() < 58 == false) {
					
					txtCpf.setText(texto.replaceAll(tecla, ""));
				}
				if (txtCpf.getText().length() > 12 ) {
					String t = txtCpf.getText().substring(0, texto.length() -1);
					txtCpf.setText(t);
				}
			}
		});
		txtCpf.setColumns(10);
		
		JLabel lblnome = new JLabel("Nome");
		lblnome.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula");
		lblMatrcula.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
//		btnInserir.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
		
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				FuncionarioController controlador =  new FuncionarioController();
				Funcionario funcionario = construirFuncionario();
												
				String mensagem = controlador.salvar(funcionario);
				JOptionPane.showMessageDialog(contentPane, mensagem);
				
				limpaTela();
			}

		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpaTela();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMatrcula, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblnome))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtnumeroMatricula, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnInserir)))
					.addContainerGap(5, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblnome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMatrcula)
						.addComponent(txtnumeroMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnLimpar))
					.addContainerGap(112, Short.MAX_VALUE))
		);
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {lblnome, lblMatrcula, lblCpf});
		contentPane.setLayout(gl_contentPane);
	}
	
	public Funcionario construirFuncionario() {
		Funcionario funcionario = new Funcionario();
		
		funcionario.setIdFuncionario(-1);
		funcionario.setNome(txtNome.getText() + "");
		funcionario.setNumeroMatricula(txtnumeroMatricula.getText() + "");
		funcionario.setCpf(txtCpf.getText() + "");

		return funcionario;
	}
	
	private void limpaTela() {
		txtNome.setText("");
		txtCpf.setText("");
		txtnumeroMatricula.setText("");
		
	}
}
