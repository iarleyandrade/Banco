package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Sigla_formacao;

public class Sigla_formacaoDAO extends ConexaoDB {

	private static final String INSERT_SIGLA_FORMACAO_SQL = "INSERT INTO sigla_formacao (sigla) VALUES (?);";
	private static final String SELECT_SIGLA_FORMACAO_BY_ID = "SELECT id, sigla FROM sigla_formacao WHERE id = ?";
	private static final String SELECT_ALL_SIGLA_FORMACAO = "SELECT * FROM sigla_formacao;";
	private static final String DELETE_SIGLA_FORMACAO_SQL = "DELETE FROM sigla_formacao WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_SIGLA_FORMACAO_SQL = "DELETE FROM sigla_formacao WHERE descricao = ?;";
	private static final String UPDATE_SIGLA_FORMACAO_SQL = "UPDATE sigla_formacao SET sigla = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM sigla_formacao;";

	public Integer count() {
		Integer count = 0;
		try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				count = rs.getInt("count");
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return count;
	}

	public Sigla_formacao insert(Sigla_formacao entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_SIGLA_FORMACAO_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, entidade.getSigla());
			

			preparedStatement.executeUpdate();

			ResultSet result = preparedStatement.getGeneratedKeys();
			if (result.next()) {
				entidade.setId(result.getLong(1));
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public Sigla_formacao findByDecricao(String descricao) {
		Sigla_formacao entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_DESCRICAO_SIGLA_FORMACAO_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new Sigla_formacao((int) rs.getLong("id"), rs.getString("sigla"));
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public Sigla_formacao findById(long id) {
		Sigla_formacao entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_SIGLA_FORMACAO_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String sigla = rs.getString("sigla");
			
				entidade = new Sigla_formacao((int) id, sigla);
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Sigla_formacao> selectAllSigla_formacoes() {
		List<Sigla_formacao> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_SIGLA_FORMACAO)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String sigla = rs.getString("sigla");
				
				entidades.add(new Sigla_formacao((int) id, sigla));
			}
			
			preparedStatement.getConnection().close();
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public void deleteSigla_formacao(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_SIGLA_FORMACAO_SQL)) {
			statement.setInt(1, id);

			statement.executeUpdate();
			statement.getConnection().close();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateSigla_formacao(Sigla_formacao entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_SIGLA_FORMACAO_SQL)) {
			statement.setString(1, entidade.getSigla());			
			statement.setLong(2, entidade.getId());
			
			statement.executeUpdate();
			statement.getConnection().close();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
