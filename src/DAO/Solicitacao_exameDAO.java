package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Solicitacao_exame;

public class Solicitacao_exameDAO extends ConexaoDB {

	private static final String INSERT_SOLICITACAO_EXAME_SQL = "INSERT INTO solicitacao_exame (nm_prescrito, dt_solicitacao, consulta_medica_id, habilitacao_exame_id, exame_id) VALUES (?, ?, ?, ?, ?);";
	private static final String SELECT_SOLICITACAO_EXAME_BY_ID = "SELECT id, nm_prescrito, dt_solicitacao, consulta_medica_id, habilitacao_exame_id, exame_id FROM solicitacao_exame WHERE id = ?";
	private static final String SELECT_ALL_SOLICITACAO_EXAME = "SELECT * FROM solicitacao_exame;";
	private static final String DELETE_SOLICITACAO_EXAME_SQL = "DELETE FROM solicitacao_exame WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_SOLICITACAO_EXAME_SQL = "DELETE FROM solicitacao_exame WHERE descricao = ?;";
	private static final String UPDATE_SOLICITACAO_EXAME_SQL = "UPDATE solicitacao_exame SET nm_prescrito = ?, dt_solicitacao = ?, consulta_medica_id = ?, habilitacao_exame_id = ?, exame_id = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM solicitacao_exame;";

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

	public Solicitacao_exame insert(Solicitacao_exame entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_SOLICITACAO_EXAME_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, entidade.getNm_prescrito());
			preparedStatement.setTimestamp(2, new Timestamp(entidade.getDt_solicitacao().getTime())); 
			preparedStatement.setInt(3, entidade.getConsulta_medica_id());
			preparedStatement.setInt(4, entidade.getHabilitacao_exame_id());
			preparedStatement.setInt(5, entidade.getExame_id());
			

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

	public Solicitacao_exame findByDecricao(String descricao) {
		Solicitacao_exame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_DESCRICAO_SOLICITACAO_EXAME_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new Solicitacao_exame((int) rs.getLong("id"), rs.getString("nm_prescrito"), rs.getDate("dt_solicitacao"), rs.getInt("consulta_medica_id"), rs.getInt("habilitacao_exame_id"), rs.getInt("exame_id"));
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public Solicitacao_exame findById(long id) {
		Solicitacao_exame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_SOLICITACAO_EXAME_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String nm_prescrito = rs.getString("nm_prescrito");
				Date dt_solicitacao = rs.getDate("dt_solicitacao");
				int consulta_medica_id = rs.getInt("consulta_medica_id");
				int habilitacao_exame_id = rs.getInt("habilitacao_exame_id");
				int exame_id = rs.getInt("exame_id");


				entidade = new Solicitacao_exame((int) id, nm_prescrito, dt_solicitacao, consulta_medica_id, habilitacao_exame_id, exame_id);
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Solicitacao_exame> selectAllSolicitacao_exames() {
		List<Solicitacao_exame> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_SOLICITACAO_EXAME)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String nm_prescrito = rs.getString("nm_prescrito");
				Date dt_solicitacao = rs.getDate("dt_solicitacao");
				int consulta_medica_id = rs.getInt("consulta_medica_id");
				int habilitacao_exame_id = rs.getInt("habilitacao_exame_id");
				int exame_id = rs.getInt("exame_id");

				entidades.add(new Solicitacao_exame((int) id, nm_prescrito, dt_solicitacao, consulta_medica_id, habilitacao_exame_id, exame_id));
			}
			
			preparedStatement.getConnection().close();
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public void deleteSolicitacao_exame(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_SOLICITACAO_EXAME_SQL)) {
			statement.setInt(1, id);

			statement.executeUpdate();
			statement.getConnection().close();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateSolicitacao_exame(Solicitacao_exame entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_SOLICITACAO_EXAME_SQL)) {
			
			statement.setString(1, entidade.getNm_prescrito());
			statement.setTimestamp(2, new Timestamp(entidade.getDt_solicitacao().getTime()));
			statement.setInt(3, entidade.getConsulta_medica_id());
			statement.setInt(4, entidade.getHabilitacao_exame_id());
			statement.setInt(5, entidade.getExame_id());

			statement.setLong(6, entidade.getId());
			
			statement.executeUpdate();
			statement.getConnection().close();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
