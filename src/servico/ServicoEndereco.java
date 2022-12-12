package servico;

import java.sql.SQLException;

import DAO.EnderecoDAO;
import model.Endereco;

public class ServicoEndereco {

	private EnderecoDAO enderecoDAO = new EnderecoDAO();

	public Endereco salvar(Endereco entidade) {
		return enderecoDAO.insert(entidade);
	}

	public Endereco buscarPorId(Integer id) {
		return enderecoDAO.findById(id);
	}

	public void update(Endereco endereco) throws SQLException {
		enderecoDAO.updateEndereco(endereco);
	}

	public void remover(Integer id) throws SQLException {
		enderecoDAO.deleteEndereco(id);
	}
}
