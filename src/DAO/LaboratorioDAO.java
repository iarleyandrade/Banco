package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Laboratorio;


public class LaboratorioDAO extends ConexaoDB{

	private static final String INSERT_LABORATORIO_SQL = "INSERT INTO laboratorio (descricao, CNPJ, CNES, CRBM, nome_fantasia) VALUES (?, ?, ?, ?, ?);";
	private static final String SELECT_LABORATORIO_BY_ID = "SELECT id, descricao, CNPJ, CNES, CRBM, nome_fantasia FROM laboratorio WHERE id = ?";
	private static final String SELECT_ALL_LABORATORIO = "SELECT * FROM laboratorio;";
	private static final String DELETE_LABORATORIO_SQL = "DELETE FROM laboratorio WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_LABORATORIO_SQL = "DELETE FROM laboratorio WHERE descricao = ?;";
	private static final String UPDATE_LABORATORIO_SQL = "UPDATE laboratorio SET descricao = ?, CNPJ = ?, CNES = ?, CRBM = ?, nome_fantasia = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM laboratorio;";

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

	public Laboratorio insert(Laboratorio entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_LABORATORIO_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, entidade.getDescricao());
			preparedStatement.setString(2, entidade.getCNPJ());
			preparedStatement.setString(3, entidade.getCNES());
			preparedStatement.setString(4, entidade.getCRBM());
			preparedStatement.setString(5, entidade.getNome_fantasia());
			

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

	public Laboratorio findByDecricao(String descricao) {
		Laboratorio entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_DESCRICAO_LABORATORIO_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new Laboratorio((int) rs.getLong("id"), rs.getString("descricao"), rs.getString("CNPJ"),rs.getString("CNES"),rs.getString("CRBM"),rs.getString("nome_fantasia"));
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public Laboratorio findById(long id) {
		Laboratorio entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_LABORATORIO_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String descricao = rs.getString("descricao");
				String CNPJ = rs.getString("CNPJ");
				String CNES = rs.getString("CNES");
				String CRBM = rs.getString("CRBM");
				String nome_fantasia = rs.getString("nome_fantasia");
				entidade = new Laboratorio((int) id, descricao, CNPJ, CNES,CRBM,nome_fantasia );
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Laboratorio> selectAllLaboratorios() {
		List<Laboratorio> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_LABORATORIO)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String descricao = rs.getString("descricao");
				String CNPJ = rs.getString("CNPJ");
				String CNES = rs.getString("CNES");
				String CRBM = rs.getString("CRBM");
				String nome_fantasia = rs.getString("nome_fantasia");
				entidades.add(new Laboratorio((int) id, descricao, CNPJ, CNES,CRBM,nome_fantasia ));
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public void deleteLaboratorio(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_LABORATORIO_SQL)) {
			statement.setInt(1, id);

			statement.executeUpdate();
			statement.getConnection().close();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateLaboratorio(Laboratorio entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_LABORATORIO_SQL)) {
			statement.setString(1, entidade.getDescricao());
			statement.setString(2, entidade.getCNPJ());
			statement.setString(3, entidade.getCNES());
			statement.setString(4, entidade.getCRBM());
			statement.setString(5, entidade.getNome_fantasia());
			statement.setLong(6, entidade.getId());
			
			statement.executeUpdate();
			statement.getConnection().close();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
}