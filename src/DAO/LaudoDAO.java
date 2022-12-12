package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Laudo;

public class LaudoDAO extends ConexaoDB {

	private static final String INSERT_LAUDO_SQL = "INSERT INTO laudo (assinatura_digital, dt_resultado, codigo) VALUES (?, ?, ?);";
	private static final String SELECT_LAUDO_BY_ID = "SELECT id, assinatura_digital, dt_resultado, codigo FROM laudo WHERE id = ?";
	private static final String SELECT_ALL_LAUDO = "SELECT * FROM laudo;";
	private static final String DELETE_LAUDO_SQL = "DELETE FROM laudo WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_LAUDO_SQL = "DELETE FROM laudo WHERE descricao = ?;";
	private static final String UPDATE_LAUDO_SQL = "UPDATE laudo SET assinatura_digital = ?, dt_resultado = ?, codigo = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM laudo;";

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

	public Laudo insert(Laudo entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_LAUDO_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, entidade.getAssinatura_digital());
			preparedStatement.setString(2, entidade.getDt_resultado());
			preparedStatement.setString(3, entidade.getCodigo());

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

	public Laudo findByDecricao(String descricao) {
		Laudo entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_DESCRICAO_LAUDO_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new Laudo((int) rs.getLong("id"), rs.getString("assinatura_digital"), rs.getString("dt_resultado"), rs.getString("codigo"));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public Laudo findById(long id) {
		Laudo entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_LAUDO_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String assinatura_digital = rs.getString("assinatura_digital");
				String dt_resultado = rs.getString("dt_resultado");
				String codigo = rs.getString("codigo");
				entidade = new Laudo((int) id, assinatura_digital, dt_resultado, codigo);
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Laudo> selectAllLaudos() {
		List<Laudo> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_LAUDO)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String assinatura_digital = rs.getString("assinatura_digital");
				String dt_resultado = rs.getString("dt_resultado");
				String codigo = rs.getString("codigo");
				entidades.add(new Laudo((int) id, assinatura_digital, dt_resultado, codigo));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public boolean deleteLaudo(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_LAUDO_SQL)) {
			statement.setInt(1, id);

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateLaudo(Laudo entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_LAUDO_SQL)) {
			statement.setString(1, entidade.getAssinatura_digital());
			statement.setString(2, entidade.getDt_resultado());
			statement.setString(3, entidade.getCodigo());
			statement.setLong(4, entidade.getId());

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
