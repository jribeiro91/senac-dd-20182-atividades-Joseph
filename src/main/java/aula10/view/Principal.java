package aula10.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JPanel painel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(400,200,800,600);
		
		TelaInsertFuncionario telaInsertFuncionario = new TelaInsertFuncionario();
		TelaInserirProduto telaInsertProduto = new TelaInserirProduto();
//		TelaExcluirProduto telaExcluirProduto = new TelaExcluirProduto();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProduto = new JMenu("Produto");
		mnProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		mnProduto.setIcon(null);
		menuBar.add(mnProduto);
		
		JMenuItem btnBuscarProduto = new JMenuItem("Buscar Produto");
		
		
		mnProduto.add(btnBuscarProduto);
		JMenuItem btnInserirProduto = new JMenuItem("Inserir Produto");
		mnProduto.add(btnInserirProduto);
		btnInserirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("teste");
				contentPane = new PainelInserirProduto();
				setContentPane(contentPane);
				revalidate();
			
				
//				layeredPane.removeAll();
//				layeredPane.repaint();
//				
//				TelaInserirProduto inProduto = new TelaInserirProduto();
//				layeredPane.add(inProduto);
//				inProduto.setLocation(0, 0);
//
//				inProduto.show();
//				
			}
		});
		

		JMenu mnInserir = new JMenu("Funcion\u00E1rio");
		mnInserir.setIcon(null);
		menuBar.add(mnInserir);
		
		JMenuItem btnInserirFuncionario = new JMenuItem("Inserir Funcion\u00E1rio");
		btnInserirFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane = new PainelInserirFuncionario();
				setContentPane(contentPane);
				revalidate();
			}
		});
		mnInserir.add(btnInserirFuncionario);
		JMenuItem btnBuscarFuncionario = new JMenuItem("Buscar Funcion\u00E1rio");
		mnInserir.add(btnBuscarFuncionario);
		
		
		
		btnBuscarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane = new PainelBuscaFuncionarios();
				setContentPane(contentPane);
				revalidate();
				
				
//				TelaBuscaFuncionarios tBuscaFuncionario = new TelaBuscaFuncionarios();
//				tBuscaFuncionario.setLocation(0, 0);
//
//				layeredPane.add(tBuscaFuncionario);
//				//TODO teste
//				TesteTelaFrame teste = new TesteTelaFrame();
//				painel.removeAll();
//				painel.add(teste);
//				
//				setContentPane(painel);
//				
//				TelaBuscaFuncionarios tela = new TelaBuscaFuncionarios();
//				tela.setVisible(true);
			}
		});
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);
		
		JLayeredPane layeredPane = new JLayeredPane();

//		JMenuItem btnInserirFuncionario;
//		mnInserir.add(btnInserirFuncionario);
//		
//		
//		JMenuItem btnFuncionario;
//		mnInserir.add(btnFuncionario);
		
		GroupLayout gl_painel = new GroupLayout(painel);
		gl_painel.setHorizontalGroup(
			gl_painel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_painel.createSequentialGroup()
					.addContainerGap(592, Short.MAX_VALUE)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		gl_painel.setVerticalGroup(
			gl_painel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painel.createSequentialGroup()
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(393, Short.MAX_VALUE))
		);
		painel.setLayout(gl_painel);
		
		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);
		
		JMenuItem btnManual = new JMenuItem("Manual");
		btnManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane = new PainelSobreManual();
				setContentPane(contentPane);
				revalidate();
				
	
			}
		});
		mnSobre.add(btnManual);
		
		JMenuItem btnAjuda = new JMenuItem("Ajuda");
		
		mnSobre.add(btnAjuda);
		
		JMenuItem btnTeste = new JMenuItem("Autores");
		
		mnSobre.add(btnTeste);
		
		
		
		
		
		btnBuscarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane = new PainelBuscaProduto();
				setContentPane(contentPane);
				revalidate();
				
//				layeredPane.removeAll();
//				layeredPane.repaint();
//				TelaBuscaProdutos tBuscaProdutos = new TelaBuscaProdutos();
//				
//				layeredPane.add(tBuscaProdutos);
//				tBuscaProdutos.setLocation(0, 0);
//				tBuscaProdutos.show();		
				
		
			}
		});

		
		btnAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane = new PainelSobreAjuda();
				setContentPane(contentPane);
				revalidate();
				
				
//				layeredPane.removeAll();
//				layeredPane.repaint();
//
//				TelaAjuda ajuda = new TelaAjuda();
//				
//				layeredPane.add(ajuda);
//				ajuda.setLocation(0, 0);
//
//				ajuda.show();
				
				
			}
		});
		btnTeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane = new PainelSobreAutores();
				setContentPane(contentPane);
				revalidate();
				
//				
//				PainelExcuirProduto painel = new PainelExcuirProduto();
//				layeredPane.removeAll();
//				layeredPane.add(painel);
//				layeredPane.repaint();
				
				
				
			}
		});

	}

}
