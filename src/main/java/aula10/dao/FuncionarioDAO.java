package aula10.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import aula10.vo.Funcionario;

public class FuncionarioDAO extends BaseDAO<Funcionario>{
	
	public String getNomeTabela() {
		return " FUNCIONARIO ";
	}
	
	
	@Override
	public String getColunasInsert() {
		return " nome, numeroMatricula, CPF ";
	}

	
	@Override
	public String getColunaPrimaria() {
		
		return " idfuncionario ";
	}

	@Override
	public String getInterrogacoesInsert() {
		
		return " ?,?,? ";
	}


	@Override
	public String getValoresEntidadesUpdate(Funcionario entidade) {
		
		String clausulaSet = " NOME = ?, numeroMatricula = ?, CPF = ? ";
		return clausulaSet;
	}
	

	@Override
	public void setValoresAtributosInsert(Funcionario entidade, PreparedStatement prepareStmt) {
		try {
			prepareStmt.setString(1, entidade.getNome());
			prepareStmt.setString(2, entidade.getNumeroMatricula());
			prepareStmt.setString(3, entidade.getCpf());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void setValoresAtributosUpdate(Funcionario entidade, PreparedStatement prepareStmt) {
		try {
			prepareStmt.setString(1, entidade.getNome());
			prepareStmt.setString(2, entidade.getNumeroMatricula());
			prepareStmt.setString(3, entidade.getCpf());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Funcionario construirObjetoConsultado(ResultSet resultado) throws SQLException {
		Funcionario novoFuncionario = new Funcionario();
		novoFuncionario.setIdFuncionario(resultado.getInt("idfuncionario"));
		novoFuncionario.setNome(resultado.getString("NOME"));
		novoFuncionario.setNumeroMatricula(resultado.getString("numeroMatricula"));
		novoFuncionario.setCpf(resultado.getString("CPF"));
		return novoFuncionario;
	}

	
	@Override
	public ArrayList<Funcionario> listarTodos() {
		String sql = ("SELECT * FROM FUNCIONARIO " );
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			resultado = stmt.executeQuery();	
			while (resultado.next()){
				Funcionario f = new Funcionario();
				f.setIdFuncionario(resultado.getInt("idfuncionario"));
				f.setNome(resultado.getString("nome"));
				f.setNumeroMatricula(resultado.getString("numeroMatricula"));
				f.setCpf(resultado.getString("CPF"));
				funcionarios.add(f);
			}
		} catch (Exception e) {
			System.out.println("Erro : " + e.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return funcionarios;
	}


	public Funcionario buscaFUncionarioPorCpf(String cpf) {
		String sql = (" SELECT * FROM funcionario WHERE cpf = '" + cpf + "' ");
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Funcionario funcionario = null;
		
		try {
			resultado = stmt.executeQuery(sql);
			while(resultado.next()) {
				funcionario = construirObjetoConsultado(resultado);
			}
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}
		
		return funcionario;
		
	}


	@Override
	public String getColunasDelete() {
		// TODO Auto-generated method stub
		return null;
	}


	public Funcionario buscaFuncionarioPorNome(String nome) {
		String sql = ("SELECT * FROM funcionario WHERE nome = '" + nome + "' ");
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Funcionario funcionario = null;
		
		try {
			resultado = stmt.executeQuery(sql);
			while(resultado.next()) {
				funcionario = construirObjetoConsultado(resultado);
			}
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}
		
		return funcionario;
	}
	
	public boolean atualizar(Funcionario f){
		String sql = (" UPDATE funcionario SET nome = ?, numeroMatricula = ?, cpf = ? WHERE idfuncionario = '" + f.getIdFuncionario() + "';");
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		
		boolean sucessoUpdate = false;
		
		try {
			this.setValoresAtributosUpdate(f, stmt);
			int retorno = stmt.executeUpdate();
			sucessoUpdate = retorno == 1;
			
			
		}catch (SQLException e) {
			System.out.println("Deu ruim: " + e.getMessage());
		}finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		
		return sucessoUpdate;
	}
	
	
}
