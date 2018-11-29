/**
 * 
 */
package aula5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Classe abstrata com os m�todos m�nimos para qualquer
 * Data Access Object (DAO).
 * @author Vilmar C�sar Pereira J�nior
 * @param T: o tipo da entidade (ou VO) associada ao DAO espec�fico
 */

public abstract class BaseDAO<T> {

	private static final int CODIGO_RETORNO_SUCESSO_SQL = 1;

	/**
	 * @param entidade: a entidade do tipo informado a ser persistida
	 * @return
	 * @throws SQLException
	 */

	public int inserir(T entidade) {

		// SQL: INSERT INTO NOMETABELA (atributo1, atributo2,... atributoN)
		// VALUES (?,?,...?)

		String query = " INSERT INTO " + getNomeTabela() +
				" ( " + getNomesColunasInsert() + " ) VALUES ( "
				+ getInterrogacoesInsert() + " ) ";

		Connection conn = Banco.getConnection();
		PreparedStatement preparedStmt = Banco.getPreparedStatement(conn, query,
				Statement.RETURN_GENERATED_KEYS);

		int idEntidadeSalva = -1;
		try {
			// Este m�todo DEVE ser implementado na classe concreta

			this.setValoresAtributosInsert(entidade, preparedStmt);
			boolean sucessoInsert = preparedStmt.execute();
			if (sucessoInsert) {
				ResultSet rs = preparedStmt.getGeneratedKeys();
				idEntidadeSalva = rs.getInt(1);				
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir " + entidade.getClass().toString() + "\n"
					+ e.getMessage());
		} finally {
			Banco.closeStatement(preparedStmt);
			Banco.closeConnection(conn);
		}
		return idEntidadeSalva;
	}

	public boolean atualizar(T entidade, int idEntidade) throws SQLException {
		// SQL: UPDATE NOMETABELA
		// SET atributo1 = valor1, atributo2 = valor 2,... atributoN = valorN) WHERE
		// IDTABELA = idEntidade
		String sql = "UPDATE " + getNomeTabela() +
				" SET " + getNomeDasClolunas(entidade)
				+ " WHERE " + getNomeColunaChavePrimaria() + " = " + idEntidade;
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		boolean sucessoUpdate = false;

		try {
			// Este m�todo DEVE ser implementado na classe concreta
			this.setValoresASeremAtribuidos(entidade, stmt);
			int retorno = stmt.executeUpdate();
			sucessoUpdate = (retorno == CODIGO_RETORNO_SUCESSO_SQL);
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar o registro com id = " + idEntidade + "da entidade "
					+ entidade.getClass().toString() + "\n"
					+ e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return sucessoUpdate;
	}

	public boolean excluir(int idEntidade) throws SQLException {

		// SQL: DELETE FROM NomeTabela WHERE ID = idEntidade

		String sql = "DELETE FROM " + getNomeTabela() + " WHERE " + getNomeColunaChavePrimaria() + " = " + idEntidade;
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);

		boolean sucessoDelete = false;
		try {
			int resultado = stmt.executeUpdate(sql);
			sucessoDelete = (resultado == CODIGO_RETORNO_SUCESSO_SQL);
		} catch (SQLException e) {
			
			System.out.println("Erro ao atualizar o registro com id = " + idEntidade + "da entidade "
					+ this.getClass().toString() + "\n"
					+ e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return sucessoDelete;
	}

//	public T pesquisarPorId(int idEntidade) throws SQLException {
//
//		// SQL: SELECT * FROM NOMETABELA WHERE ID = idEntidade
//		String sql = "SELECT * FROM " + getNomeTabela() + " WHERE " + getNomeColunaChavePrimaria() + " = " + idEntidade;
//		Connection conn = Banco.getConnection();
//		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
//		ResultSet resultado = null;
//
//		T objetoConsultado = null;
//		try {
//			resultado = stmt.executeQuery(sql);
//			while (resultado.next()) {
//				objetoConsultado = construirObjetoDoResultSet(resultado);
//			}
//		} catch (SQLException e) {
//			System.out.println("Erro ao consultar o registro com id = " + idEntidade + "da entidade "
//					+ this.getClass().toString());
//		} finally {
//			Banco.closeResultSet(resultado);
//			Banco.closeStatement(stmt);
//			Banco.closeConnection(conn);
//		}
//		return objetoConsultado;
//	}

	public List<T> listarTodos() throws SQLException {

		String sql = "SELECT * FROM " + getNomeTabela();
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);

		ResultSet resultado = null;
		ArrayList<T> listaEntidades = new ArrayList<T>();

		try {
			resultado = stmt.executeQuery(sql);
			
			while (resultado.next()) {
				
				T objetoConsultado = construirObjetoDoResultSet(resultado);
				listaEntidades.add(objetoConsultado);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar todos os objetos da entidade" + this.getClass().toString());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaEntidades;
	}

	/**
	 * Daqui para baixo...
	 * M�todos abstratos, que obrigatoriamente ser�o implementados nas classes concretas.
	 * Classe concreta: subclasse da classe abstrata que pode ter objeto constru�do.
	 */

	/**
	 * @return String o nome da tabela criada no BD.
	 */

	public abstract String getNomeTabela();

	/**
	 * @return String o nome da PK criada no BD.
	 */

	public abstract String getNomeColunaChavePrimaria();

	/**
	 * Constr�i uma string formada pelos nomes das colunas (do BD) do INSERT separados por v�rgula.
	 * @return String os nomes das colunas separados por v�rgula.
	 */

	public abstract String getNomesColunasInsert();

	/**
	 * Constr�i uma string formada por pontos de interroga��o separados por v�rgula, onde cada interroga��o representa um das colunas que constam na cl�usula INSERT ver
	 * ({@link #getNomesColunasInsert()}
	 * @return String o texto com as interroga��es separadas por v�rgula.
	 */

	public abstract String getInterrogacoesInsert();

	/**
	 * Preenche os valores das colunas do insert um a um.
	 * Obs.: A implementa��o deve levar em conta o tipo exato da coluna e da entidade, e tamb�m colocar aspas simples caso o valor seja uma String.
	 * @param preparedStmt o objeto que det�m a consulta SQL criada.
	 */

	public abstract void setValoresAtributosInsert(T entidade, PreparedStatement preparedStmt);

	/**
	 * Constr�i uma string com os pares chave-valor da cl�sula SET de um UPDATE, onde:
	 * chave = nome da coluna, valor = valor que ser� atualizado na coluna (vem do objeto em quest�o)
	 * Obs.: A implementa��o deve levar em conta o tipo exato da coluna e da entidade, e tamb�m colocar aspas simples caso o valor seja uma String.
	 * @return String a cl�sula SET preenchida por completo.
	 */

	public abstract String getNomeDasClolunas(T entidade);

	public abstract void setValoresASeremAtribuidos(T entidade, PreparedStatement stmt);

	/**
	 * Converte um resultSet para um objeto do tipo T.
	 * @param resultado objeto do tipo ResultSet, que armazena as tuplas retornadas em uma determinada consulta.
	 * @return T o objeto da classe concreta, com seus atributos preenchidos com valores oriundos do resultado.
	 */

	public abstract T construirObjetoDoResultSet(ResultSet resultado);

	// TODO e como listar com filtros? Veremos mais � frente ;)

}