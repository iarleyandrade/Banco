package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Unidade_medida;

public class Unidade_medidaDAO extends ConexaoDB {

	private static final String INSERT_UNIDADE_MEDIDA_SQL = "INSERT INTO unidade_medida (descricao) VALUES (?);";
	private static final String SELECT_UNIDADE_MEDIDA_BY_ID = "SELECT id, descricao FROM unidade_medida WHERE id = ?";
	private static final String SELECT_ALL_UNIDADE_MEDIDA = "SELECT * FROM unidade_medida;";
	private static final String DELETE_UNIDADE_MEDIDA_SQL = "DELETE FROM unidade_medida WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_UNIDADE_MEDIDA_SQL = "DELETE FROM unidade_medida WHERE descricao = ?;";
	private static final String UPDATE_UNIDADE_MEDIDA_SQL = "UPDATE unidade_medida SET descricao = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM unidade_medida;";

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

	public Unidade_medida insert(Unidade_medida entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_UNIDADE_MEDIDA_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, entidade.getDescricao());
			

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

	public Unidade_medida findByDecricao(String descricao) {
		Unidade_medida entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_DESCRICAO_UNIDADE_MEDIDA_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new Unidade_medida((int) rs.getLong("id"), rs.getString("descricao"));
			}
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public Unidade_medida findById(long id) {
		Unidade_medida entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_UNIDADE_MEDIDA_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String descricao = rs.getString("descricao");
				
				entidade = new Unidade_medida((int) id, descricao);
			}
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Unidade_medida> selectAllUnidade_medidas() {
		List<Unidade_medida> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_UNIDADE_MEDIDA)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String descricao = rs.getString("descricao");
				
				entidades.add(new Unidade_medida((int) id, descricao));
			}
			preparedStatement.getConnection().close();
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public void deleteUnidade_medida(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_UNIDADE_MEDIDA_SQL)) {
			statement.setInt(1, id);

			statement.executeUpdate();
			statement.getConnection().close();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateUnidade_medida(Unidade_medida entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_UNIDADE_MEDIDA_SQL)) {
			statement.setString(1, entidade.getDescricao());
			
			statement.setLong(2, entidade.getId());
			
			statement.executeUpdate();
			statement.getConnection().close();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
