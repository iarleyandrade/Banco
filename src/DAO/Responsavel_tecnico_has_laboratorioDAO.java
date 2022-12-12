package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Responsavel_tecnico_has_laboratorio;

public class Responsavel_tecnico_has_laboratorioDAO extends ConexaoDB {

	private static final String INSERT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL = "INSERT INTO responsavel_tecnico_has_laboratorio (laboratorio_id, responsavel_tecnico_id) VALUES (?, ?);";
	private static final String SELECT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_BY_ID = "SELECT id, laboratorio_id, responsavel_tecnico_id FROM responsavel_tecnico_has_laboratorio WHERE id = ?";
	private static final String SELECT_ALL_RESPONSAVEL_TECNICO_HAS_LABORATORIO = "SELECT * FROM responsavel_tecnico_has_laboratorio;";
	private static final String DELETE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL = "DELETE FROM responsavel_tecnico_has_laboratorio WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL = "DELETE FROM responsavel_tecnico_has_laboratorio WHERE descricao = ?;";
	private static final String UPDATE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL = "UPDATE responsavel_tecnico_has_laboratorio SET laboratorio_id = ?, responsavel_tecnico_id = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM responsavel_tecnico_has_laboratorio;";

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

	public Responsavel_tecnico_has_laboratorio insert(Responsavel_tecnico_has_laboratorio entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setInt(1, entidade.getLaboratorio_id());
			preparedStatement.setInt(2, entidade.getResponsavel_tecnico_id());

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

	public Responsavel_tecnico_has_laboratorio findByDecricao(String descricao) {
		Responsavel_tecnico_has_laboratorio entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_DESCRICAO_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new Responsavel_tecnico_has_laboratorio((int) rs.getLong("id"), rs.getInt("responsavel_tecnico_id"), rs.getInt("laboratorio_id"));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public Responsavel_tecnico_has_laboratorio findById(long id) {
		Responsavel_tecnico_has_laboratorio entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int responsavel_tecnico_id = rs.getInt("responsavel_tecnico_id");
				int laboratorio_id = rs.getInt("laboratorio_id");
				entidade = new Responsavel_tecnico_has_laboratorio((int) id, responsavel_tecnico_id, laboratorio_id);
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Responsavel_tecnico_has_laboratorio> selectAllResponsavel_tecnico_has_laboratorios() {
		List<Responsavel_tecnico_has_laboratorio> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_RESPONSAVEL_TECNICO_HAS_LABORATORIO)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				int responsavel_tecnico_id = rs.getInt("responsavel_tecnico_id");
				int laboratorio_id = rs.getInt("laboratorio_id");
				entidades.add(new Responsavel_tecnico_has_laboratorio((int) id, responsavel_tecnico_id, laboratorio_id));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public boolean deleteResponsavel_tecnico_has_laboratorio(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL)) {
			statement.setInt(1, id);

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateResponsavel_tecnico_has_laboratorio(Responsavel_tecnico_has_laboratorio entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL)) {
			statement.setInt(1, entidade.getLaboratorio_id());
			statement.setInt(2, entidade.getResponsavel_tecnico_id());
			statement.setLong(3, entidade.getId());

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
