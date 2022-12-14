package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Material_exame;

public class Material_exameDAO extends ConexaoDB {

	private static final String INSERT_MATERIAL_EXAME_SQL = "INSERT INTO material_exame (material, observacao) VALUES (?, ?);";
	private static final String SELECT_MATERIAL_EXAME_BY_ID = "SELECT id, material, observacao FROM material_exame WHERE id = ?";
	private static final String SELECT_ALL_MATERIAL_EXAME = "SELECT * FROM material_exame;";
	private static final String DELETE_MATERIAL_EXAME_SQL = "DELETE FROM material_exame WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_MATERIAL_EXAME_SQL = "DELETE FROM material_exame WHERE descricao = ?;";
	private static final String UPDATE_MATERIAL_EXAME_SQL = "UPDATE material_exame SET material = ?, observacao = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM material_exame;";

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

	public Material_exame insert(Material_exame entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_MATERIAL_EXAME_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, entidade.getMaterial());
			preparedStatement.setString(2, entidade.getObservacao());

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

	public Material_exame findByDecricao(String descricao) {
		Material_exame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_DESCRICAO_MATERIAL_EXAME_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new Material_exame((int) rs.getLong("id"), rs.getString("material"), rs.getString("observacao"));
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public Material_exame findById(long id) {
		Material_exame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_MATERIAL_EXAME_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String material = rs.getString("material");
				String observacao = rs.getString("observacao");
				entidade = new Material_exame((int) id, material, observacao);
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Material_exame> selectAllMaterial_exames() {
		List<Material_exame> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_MATERIAL_EXAME)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String material = rs.getString("material");
				String observacao = rs.getString("observacao");
				entidades.add(new Material_exame((int) id, material, observacao));
			}
			
			preparedStatement.getConnection().close();
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public void deleteMaterial_exame(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_MATERIAL_EXAME_SQL)) {
			statement.setInt(1, id);

			statement.executeUpdate();
			statement.getConnection().close();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateMaterial_exame(Material_exame entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_MATERIAL_EXAME_SQL)) {
			statement.setString(1, entidade.getMaterial());
			statement.setString(2, entidade.getObservacao());
			statement.setLong(3, entidade.getId());
			
			statement.executeUpdate();
			statement.getConnection().close();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
