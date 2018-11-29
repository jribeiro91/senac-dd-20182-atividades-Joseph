package aula10.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import aula10.dao.ProdutoDAO;
import aula10.vo.Produto;

public class ProdutoBO {
	
	ProdutoDAO dao = new ProdutoDAO();
	
	public int inserir(Produto produto) throws SQLException {
		return dao.inserir(produto);
	}
	
	public Produto buscarProdutoPorNome(String nome) {
		ProdutoDAO dao = new ProdutoDAO();
		Produto produto = dao.buscaProdutoPorNome(nome);
		return produto;
	}

	public boolean atualizar(Produto produto) throws SQLException {
		boolean sucesso = dao.atualizar(produto, produto.getIdProduto());
		return sucesso;
	}
	
	public Produto buscarProdutoPorId(String textoId) throws NumberFormatException, SQLException {
		Produto produtoBuscado = dao.pesquisaPorId(Integer.parseInt(textoId));
		return produtoBuscado;
	}

	public ArrayList<Produto> listarProdutos() {
		ProdutoDAO dao = new ProdutoDAO();
		return dao.listarTodos();
	}

	public ArrayList<String> buscaFabricantesProduto() {
		ProdutoDAO dao = new ProdutoDAO();
		
		return dao.buscaFabricantesProdutos();
	}

	public boolean excluirProduto(int idProduto) {
		ProdutoDAO dao = new ProdutoDAO();
		return dao.excluir(idProduto);
	}
	
}
