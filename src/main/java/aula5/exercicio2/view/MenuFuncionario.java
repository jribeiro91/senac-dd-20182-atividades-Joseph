package aula5.exercicio2.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import aula5.exercicio2.dao.FuncionarioDAO;
import aula5.exercicio2.vo.FuncionarioVO;

public class MenuFuncionario{
	
	public void apresentarMenuFuncionario() {
	
		int opcao = -1;
		
		while (opcao !=6) {
			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(criarMenuFuncionario()));
				
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "O n�mero digitado deve ser um inteiro entre 1 e 5;");
			}
			switch(opcao) {
			case 1:{
				this.cadastrarFuncionario();
				break;
			}
			case 2:{
				this.excluirFuncionario();
				break;
			}
			case 3:{
				this.atualizarFuncionario();
				break;
			}
			case 4:{
				this.exibirTodosFuncionarios();
				break;
			}
			case 5:{
				this.consultarFuncionarioPorCPF();
				break;
			}
			case 6: {
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza?");
				if(resposta == 0) {
					JOptionPane.showMessageDialog(null, "Voco foi desconectado do Menu Funcionurio!");
				}
				break;
			}
			default: {
				JOptionPane.showMessageDialog(null, "Opcao Invalida");
				}
			}
		}
	}
	
		private String criarMenuFuncionario() {
			String mensagem = "Menu Funcionario";
			mensagem += "\n Digite uma opcao:";
			mensagem += "\n 1 - Cadastrar Funcionario.";
			mensagem += "\n 2 - Excluir Funcionario.";
			mensagem += "\n 3 - Alterar Cadastro de Funcionario.";
			mensagem += "\n 4 - Exibir Todos os Funcionario.";
			mensagem += "\n 5 - Exibir Funcion�rio por CPF.";
			mensagem += "\n 6 - Sair.";
			mensagem +="\n Digite a Opcao: ";
			
			return mensagem;
		}	
	
	private void cadastrarFuncionario() {
		
		FuncionarioVO funcionarioVO = new FuncionarioVO();
			
		funcionarioVO.setNome(JOptionPane.showInputDialog(null, "Digite o nome do funcionario."));
		funcionarioVO.setCpf(JOptionPane.showInputDialog(null,"Digite o CPF."));
		funcionarioVO.setTelefone(JOptionPane.showInputDialog(null,"Digite o telefone."));
		funcionarioVO.setEmail(JOptionPane.showInputDialog(null,"Digite o e-mail."));
			
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			
		funcionarioDAO.inserir(funcionarioVO);
		JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso!");
		
		}

	private void excluirFuncionario() {
	
		FuncionarioVO funcionarioVO = new FuncionarioVO();
		funcionarioVO.setIdFuncionario(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do funcionario a ser excluido.")));
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();		
		
		try {
			funcionarioDAO.excluir(funcionarioVO.getIdFuncionario());
			JOptionPane.showMessageDialog(null, "Funcion�rio excluido com sucesso!");
		} catch (SQLException e) {
			
			e.printStackTrace(); //O que sigbifica essa Exception?
		}
		}

	private void atualizarFuncionario() {
		
		FuncionarioVO funcionarioVO = new FuncionarioVO();		
		funcionarioVO.setIdFuncionario(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do funcionario que sera atualizado.")));
		funcionarioVO.setNome(JOptionPane.showInputDialog(null, "Digite o novo nome do funcionario."));
		funcionarioVO.setCpf(JOptionPane.showInputDialog(null,"Digite o novo CPF do funcionario."));
		funcionarioVO.setTelefone(JOptionPane.showInputDialog(null,"Digite o novo telefone."));
		funcionarioVO.setEmail(JOptionPane.showInputDialog(null,"Digite o novo e-mail."));
	 
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		try {
			
			funcionarioDAO.atualizar(funcionarioVO, funcionarioVO.getIdFuncionario());

			
			JOptionPane.showMessageDialog(null, "Funcionario atualizado com sucesso!");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
	
	private void exibirTodosFuncionarios() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		try {
			List<FuncionarioVO> funcionarios = funcionarioDAO.listarTodos();
			JOptionPane.showMessageDialog(null, funcionarios);			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	private void consultarFuncionarioPorCPF() {
	     
		FuncionarioVO funcionarioVO = new FuncionarioVO();
		funcionarioVO.setCpf(JOptionPane.showInputDialog(null, "Digite o CPF do funcionario a ser consultado."));
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		funcionarioDAO.consultarPorCPF(funcionarioVO.getCpf());
	}

	

}
