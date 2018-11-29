package aula5.exercicio2.view;

import javax.swing.JOptionPane;

import aula5.exercicio2.dao.ProdutoDAO;
import aula5.exercicio2.vo.ProdutoVO;

public class MenuProduto {	
	
	public void apresentaMenuProduto() {
		int opcao = -1;
		
		while (opcao !=6) {
			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(criarMenuProduto()));
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "Caro usuario, o numero da opcao selecionada"
						+ "deve ser um inteiro, entre 1 e 6.");
			}
								
			
			switch(opcao) {
			case 1:
				this.cadastrarProduto();
				break;
			
			case 2:
				this.excluirProduto();
				break;
			
			case 3:
				this.atualizarProduto();
				break;
			
			case 4:
				this.consultarProduto();
				break;
			
			case 5:
				this.consultarTodosProdutos();
				break;
			
			case 6: 
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza?");
				if(resposta == 0) {
					JOptionPane.showMessageDialog(null, "Voc� foi desconectado do Menu Produto!");
				
				break;
			}
			default: {
				JOptionPane.showMessageDialog(null, "Opcaoo Invalida");
				}
			}
		}
	}	
	
	private String criarMenuProduto() {
		String mensagem = "Menu Produto";
		mensagem += "\n Digite uma opcao:";
		mensagem += "\n 1 - Cadastrar Produto.";
		mensagem += "\n 2 - Excluir Produto.";
		mensagem += "\n 3 - Alterar Cadastro de Produto.";
		mensagem += "\n 4 - Exibir Produto por ID.";
		mensagem += "\n 5 - Exibir todos os Produtos.";
		mensagem += "\n 6 - Sair.";
		mensagem +="\n Digite a Opcao: ";
		
		return mensagem;
	}	
	
	private void cadastrarProduto() {
		ProdutoVO produtoVO = new ProdutoVO();
		produtoVO.setNome(JOptionPane.showInputDialog(null, "Digite o nome do produto:"));
		produtoVO.setSecao(JOptionPane.showInputDialog(null,"Digite a secao do produto:"));
		produtoVO.setValor(Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o valor do produto:")));
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.inserir(produtoVO);
		
	}
	
	private void excluirProduto() {
		ProdutoVO produtoVO = new ProdutoVO();
		produtoVO.setIdProduto(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o"
				+ " identificador do produto a ser exclu�do:")));
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.delete(produtoVO.getIdProduto());
		
	}
	
	private void atualizarProduto() {
		ProdutoVO produtoVO = new ProdutoVO();
		produtoVO.setIdProduto(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do produto a ser atualizado:")));
		produtoVO.setNome(JOptionPane.showInputDialog(null, "Digite o nome do novo produto:"));
		produtoVO.setSecao(JOptionPane.showInputDialog(null,"Digite a se��o do novo produto:"));
		produtoVO.setValor(Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o valor do novo produto:")));
 
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.atualizar(produtoVO);
	}

	private void consultarTodosProdutos() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.listarTodosProdutos();
		
	}

	private void consultarProduto() {
		ProdutoVO produtoVO = new ProdutoVO();
		produtoVO.setIdProduto(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do produto ser a consultado.")));
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.consultarPorId(produtoVO.getIdProduto());
		JOptionPane.showMessageDialog(null, produtoDAO.toString());
	}

		

}
