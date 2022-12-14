package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Exame;

public class ExameDAO extends ConexaoDB {

	private static final String INSERT_EXAME_SQL = "INSERT INTO exame (descricao, metodo, tipo_exame_id, material_exame_id) VALUES (?, ?, ?, ?);";
	private static final String SELECT_EXAME_BY_ID = "SELECT id, descricao, metodo, tipo_exame_id, material_exame_id FROM exame WHERE id = ?";
	private static final String SELECT_ALL_EXAME = "SELECT * FROM exame;";
	private static final String DELETE_EXAME_SQL = "DELETE FROM exame WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_EXAME_SQL = "DELETE FROM exame WHERE descricao = ?;";
	private static final String UPDATE_EXAME_SQL = "UPDATE exame SET descricao = ?, metodo = ?, tipo_exame_id = ?, material_exame_id = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM exame;";

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

	public Exame insert(Exame entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_EXAME_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, entidade.getDescricao());
			preparedStatement.setString(2, entidade.getMetodo());
			preparedStatement.setInt(3, entidade.getTipo_exame_id());
			preparedStatement.setInt(4, entidade.getMaterial_exame_id());

			

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

	public Exame findByDecricao(String descricao) {
		Exame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_DESCRICAO_EXAME_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new Exame((int) rs.getLong("id"), rs.getString("descricao"), rs.getString("metodo"), rs.getInt("tipo_exame_id"), rs.getInt("material_exame_id"));
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public Exame findById(long id) {
		Exame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_EXAME_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String descricao = rs.getString("descricao");
				String metodo = rs.getString("metodo");
				int tipo_exame_id = rs.getInt("tipo_exame_id");
				int material_exame_id = rs.getInt("material_exame_id");

				entidade = new Exame((int) id, descricao, metodo, tipo_exame_id, material_exame_id);
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Exame> selectAllExames() {
		List<Exame> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_EXAME)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String descricao = rs.getString("descricao");
				String metodo = rs.getString("metodo");
				int tipo_exame_id = rs.getInt("tipo_exame_id");
				int material_exame_id = rs.getInt("material_exame_id");
				
				entidades.add(new Exame((int) id, descricao, metodo, tipo_exame_id, material_exame_id));
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public void deleteExame(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_EXAME_SQL)) {
			statement.setInt(1, id);

			statement.executeUpdate();
			statement.getConnection().close();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateExame(Exame entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_EXAME_SQL)) {
			statement.setString(1, entidade.getDescricao());
			statement.setString(2, entidade.getMetodo());
			statement.setInt(3, entidade.getTipo_exame_id());
			statement.setInt(4, entidade.getMaterial_exame_id());
			statement.setLong(5, entidade.getId());

			statement.executeUpdate();
			statement.getConnection().close();
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
