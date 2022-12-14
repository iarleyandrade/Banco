package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;

public class EnderecoDAO extends ConexaoDB {

	private static final String INSERT_ENDERECO_SQL = "INSERT INTO endereco (rua, numero, complemento, bairro, CEP, cidade) VALUES (?, ?, ?, ?, ?, ?);";
	private static final String SELECT_ENDERECO_BY_ID = "SELECT id, rua, numero, complemento, bairro, CEP, cidade FROM endereco WHERE id = ?";
	private static final String SELECT_ALL_ENDERECO = "SELECT * FROM endereco;";
	private static final String DELETE_ENDERECO_SQL = "DELETE FROM endereco WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_ENDERECO_SQL = "DELETE FROM endereco WHERE descricao = ?;";
	private static final String UPDATE_ENDERECO_SQL = "UPDATE endereco SET rua = ?, numero = ?, complemento = ?, bairro = ?, CEP = ?, cidade = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM endereco;";

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

	public Endereco insert(Endereco entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_ENDERECO_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, entidade.getRua());
			preparedStatement.setString(2, entidade.getNumero());
			preparedStatement.setString(3, entidade.getComplemento());
			preparedStatement.setString(4, entidade.getBairro());
			preparedStatement.setString(5, entidade.getCEP());
			preparedStatement.setString(6, entidade.getCidade());


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

	public Endereco findByDecricao(String descricao) {
		Endereco entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_DESCRICAO_ENDERECO_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new Endereco((int) rs.getLong("id"), rs.getString("rua"), rs.getString("numero"), rs.getString("complemento"), rs.getString("bairro"), rs.getString("CEP"), rs.getString("cidade"), rs.getInt("laboratorio_id"));
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public Endereco findById(int id) {
		Endereco entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ENDERECO_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String rua = rs.getString("rua");
				String numero = rs.getString("numero");
				String complemento = rs.getString("complemento");
				String bairro = rs.getString("bairro");
				String CEP = rs.getString("CEP");
				String cidade = rs.getString("cidade");
				int laboratorio_id = rs.getInt("laboratorio_id");
				
				entidade = new Endereco(id, rua, numero, complemento, bairro, CEP, cidade, laboratorio_id);
			}
			
			preparedStatement.getConnection().close();

		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Endereco> selectAllEnderecos() {
		List<Endereco> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_ENDERECO)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String rua = rs.getString("rua");
				String numero = rs.getString("numero");
				String complemento = rs.getString("complemento");
				String bairro = rs.getString("bairro");
				String CEP = rs.getString("CEP");
				String cidade = rs.getString("cidade");
				int laboratorio_id = rs.getInt("laboratorio_id");
				entidades.add(new Endereco((int) id, rua, numero, complemento, bairro, CEP, cidade, laboratorio_id));
			}
			
			preparedStatement.getConnection().close();
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public void deleteEndereco(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_ENDERECO_SQL)) {
			statement.setInt(1, id);

			statement.executeUpdate();
			statement.getConnection().close();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateEndereco(Endereco entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_ENDERECO_SQL)) {
			statement.setString(1, entidade.getRua());
			statement.setString(2, entidade.getNumero());
			statement.setString(3, entidade.getComplemento());
			statement.setString(4, entidade.getBairro());
			statement.setString(5, entidade.getCEP());
			statement.setString(6, entidade.getCidade());
			statement.setLong(7, entidade.getId());

			statement.executeUpdate();
			statement.getConnection().close();
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
