package aula10.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aula10.dao.FuncionarioDAO;
import aula10.vo.Funcionario;
import aula10.vo.Produto;

public class FuncionarioBO {
	FuncionarioDAO dao = new FuncionarioDAO();
	
	public int inserir(Funcionario funcionario)  {
		int idGerado = dao.inserir(funcionario);
		return idGerado;
	}
	
	public boolean atualizar(Funcionario funcionario) {
		boolean sucesso = dao.atualizar(funcionario, funcionario.getIdFuncionario());
		return sucesso;
	}
	
	public Funcionario buscarFuncionarioPorId(String textoId) {
		Funcionario funcionarioBuscado = dao.pesquisaPorId(Integer.parseInt(textoId));
		return funcionarioBuscado;
	}


	public ArrayList<Funcionario> listraFuncionarios() {
		ArrayList<Funcionario> funcionarios = dao.listarTodos();
		return funcionarios;
	}

	public Funcionario buscaFuncionarioPorCpf(Funcionario funcionario) {
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.buscaFUncionarioPorCpf(funcionario.getCpf() + "");
	}

	public Funcionario buscaFuncionarioPorNome(String nome) {
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.buscaFuncionarioPorNome(nome);
	}

	public boolean atualizarFuncionario(Funcionario f) {
		FuncionarioDAO dao = new FuncionarioDAO();
		return dao.atualizar(f, f.getIdFuncionario());
	}
	
}
