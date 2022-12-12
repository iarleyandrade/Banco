package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Solicitacao_exame;

public class Solicitacao_exameDAO extends ConexaoDB {

	private static final String INSERT_SOLICITACAO_EXAME_SQL = "INSERT INTO solicitacao_exame (nm_prescrito, dt_solicitacao) VALUES (?, ?);";
	private static final String SELECT_SOLICITACAO_EXAME_BY_ID = "SELECT id, descricao, observacao FROM solicitacao_exame WHERE id = ?";
	private static final String SELECT_ALL_SOLICITACAO_EXAME = "SELECT * FROM solicitacao_exame;";
	private static final String DELETE_SOLICITACAO_EXAME_SQL = "DELETE FROM solicitacao_exame WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_SOLICITACAO_EXAME_SQL = "DELETE FROM solicitacao_exame WHERE descricao = ?;";
	private static final String UPDATE_SOLICITACAO_EXAME_SQL = "UPDATE solicitacao_exame SET nm_prescrito = ?, dt_solicitacao = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM solicitacao_exame;";

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

	public Solicitacao_exame insert(Solicitacao_exame entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_SOLICITACAO_EXAME_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, entidade.getNm_prescrito());
			preparedStatement.setDate(2, (Date) entidade.getDt_solicitacao());

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

	public Solicitacao_exame findByDecricao(String descricao) {
		Solicitacao_exame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_DESCRICAO_SOLICITACAO_EXAME_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new Solicitacao_exame((int) rs.getLong("id"), rs.getString("nm_prescrito"), rs.getDate("dt_solicitacao"));
			}
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
				entidade = new Solicitacao_exame((int) id, nm_prescrito, dt_solicitacao);
			}
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
				entidades.add(new Solicitacao_exame((int) id, nm_prescrito, dt_solicitacao));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public boolean deleteSolicitacao_exame(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_SOLICITACAO_EXAME_SQL)) {
			statement.setInt(1, id);

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateSolicitacao_exame(Solicitacao_exame entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_SOLICITACAO_EXAME_SQL)) {
			statement.setString(1, entidade.getNm_prescrito());
			statement.setDate(2, (Date) entidade.getDt_solicitacao());
			statement.setLong(3, entidade.getId());

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
