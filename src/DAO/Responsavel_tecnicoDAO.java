package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Responsavel_tecnico;

public class Responsavel_tecnicoDAO extends ConexaoDB {

	private static final String INSERT_RESPONSAVEL_TECNICO_SQL = "INSERT INTO responsavel_tecnico (nome, formacao, conselho, sigla_formacao_id) VALUES (?, ?, ?, ?);";
	private static final String SELECT_RESPONSAVEL_TECNICO_BY_ID = "SELECT id, nome, formacao, conselho, sigla_formacao_id FROM responsavel_tecnico WHERE id = ?";
	private static final String SELECT_ALL_RESPONSAVEL_TECNICO = "SELECT * FROM responsavel_tecnico;";
	private static final String DELETE_RESPONSAVEL_TECNICO_SQL = "DELETE FROM responsavel_tecnico WHERE id = ?;";
	//private static final String BUSCAR_POR_DESCRICAO_RESPONSAVEL_TECNICO_SQL = "DELETE FROM responsavel_tecnico WHERE descricao = ?;";
	private static final String UPDATE_RESPONSAVEL_TECNICO_SQL = "UPDATE responsavel_tecnico SET nome = ?, formacao = ?, conselho = ?, sigla_formacao_id = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM responsavel_tecnico;";

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

	public Responsavel_tecnico insert(Responsavel_tecnico entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_RESPONSAVEL_TECNICO_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, entidade.getNome());
			preparedStatement.setString(2, entidade.getFormacao());
			preparedStatement.setString(3, entidade.getConselho());
			preparedStatement.setInt(4, entidade.getSigla_formacao_id());
			

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

	/* public Responsavel_tecnico findByDecricao(String descricao) {
		Responsavel_tecnico entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_DESCRICAO_RESPONSAVEL_TECNICO_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new Responsavel_tecnico((int) rs.getLong("id"), rs.getString("nome"), rs.getString("formacao"), rs.getString("conselho"), rs.getString("sigla_formacao"), rs.getInt("sigla_formacao_id"));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}
*/
	public Responsavel_tecnico findById(long id) {
		Responsavel_tecnico entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_RESPONSAVEL_TECNICO_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String nome = rs.getString("nome");
				String formacao = rs.getString("formacao");
				String conselho = rs.getString("conselho");
				String sigla_formacao = rs.getString("sigla_formacao");
				int sigla_formacao_id = rs.getInt("sigla_formacao_id");
				entidade = new Responsavel_tecnico((int) id, nome, formacao, conselho, sigla_formacao, sigla_formacao_id);
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Responsavel_tecnico> selectAllResponsavel_tecnicos() {
		List<Responsavel_tecnico> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_RESPONSAVEL_TECNICO)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String nome = rs.getString("nome");
				String formacao = rs.getString("formacao");
				String conselho = rs.getString("conselho");
				String sigla_formacao = rs.getString("sigla_formacao");
				int sigla_formacao_id = rs.getInt("sigla_formacao_id");
				entidades.add(new Responsavel_tecnico((int) id, nome, formacao, conselho, sigla_formacao, sigla_formacao_id));
			}
			
			preparedStatement.getConnection().close();
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public void deleteResponsavel_tecnico(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_RESPONSAVEL_TECNICO_SQL)) {
			statement.setInt(1, id);

			statement.executeUpdate();
			statement.getConnection().close();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateResponsavel_tecnico(Responsavel_tecnico entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_RESPONSAVEL_TECNICO_SQL)) {
			statement.setString(1, entidade.getNome());
			statement.setString(2, entidade.getFormacao());
			statement.setString(3, entidade.getConselho());
			statement.setLong(4, entidade.getSigla_formacao_id());
			statement.setLong(5, entidade.getId());
			
			statement.executeUpdate();
			statement.getConnection().close();
			

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
