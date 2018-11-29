package aula10.controller;

import java.util.ArrayList;
import java.util.List;

import aula10.bo.FuncionarioBO;
import aula10.vo.Funcionario;
import aula10.vo.Produto;

public class FuncionarioController {
	
	FuncionarioBO bo = new FuncionarioBO();

	public String salvar(Funcionario funcionario) {
		String validacao = validarFuncioanrio(funcionario);
		
		if (validacao == "") {
			if (funcionario.getIdFuncionario() > 0) {
				//ATUALIZAR
				if (bo.atualizar(funcionario)) {
					validacao = "Funcionário atualizado com sucesso";
				} else {
					validacao = "Erro au atualizar o funcionário";
				}
			
			} else {
				 if (bo.inserir(funcionario) > 0) {
					 validacao = "Funcionário cadastrado com sucesso";
				 } else {
					 validacao = "Erro ao cadastrar Funcionário";
				 }
			}
			
			
		}
		return validacao;
		
	}

	private String validarFuncioanrio(Funcionario funcionario) {
		String validacao = "";
		FuncionarioBO bo = new FuncionarioBO();
		
		if (bo.buscaFuncionarioPorCpf(funcionario) != null) {
			validacao += "- CPF já cadastrado/n";
		
		if (funcionario == null) {
			validacao = "- Funcionário está nulo";
		} else {
			if (funcionario.getNome().trim().equals("")) {
				validacao += " - Nome é obrigatório\n";
			}
			if (funcionario.getCpf().trim().equals("")) {
				validacao += " - CPF é obrigatório\n";
			} 
		
			if (funcionario.getNumeroMatricula().trim().equals("")) {
				validacao += " - Matrícula é obrigatória\n";
			}
		}
		}
		return validacao;
	}

	public ArrayList<Funcionario> listarFuncionarios() {
		return bo.listraFuncionarios();	
	}

	public Funcionario buscaFuncionarioPorNome(String nome) {
		FuncionarioBO bo = new FuncionarioBO();
		return bo.buscaFuncionarioPorNome(nome);
		
	}

	public boolean atualizarFuncionario(Funcionario f) {
		FuncionarioBO bo = new FuncionarioBO();
		return bo.atualizarFuncionario(f);
		
	}

}
