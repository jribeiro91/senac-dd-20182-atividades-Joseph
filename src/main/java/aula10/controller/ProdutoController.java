package aula10.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.plaf.metal.MetalPopupMenuSeparatorUI;

import aula10.bo.ProdutoBO;
import aula10.vo.Produto;

public class ProdutoController {

	public ArrayList<Produto> listarProdutos() {
		ProdutoBO bo = new ProdutoBO();
		return bo.listarProdutos();
	}

	
	
	public Produto salvar(Produto produto) throws SQLException {
		Produto p = null;
		String validacao = validarProduto(produto);
		ProdutoBO bo = new ProdutoBO();
		if (validacao.length() <= 1) {
			bo.inserir(produto);
			validacao += "Produto salvo com sucesso";
			JOptionPane.showMessageDialog(null, validacao);
		};
		return p;
	}

	
	
	private String validarProduto(Produto produto) {
		String validacao = "";
		ProdutoBO bo = new ProdutoBO();
		
		if (bo.buscarProdutoPorNome(produto.getNome() + "") != null) {
			validacao += "Produto já cadastrado\n";
		};
		
		if (produto.getNome().trim().equals("")) {
				validacao += "- Campo nome vazio\n";
			if (produto.getFabricante().trim().equals("")) {
				validacao += "- Campo de fabricante vazio\n";
			}
			if (produto.getPeso() == 0) {
				validacao += "- Campo peso vazio\n";
			}
			if (produto.getValor() == 0) {
				validacao += "- Campo de valor vazio\n";
			}	
		} 
		
		
		
		return validacao;
	}


//
//	public ArrayList<Produto>listaProdutosFiltroFabricante(String texto) {
//		ProdutoBO bo = new ProdutoBO()
//		return bo.buscarProdutoPorFabricante(texto);
//	}



	public ArrayList<String> buscaFabricantesProduto() {
		ProdutoBO bo = new ProdutoBO();
		return bo.buscaFabricantesProduto();
	}



	public ArrayList<String> listarFabricantesProdutos() {
		ProdutoBO bo = new ProdutoBO();
		return bo.buscaFabricantesProduto();
	}



	public boolean ExcluirProduto(int idProduto) {
		ProdutoBO bo = new ProdutoBO();
		return bo.excluirProduto(idProduto);
	}

}
