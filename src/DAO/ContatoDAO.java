package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Contato;


public class ContatoDAO extends ConexaoDB{

	private static final String INSERT_CONTATO_SQL = "INSERT INTO contato (contato) VALUES (?);";
	private static final String SELECT_CONTATO_BY_ID = "SELECT id, contato WHERE id = ?";
	private static final String SELECT_ALL_CONTATO = "SELECT * FROM contato;";
	private static final String DELETE_CONTATO_SQL = "DELETE FROM contato WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_CONTATO_SQL = "DELETE FROM contato WHERE descricao = ?;";
	private static final String UPDATE_CONTATO_SQL = "UPDATE contato SET telefone = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM contato;";

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

	public Contato insert(Contato entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_CONTATO_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, entidade.getTelefone());
			
			

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

	public Contato findByDecricao(String descricao) {
		Contato entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_DESCRICAO_CONTATO_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new Contato((int) rs.getLong("id"), rs.getString("telefone"), rs.getInt("laboratorio_id"));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public Contato findById(long id) {
		Contato entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_CONTATO_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String telefone = rs.getString("telefone");
				int laboratorio_id = rs.getInt("laboratorio_id");
				
				entidade = new Contato((int) id, telefone, laboratorio_id );
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Contato> selectAllContatos() {
		List<Contato> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_CONTATO)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String telefone = rs.getString("telefone");
				int laboratorio_id = rs.getInt("laboratorio_id");
				
				entidades.add(new Contato((int) id, telefone, laboratorio_id ));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public boolean deleteContato(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_CONTATO_SQL)) {
			statement.setInt(1, id);

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateContato(Contato entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_CONTATO_SQL)) {
			
			statement.setString(1, entidade.getTelefone());
			statement.setLong(2, entidade.getId());

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
}