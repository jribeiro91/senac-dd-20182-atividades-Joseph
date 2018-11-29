package aula5.exercicio2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import aula5.dao.Banco;
import aula5.exercicio2.vo.ProdutoVO;

public class ProdutoDAO {

	public int inserir(ProdutoVO produtoVO) {
		int novoId = -1; 

		String query = "INSERT INTO produto (nome, valor, secao)" + " VALUES (?,?,?)";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query, Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1,  produtoVO.getNome());
			prepStmt.setDouble(2,  produtoVO.getValor());
			prepStmt.setString(3,  produtoVO.getSecao());			

			prepStmt.executeUpdate();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			
			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
			}
			
			JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso!");

		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Cadastro de Produto! Causa: \n: " + e.getMessage());

		}finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return novoId;
	}

	public boolean delete(int idProduto) {
		
		boolean sucesso = false;

		String query = "DELETE FROM produto WHERE idProduto = ? ";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setInt(1,  idProduto);

			int codigoRetorno = prepStmt.executeUpdate();

			if(codigoRetorno == 1){
				sucesso = true;				
			}

			JOptionPane.showMessageDialog(null,"Produto exclu�do com sucesso!");

		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Exclus�o do Produto! Causa: \n: " + e.getMessage());
		}finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucesso;
	}

	public boolean atualizar(ProdutoVO produtoVO) {

		boolean sucesso = false;

		String query = "UPDATE PRODUTO P SET NOME=?, VALOR=?, SECAO=? " + "WHERE P.IDproduto = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setInt(4,  produtoVO.getIdProduto());
			prepStmt.setString(1,  produtoVO.getNome());
			prepStmt.setDouble(2,  produtoVO.getValor());
			prepStmt.setString(3,  produtoVO.getSecao());
			
			

			int codigoRetorno = prepStmt.executeUpdate();

			if(codigoRetorno == 1){
				sucesso = true;
			}
			JOptionPane.showMessageDialog(null,"Produto atualizado com sucesso!");

		}catch (SQLException e) {
			System.out.println("Erro ao executar Query de Atualiza��o do Produto! Causa: \n: " + e.getMessage());
		}finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucesso;

	}

	public ArrayList<ProdutoVO> listarTodosProdutos() {

		String query = "select * from produto";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		
		try {
			ResultSet resultado = prepStmt.executeQuery(query);

			while (resultado.next()) {
				ProdutoVO produto = new ProdutoVO();
				produto.setIdProduto(resultado.getInt(1));
				produto.setNome(resultado.getString("nome"));
				produto.setSecao(resultado.getString("secao"));
				produto.setValor(resultado.getDouble("valor"));

				produtos.add(produto);
			}	
			
			JOptionPane.showMessageDialog(null, produtos.toString());
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return produtos;
	}

	public ProdutoVO consultarPorId(int id) {

		String query = "SELECT * FROM produto" + " WHERE idproduto = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		ProdutoVO produto = null;				

		try {
			prepStmt.setInt(1, id);
			ResultSet result= prepStmt.executeQuery();

			while (result.next()){
				produto = new ProdutoVO();
				produto.setIdProduto(result.getInt("idproduto"));
				produto.setNome(result.getString("nome"));
				produto.setSecao(result.getString("secao"));
				produto.setValor(result.getDouble(3));
				
			}			

		} catch(SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de produtos!Causa: \n: " + e.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return produto;
	}


}
