package aula04.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import aula04.vo.Caminhao;
import aula04.vo.Carro;
import aula04.vo.Moto;


public class Menu {

	private static final int OPCAO_CADASTRAR_CARRO = 1;
	private static final int OPCAO_CADASTRAR_CAMINHAO = 3;
	private static final int OPCAO_CADASTRAR_MOTO = 2;
	private static final int OPCAO_LISTAR_CARRO_OU_CAMINHAO = 4;
	private static final int OPCAO_LISTAR_MOTOS = 5;
	private static final int OPCAO_SAIR = 6;

	private static List<Carro> carros = new ArrayList<Carro>();
	private static List<Caminhao> caminhoes = new ArrayList<Caminhao>();
	private static List<Moto> motos = new ArrayList<Moto>();

	public void apresentaMenu() {
		try {
			int opcaoMenu = -1;

			while (opcaoMenu != OPCAO_SAIR) {
				String mensagemMenu = construirMenu();
				String opcao = JOptionPane.showInputDialog(null, mensagemMenu, "Título",
						JOptionPane.INFORMATION_MESSAGE);
				opcaoMenu = Integer.parseInt(opcao);

				switch (opcaoMenu) {
				case OPCAO_CADASTRAR_CARRO:
					cadastrarCarro();
					apresentaMenu();
					break;
				case OPCAO_CADASTRAR_CAMINHAO:
					cadastrarCaminhao();
					apresentaMenu();
					break;
				case OPCAO_CADASTRAR_MOTO:
					cadastrarMoto();
					apresentaMenu();
					break;
				case OPCAO_LISTAR_CARRO_OU_CAMINHAO:
					mostrarCarroOuCaminhao();
					apresentaMenu();
					break;
				case OPCAO_LISTAR_MOTOS:
					mostrarMotos();
					apresentaMenu();
					break;
				case OPCAO_SAIR:
					break;
				default:
					mostrarMensagemOpcaoInvalida();
					apresentaMenu();
					break;
				}
			}
			mostrarMensagemSaida();
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
	}

	private void mostrarMensagemOpcaoInvalida() {
		JOptionPane.showMessageDialog(null, "Opção inválida");

	}

	private void mostrarMensagemSaida() {
		Object[] options = { "Confirmar", "Cancelar" };
		JOptionPane.showOptionDialog(null, "Clique Confirmar para continuar", "Informação", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

	}

	private void mostrarMotos() {
		String chassiInformado = JOptionPane.showInputDialog("Informe o chassi");

		Moto moto = obterMotoPorChassi(chassiInformado);
		
		String mensagem = "";

		if (moto != null) {
			mensagem = moto.toString();
		} else {
			mensagem = "Veículo não encontrado";
		}

		JOptionPane.showMessageDialog(null, mensagem);
	}

	private void mostrarCarroOuCaminhao() {
		String chassiInformado = JOptionPane.showInputDialog("Informe o chassi");

		Carro carro = obterCarroPorChassi(chassiInformado);
		Caminhao caminhao = obterCaminhaoPorChassi(chassiInformado);

		String mensagem = "";

		if (carro != null) {
			mensagem = carro.toString();
		} else if (caminhao != null) {
			mensagem = caminhao.toString();
		} else {
			mensagem = "Veículo não encontrado";
		}

		JOptionPane.showMessageDialog(null, mensagem);
	}

	private Caminhao obterCaminhaoPorChassi(String chassiInformado) {
		Caminhao caminhaoComChassiBuscado = null;
			for (Caminhao ca : caminhoes) {
				if (ca.getChassi().equals(chassiInformado)) {
					caminhaoComChassiBuscado = ca;
					break;
				}
			}

			return caminhaoComChassiBuscado;
		}
	

	private Carro obterCarroPorChassi(String chassiInformado) {

		Carro carroComChassiBuscado = null;
		for (Carro c : carros) {
			if (c.getChassi().equals(chassiInformado)) {
				carroComChassiBuscado = c;
				break;
			}
		}

		return carroComChassiBuscado;
	}

	private Moto obterMotoPorChassi(String chassiInformado) {

		Moto motoComChassiBuscado = null;
		for (Moto m :motos) {
			if (m.getChassi().equals(chassiInformado)) {
				motoComChassiBuscado = m;
				break;
			}
		}

		return motoComChassiBuscado;
	}
	
	private void cadastrarMoto() {
		int id = -1;
		try {
			id = Integer.parseInt(JOptionPane.showInputDialog("Informe o identificador:"));
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Chassi deve ser um número inteiro", "Atenção",
					JOptionPane.ERROR_MESSAGE, null);
		}
		String modelo = JOptionPane.showInputDialog("Informe o modelo:");
		String chassi = JOptionPane.showInputDialog("Informe o chassi:");
		String marca = JOptionPane.showInputDialog("Informe o marca:");

		if (id == -1 || modelo == null || chassi == null || marca == null) {
			// Cancelar no JOptionPane retorna uma string nula
			apresentaMenu();
		} else {
			Moto novoMoto = new Moto(modelo, marca, id, chassi);

			if (listaMotosNaoContem(id)) {
				motos.add(novoMoto);
			} else {
				JOptionPane.showMessageDialog(null, "Moto já cadastrada", "Atenção", JOptionPane.ERROR_MESSAGE, null);
			}
		}
	}

	private boolean listaMotosNaoContem(int idNovoMoto) {
		boolean naoContem = true;

		for (Moto c : motos) {
			if (c.getIdVeiculo() == idNovoMoto) {
				naoContem = false;
				break;
			}
		}
		return naoContem;
	}

	private void cadastrarCaminhao() {
		int id = -1;
		try {
			id = Integer.parseInt(JOptionPane.showInputDialog("Informe o identificador:"));
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Chassi deve ser um número inteiro", "Atenção",
					JOptionPane.ERROR_MESSAGE, null);
		}
		String modelo = JOptionPane.showInputDialog("Informe o modelo:");
		String chassi = JOptionPane.showInputDialog("Informe o chassi:");
		String marca = JOptionPane.showInputDialog("Informe o marca:");

		if (id == -1 || modelo == null || chassi == null || marca == null) {
			// Cancelar no JOptionPane retorna uma string nula
			apresentaMenu();
		} else {
			Caminhao novoCaminhao = new Caminhao(id, modelo, chassi, marca);

			if (listaCaminhaoNaoContem(id)) {
				caminhoes.add(novoCaminhao);
			} else {
				JOptionPane.showMessageDialog(null, "Caminhão já cadastrado", "Atenção", JOptionPane.ERROR_MESSAGE,
						null);
			}
		}

	}

