package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Resultado_exame;

public class Resultado_exameDAO extends ConexaoDB {

	private static final String INSERT_RESULTADO_EXAME_SQL = "INSERT INTO resultado_exame (dt_exame, valor, composicao_id, laudo_id) VALUES (?, ?, ?, ?);";
	private static final String SELECT_RESULTADO_EXAME_BY_ID = "SELECT id, dt_exame, valor, composicao_id, laudo_id FROM resultado_exame WHERE id = ?";
	private static final String SELECT_ALL_RESULTADO_EXAME = "SELECT * FROM resultado_exame;";
	private static final String DELETE_RESULTADO_EXAME_SQL = "DELETE FROM resultado_exame WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_RESULTADO_EXAME_SQL = "DELETE FROM resultado_exame WHERE descricao = ?;";
	private static final String UPDATE_RESULTADO_EXAME_SQL = "UPDATE resultado_exame SET dt_exame = ?, valor = ?, composicao_id = ?, laudo_id = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM resultado_exame;";

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

	public Resultado_exame insert(Resultado_exame entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_RESULTADO_EXAME_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setTimestamp(1, new Timestamp(entidade.getDt_exame().getTime()));
			preparedStatement.setString(2, entidade.getValor());
			preparedStatement.setInt(3, entidade.getComposicao_id());
			preparedStatement.setInt(4, entidade.getLaudo_id());


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

	public Resultado_exame findByDecricao(String descricao) {
		Resultado_exame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_DESCRICAO_RESULTADO_EXAME_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new Resultado_exame((int) rs.getLong("id"), rs.getDate("dt_exame"), rs.getString("valor"), rs.getInt("composicao_id"), rs.getInt("laudo_id"));
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public Resultado_exame findById(long id) {
		Resultado_exame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_RESULTADO_EXAME_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Date dt_exame = rs.getDate("dt_exame");
				String valor = rs.getString("valor");
				int composicao_id = rs.getInt("composicao_id");
				int laudo_id = rs.getInt("laudo_id");
				
				entidade = new Resultado_exame((int) id, dt_exame, valor, composicao_id, laudo_id);
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Resultado_exame> selectAllResultado_exames() {
		List<Resultado_exame> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_RESULTADO_EXAME)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				Date dt_exame = rs.getDate("dt_exame");
				String valor = rs.getString("valor");
				int composicao_id = rs.getInt("composicao_id");
				int laudo_id = rs.getInt("laudo_id");

				entidades.add(new Resultado_exame((int) id, dt_exame, valor, composicao_id, laudo_id));
			}
			
			preparedStatement.getConnection().close();
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public void deleteResultado_exame(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_RESULTADO_EXAME_SQL)) {
			statement.setInt(1, id);

			statement.executeUpdate();
			statement.getConnection().close();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateResultado_exame(Resultado_exame entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_RESULTADO_EXAME_SQL)) {
			statement.setTimestamp(1, new Timestamp(entidade.getDt_exame().getTime()));
			statement.setString(2, entidade.getValor());
			statement.setInt(3, entidade.getComposicao_id());
			statement.setInt(4, entidade.getLaudo_id());

			statement.setLong(5, entidade.getId());

			statement.executeUpdate();
			statement.getConnection().close();
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		
	}
}
