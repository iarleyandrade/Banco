package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Medico_has_especialidade;

public class Medico_has_especialidadeDAO extends ConexaoDB {

	private static final String INSERT_MEDICO_HAS_ESPECIALIDADE_SQL = "INSERT INTO medico_has_especialidade (especialista_id, medico_id) VALUES (?, ?);";
	private static final String SELECT_MEDICO_HAS_ESPECIALIDADE_BY_ID = "SELECT id, especialista_id, medico_id FROM medico_has_especialidade WHERE medico_id = ?";
	private static final String SELECT_ALL_MEDICO_HAS_ESPECIALIDADE = "SELECT * FROM medico_has_especialidade;";
	private static final String DELETE_MEDICO_HAS_ESPECIALIDADE_SQL = "DELETE FROM medico_has_especialidade WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_MEDICO_HAS_ESPECIALIDADE_SQL = "DELETE FROM medico_has_especialidade WHERE descricao = ?;";
	private static final String UPDATE_MEDICO_HAS_ESPECIALIDADE_SQL = "UPDATE medico_has_especialidade SET especialista_id = ?, medico_id = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM medico_has_especialidade;";

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

	public Medico_has_especialidade insert(Medico_has_especialidade entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_MEDICO_HAS_ESPECIALIDADE_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setInt(1, entidade.getEspecialista_id());
			preparedStatement.setInt(2, entidade.getMedico_id());

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

	public Medico_has_especialidade findByDecricao(String descricao) {
		Medico_has_especialidade entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_DESCRICAO_MEDICO_HAS_ESPECIALIDADE_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new Medico_has_especialidade((int) rs.getLong("id"), rs.getInt("especialista_id"), rs.getInt("medico_id"));
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public Medico_has_especialidade findById(long id) {
		Medico_has_especialidade entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_MEDICO_HAS_ESPECIALIDADE_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int especialista_id = rs.getInt("especialista_id");
				int medico_id = rs.getInt("medico_id");
				entidade = new Medico_has_especialidade((int) id, especialista_id, medico_id);
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Medico_has_especialidade> selectAllMedico_has_especialidades() {
		List<Medico_has_especialidade> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_MEDICO_HAS_ESPECIALIDADE)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				int especialista_id = rs.getInt("especialista_id");
				int medico_id = rs.getInt("medico_id");
				entidades.add(new Medico_has_especialidade((int) id, especialista_id, medico_id));
			}
			
			preparedStatement.getConnection().close();
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public void deleteMedico_has_especialidade(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_MEDICO_HAS_ESPECIALIDADE_SQL)) {
			statement.setInt(1, id);

			statement.executeUpdate();
			statement.getConnection().close();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateMedico_has_especialidade(Medico_has_especialidade entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_MEDICO_HAS_ESPECIALIDADE_SQL)) {
			statement.setInt(1, entidade.getEspecialista_id());
			statement.setInt(2, entidade.getMedico_id());
			statement.setLong(3, entidade.getId());
			
			statement.executeUpdate();
			statement.getConnection().close();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