	private boolean listaCaminhaoNaoContem(int idNovoCaminhao) {
		boolean naoContem = true;

		for (Caminhao c : caminhoes) {
			if (c.getIdVeiculo() == idNovoCaminhao) {
				naoContem = false;
				break;
			}
		}

		return naoContem;
	}

	private void cadastrarCarro() {
		int id = -1;
		try {
			id = Integer.parseInt(JOptionPane.showInputDialog("Informe o identificador:"));
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Chassi deve ser um número inteiro", "Atenção",
					JOptionPane.ERROR_MESSAGE, null);
		}
		String modelo = JOptionPane.showInputDialog("Informe o modelo:");
		String chassi = JOptionPane.showInputDialog("Informe o chassi:");
		String marca = JOptionPane.showInputDialog("Informe o marca:");

		if (id == -1 || modelo == null || chassi == null || marca == null) {
			// Cancelar no JOptionPane retorna uma string nula
			apresentaMenu();
		} else {
			Carro novoCarro = new Carro(modelo, marca, id, chassi);

			if (listaCarrosNaoContem(id)) {
				carros.add(novoCarro);
			} else {
				JOptionPane.showMessageDialog(null, "Carro já cadastrado", "Atenção", JOptionPane.ERROR_MESSAGE, null);
			}
		}
	}

	private boolean listaCarrosNaoContem(int idNovoCarro) {
		boolean naoContem = true;

		for (Carro c : carros) {
			if (c.getIdVeiculo() == idNovoCarro) {
				naoContem = false;
				break;
			}
		}

		return naoContem;
	}

	private String construirMenu() {
		String mensagem = "Exercício 4";
		mensagem += "\n Opções:";
		mensagem += "\n 1 - Cadastrar carro";
		mensagem += "\n 2 - Cadastrar moto";
		mensagem += "\n 3 - Cadastrar caminhão";
		mensagem += "\n 4 - Exibir caminhão e carro por chassi";
		mensagem += "\n 5 - Exibir todas as motos";
		mensagem += "\n 6 - Sair";
		mensagem += "\n Digite a Opção: ";

		return mensagem;
	}

}
