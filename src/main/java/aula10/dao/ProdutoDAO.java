package aula10.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import aula10.vo.Funcionario;
import aula10.vo.Produto;

public class ProdutoDAO extends BaseDAO<Produto>{

	@Override
	public String getColunaPrimaria() {
		return " idproduto ";
	}

	@Override
	public String getValoresEntidadesUpdate(Produto entidade) {
		String clausulaSet = (" idproduto = ?, nome = ? , fabricante = ?, valor = ?, peso = ? ");
		return clausulaSet;
	}

	@Override
	public String getInterrogacoesInsert() {
		return " ?,?,?,? ";
	}

	@Override
	public String getNomeTabela() {
		return " PRODUTO ";
	}
	
	@Override
	public String getColunasInsert() {
		return " nome, fabricante, valor, peso ";
	}
	
	@Override
	public String getColunasDelete() {
		return " idproduto ";
	}

	@Override
	public Produto construirObjetoConsultado(ResultSet resultado) throws SQLException {
		Produto novoProduto = new Produto();
		try {
			
			novoProduto.setIdProduto(resultado.getInt("idproduto"));
			novoProduto.setNome(resultado.getString("nome"));
			novoProduto.setFabricante(resultado.getString("fabricante"));
			novoProduto.setValor(resultado.getDouble("valor"));
			novoProduto.setPeso(resultado.getDouble("peso"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return novoProduto;
	}

	@Override
	public void setValoresAtributosInsert(Produto entidade, PreparedStatement prepareStm) {
		try {
			prepareStm.setString(1, entidade.getNome());
			prepareStm.setString(2, entidade.getFabricante());
			prepareStm.setDouble(3, entidade.getValor());
			prepareStm.setDouble(4, entidade.getPeso());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void setValoresAtributosUpdate(Produto entidade, PreparedStatement prepareStm) {
		try {
			prepareStm.setString(1, entidade.getNome());
			prepareStm.setString(2, entidade.getFabricante());
			prepareStm.setDouble(3, entidade.getValor());
			prepareStm.setDouble(4, entidade.getPeso());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public Produto buscaProdutoPorNome(String nome) {
		String sql = ("SELECT * FROM produto WHERE nome = '" + nome + " '");
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Produto produto = null;
		
		try {
			resultado = stmt.executeQuery();
			while(resultado.next()) {
				produto = construirObjetoConsultado(resultado);
			}
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}
		
		return produto;
	}

	public ArrayList<String> buscaFabricantesProdutos() {
		String sql = (" SELECT fabricante FROM produto group by fabricante");
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		
		ArrayList<String> fabricantes= new ArrayList<String>();
		
		try {
			resultado = stmt.executeQuery();
			while(resultado.next()) {
				String fabricante = resultado.getString(1);
				fabricantes.add(fabricante);
			}
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}
		
		return fabricantes;
	}

	
//	public Produto inserir(Produto p) {
//		Produto pRes = null;
//		String sql = ("INSERT INTO " + getNomeTabela() + " ( " + getColunasInsert() + " ) VALUES ( " + getInterrogacoesInsert() + " ) ");
//		
//		Connection conn = Banco.getConnection();
//		PreparedStatement prepareStm = Banco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);
//		int idEntidade = -1;
//		
//		try {
//			this.setValoresAtributosInsert(p, prepareStm);
//			prepareStm.executeUpdate();
//			ResultSet rs = prepareStm.getGeneratedKeys();
//			
//			if(rs.next()) {
//				pRes.setIdProduto(rs.getInt("idproduto"));
////				idEntidade = rs.getInt(1);
//			} 
//			
//		} catch (SQLException e) {
//			System.out.println("Erro " + e.getMessage());
//		} finally {
//			Banco.closeStatement(prepareStm);
//			Banco.closeConnection(conn);
//		}
//		
//		return p;
//	}
}
