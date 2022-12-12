package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Composicao;

public class ComposicaoDAO extends ConexaoDB {

	private static final String INSERT_COMPOSICAO_SQL = "INSERT INTO composicao (exame_id) VALUES (?);";
	private static final String SELECT_COMPOSICAO_BY_ID = "SELECT id, exame_id FROM composicao WHERE id = ?";
	private static final String SELECT_ALL_COMPOSICAO = "SELECT * FROM composicao;";
	private static final String DELETE_COMPOSICAO_SQL = "DELETE FROM composicao WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_COMPOSICAO_SQL = "DELETE FROM composicao WHERE descricao = ?;";
	private static final String UPDATE_MARCA_SQL = "UPDATE composicao SET exame_id = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM composicao;";

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

	public Composicao insert(Composicao entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_COMPOSICAO_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setInt(1, entidade.getExame_id());
			

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

	public Composicao findByDecricao(String descricao) {
		Composicao entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_DESCRICAO_COMPOSICAO_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new Composicao((int) rs.getLong("id"), rs.getInt("exame_id"));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public Composicao findById(long id) {
		Composicao entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_COMPOSICAO_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int exame_id = rs.getInt("descricao");
				
				entidade = new Composicao((int) id, exame_id);
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Composicao> selectAllComposicaos() {
		List<Composicao> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_COMPOSICAO)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				
				int exame_id = rs.getInt("descricao");
				entidades.add(new Composicao((int) id, exame_id));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public boolean deleteComposicao(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_COMPOSICAO_SQL)) {
			statement.setInt(1, id);

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateComposicao(Composicao entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_MARCA_SQL)) {
			statement.setInt(1, entidade.getExame_id());
			
			statement.setLong(2, entidade.getId());

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
