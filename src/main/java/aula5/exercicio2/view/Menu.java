package aula5.exercicio2.view;

import javax.swing.JOptionPane;

public class Menu {
	
	public void apresentarMenu() {
		

		int opcao = -1; 
		
		while (opcao!=3) {
		 	
			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(criarOpcaoMenu()));
				
			}catch(NumberFormatException ex){
				
				JOptionPane.showMessageDialog(null, "Caro usuario, o numero da opcao selecionada "
						+ "deve ser um inteiro, entre 1 e 3.");
			}
			
			switch(opcao) {
			
			case 1:{
				MenuFuncionario menuFuncionario = new MenuFuncionario();
				menuFuncionario.apresentarMenuFuncionario();
				break;
			}
			case 2:{
				MenuProduto menuProduto = new MenuProduto();
				menuProduto.apresentaMenuProduto();
				break;
			}
			case 3:{
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza?");
				if(resposta == 0) {
					JOptionPane.showMessageDialog(null, "caiu!");
				}
				break;
			}
			default: {
				JOptionPane.showMessageDialog(null, "Opcao Invalida");
				}
			}
		}
	}

	public String criarOpcaoMenu() {
		String mensagem = "menu";
		mensagem += "\n Digite uma opcao:";
		mensagem += "\n 1 - Menu Funcionario.";
		mensagem += "\n 2 - Menu Produto.";
		mensagem += "\n 3 - Sair";
		mensagem +="\n Digite a Opcao: ";
		
		return mensagem;

	}

}
