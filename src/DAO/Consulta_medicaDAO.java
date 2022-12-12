package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Consulta_medica;

public class Consulta_medicaDAO extends ConexaoDB {

	private static final String INSERT_CONSULTA_MEDICA_SQL = "INSERT INTO consulta_medica (dt_consulta, medico_id, paciente_id, nm_atendimento) VALUES (?, ?, ?, ?);";
	private static final String SELECT_CONSULTA_MEDICA_BY_ID = "SELECT id, dt_consulta, medico_id, paciente_id, nm_atendimento FROM consulta_medica WHERE id = ?";
	private static final String SELECT_ALL_CONSULTA_MEDICA = "SELECT * FROM consulta_medica;";
	private static final String DELETE_CONSULTA_MEDICA_SQL = "DELETE FROM consulta_medica WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_CONSULTA_MEDICA_SQL = "DELETE FROM consulta_medica WHERE descricao = ?;";
	private static final String UPDATE_CONSULTA_MEDICA_SQL = "UPDATE consulta_medica SET dt_consulta = ?, medico_id = ?, paciente_id = ?, nm_atendimento = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM consulta_medica;";

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

	public Consulta_medica insert(Consulta_medica entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_CONSULTA_MEDICA_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {
			
			preparedStatement.setTimestamp(1, new Timestamp(entidade.getDt_consulta().getTime())); 
			preparedStatement.setInt(2, entidade.getMedico_id());
			preparedStatement.setInt(3, entidade.getPaciente_id());
			preparedStatement.setString(4, entidade.getNm_atendimento());

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

	public Consulta_medica findByDecricao(String descricao) {
		Consulta_medica entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_DESCRICAO_CONSULTA_MEDICA_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new Consulta_medica((int) rs.getLong("id"), rs.getDate("dt_consulta"), rs.getInt("medico_id"), rs.getInt("paciente_id"), rs.getString("nm_atendimento"));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public Consulta_medica findById(long id) {
		Consulta_medica entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_CONSULTA_MEDICA_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Date dt_consulta = rs.getDate("dt_consulta");
				int medico_id = rs.getInt("medico_id");
				int paciente_id = rs.getInt("paciente_id");
				String nm_atendimento = rs.getString("nm_atendimento");
				entidade = new Consulta_medica((int) id, dt_consulta, medico_id, paciente_id, nm_atendimento);
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Consulta_medica> selectAllConsulta_medicas() {
		List<Consulta_medica> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_CONSULTA_MEDICA)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				Date dt_consulta = rs.getDate("dt_consulta");
				int medico_id = rs.getInt("medico_id");
				int paciente_id = rs.getInt("paciente_id");
				String nm_atendimento = rs.getString("nm_atendimento");
				entidades.add(new Consulta_medica((int) id, dt_consulta, medico_id, paciente_id, nm_atendimento));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public boolean deleteConsulta_medica(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_CONSULTA_MEDICA_SQL)) {
			statement.setInt(1, id);

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateConsulta_medica(Consulta_medica entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_CONSULTA_MEDICA_SQL)) {
			statement.setTimestamp(1, new Timestamp(entidade.getDt_consulta().getTime())); 
			statement.setInt(2, entidade.getMedico_id());
			statement.setInt(3, entidade.getPaciente_id());
			statement.setString(4, entidade.getNm_atendimento());
			statement.setLong(5, entidade.getId());

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
