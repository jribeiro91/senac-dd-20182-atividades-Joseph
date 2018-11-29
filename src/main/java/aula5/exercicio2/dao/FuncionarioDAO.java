package aula5.exercicio2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import aula5.dao.Banco;
import aula5.dao.BaseDAO;
import aula5.exercicio2.vo.FuncionarioVO;


public class FuncionarioDAO extends BaseDAO<FuncionarioVO> {

	@Override
	public String getNomeTabela() {
		return "FUNCIONARIO";
	}

	@Override
	public String getNomeColunaChavePrimaria() {
		return "IDFUNCIONARIO";
	}

	@Override
	public String getNomesColunasInsert() {
		return "NOME,CPF,TELEFONE,EMAIL";
	}

	@Override
	public String getInterrogacoesInsert() {
		return "?,?,?,?";
	}

	@Override
	public void setValoresAtributosInsert(FuncionarioVO entidade, PreparedStatement preparedStmt) {
		try {
			preparedStmt.setString(1, entidade.getNome());
			preparedStmt.setString(2, entidade.getCpf());
			preparedStmt.setString(3, entidade.getTelefone());
			preparedStmt.setString(4, entidade.getEmail());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getNomeDasClolunas(FuncionarioVO entidade) {
		// SET NOME=func.getNome(), MATRICULA=func.getNumeroMatricula()...
		String clausulaSet = " NOME = ?, CPF = ?, TELEFONE = ?, EMAIL=?";
		return clausulaSet;
	}

	@Override
	public void setValoresASeremAtribuidos(FuncionarioVO entidade, PreparedStatement preparedStmt) {
		// 
		try {
			preparedStmt.setString(1, entidade.getNome());
			preparedStmt.setString(2, entidade.getCpf());
			preparedStmt.setString(3, entidade.getTelefone());
			preparedStmt.setString(4, entidade.getEmail());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public FuncionarioVO construirObjetoDoResultSet(ResultSet resultado) {
		FuncionarioVO novoFuncionario = null; // retorna null caso o resultado esteja vazio
		try {
			novoFuncionario = new FuncionarioVO();
			novoFuncionario.setIdFuncionario(resultado.getInt("IDFUNCIONARIO"));
			novoFuncionario.setNome(resultado.getString(2));
			novoFuncionario.setCpf(resultado.getString("CPF"));
			novoFuncionario.setTelefone(resultado.getString("TELEFONE"));
			novoFuncionario.setEmail(resultado.getString("EMAIL"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return novoFuncionario;

	}

	public FuncionarioVO consultarPorCPF(String cpf) {

		String query = "SELECT *FROM funcionario" + " WHERE cpf = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
		FuncionarioVO funcionario = null;
		ArrayList<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();		

		try {
			prepStmt.setString(1, cpf);
			ResultSet result= prepStmt.executeQuery();

			while (result.next()){
				funcionario = new FuncionarioVO();
				funcionario.setIdFuncionario(result.getInt("idfuncionario"));
				funcionario.setNome(result.getString("nome"));
				funcionario.setCpf(result.getString("cpf"));
				funcionario.setTelefone(result.getString(4));
				funcionario.setEmail(result.getString(5));
				
				funcionarios.add(funcionario);
			}

			JOptionPane.showMessageDialog(null, funcionarios.toString());

		} catch(SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de produtos!Causa: \n: " + e.getMessage());
		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return funcionario;
	}



}