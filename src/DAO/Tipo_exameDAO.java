package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tipo_exame;

public class Tipo_exameDAO extends ConexaoDB {

	private static final String INSERT_TIPO_EXAME_SQL = "INSERT INTO tipo_exame (descricao, observacao) VALUES (?, ?);";
	private static final String SELECT_TIPO_EXAME_BY_ID = "SELECT id, descricao, observacao FROM tipo_exame WHERE id = ?";
	private static final String SELECT_ALL_TIPO_EXAME = "SELECT * FROM tipo_exame;";
	private static final String DELETE_TIPO_EXAME_SQL = "DELETE FROM tipo_exame WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_TIPO_EXAME_SQL = "DELETE FROM tipo_exame WHERE descricao = ?;";
	private static final String UPDATE_TIPO_EXAME_SQL = "UPDATE tipo_exame SET descricao = ?, observacao = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM tipo_exame;";

	public Integer count() {
		Integer count = 0;
		try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return count;
	}

	public Tipo_exame insert(Tipo_exame entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_TIPO_EXAME_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, entidade.getDescricao());
			preparedStatement.setString(2, entidade.getObservacao());

			preparedStatement.executeUpdate();

			ResultSet result = preparedStatement.getGeneratedKeys();
			if (result.next()) {
				entidade.setId(result.getLong(1));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public Tipo_exame findByDecricao(String descricao) {
		Tipo_exame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_DESCRICAO_TIPO_EXAME_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new Tipo_exame((int) rs.getLong("id"), rs.getString("descricao"), rs.getString("observacao"));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public Tipo_exame findById(long id) {
		Tipo_exame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_TIPO_EXAME_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String descricao = rs.getString("descricao");
				String observacao = rs.getString("observacao");
				entidade = new Tipo_exame((int) id, descricao, observacao);
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Tipo_exame> selectAllTipo_exames() {
		List<Tipo_exame> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_TIPO_EXAME)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String descricao = rs.getString("descricao");
				String observacao = rs.getString("observacao");
				entidades.add(new Tipo_exame((int) id, descricao, observacao));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public boolean deleteTipo_exame(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_TIPO_EXAME_SQL)) {
			statement.setInt(1, id);

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateTipo_exame(Tipo_exame entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_TIPO_EXAME_SQL)) {
			statement.setString(1, entidade.getDescricao());
			statement.setString(2, entidade.getObservacao());
			statement.setLong(3, entidade.getId());

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
