package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Habilitacao_exame;

public class Habilitacao_exameDAO extends ConexaoDB {

	private static final String INSERT_HABILITACAO_EXAME_SQL = "INSERT INTO habilitacao_exame (custo, observacao, tipo_exame_id, laboratorio_id) VALUES (?, ?, ?, ?);";
	private static final String SELECT_HABILITACAO_EXAME_BY_ID = "SELECT id, custo, observacao, tipo_exame_id, laboratorio_id FROM habilitacao_exame WHERE id = ?";
	private static final String SELECT_ALL_HABILITACAO_EXAME = "SELECT * FROM habilitacao_exame;";
	private static final String DELETE_HABILITACAO_EXAME_SQL = "DELETE FROM habilitacao_exame WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_HABILITACAO_EXAME_SQL = "DELETE FROM habilitacao_exame WHERE descricao = ?;";
	private static final String UPDATE_HABILITACAO_EXAME_SQL = "UPDATE habilitacao_exame SET custo = ?, observacao = ?, tipo_exame_id = ?, laboratorio_id = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM habilitacao_exame;";

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

	public Habilitacao_exame insert(Habilitacao_exame entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_HABILITACAO_EXAME_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setInt(1, entidade.getCusto());
			preparedStatement.setString(2, entidade.getObservacao());
			preparedStatement.setInt(3, entidade.getTipo_exame_id());
			preparedStatement.setInt(4, entidade.getLaboratorio_id());

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

	public Habilitacao_exame findByDecricao(String descricao) {
		Habilitacao_exame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_DESCRICAO_HABILITACAO_EXAME_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new Habilitacao_exame((int) rs.getLong("id"), rs.getString("observacao"), rs.getInt("custo"), rs.getInt("tipo_exame_id"), rs.getInt("laboratorio_id"));
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public Habilitacao_exame findById(long id) {
		Habilitacao_exame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_HABILITACAO_EXAME_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int custo = rs.getInt("custo");
				String observacao = rs.getString("observacao");
				int tipo_exame_id = rs.getInt("tipo_exame_id");
				int laboratorio_id = rs.getInt("laboratorio_id");

				entidade = new Habilitacao_exame((int) id, observacao, custo, tipo_exame_id, laboratorio_id);
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Habilitacao_exame> selectAllHabilitacao_exames() {
		List<Habilitacao_exame> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_HABILITACAO_EXAME)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				int custo = rs.getInt("custo");
				String observacao = rs.getString("observacao");
				int tipo_exame_id = rs.getInt("tipo_exame_id");
				int laboratorio_id = rs.getInt("laboratorio_id");
				entidades.add(new Habilitacao_exame((int) id, observacao, custo, tipo_exame_id, laboratorio_id));
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public void deleteHabilitacao_exame(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_HABILITACAO_EXAME_SQL)) {
			statement.setInt(1, id);

			statement.executeUpdate();
			statement.getConnection().close();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateHabilitacao_exame(Habilitacao_exame entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_HABILITACAO_EXAME_SQL)) {
			statement.setInt(1, entidade.getCusto());
			statement.setString(2, entidade.getObservacao());
			statement.setInt(3, entidade.getTipo_exame_id());
			statement.setInt(4, entidade.getLaboratorio_id());
			statement.setLong(5, entidade.getId());
			
			statement.executeUpdate();
			statement.getConnection().close();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
