package servico;

import java.sql.SQLException;

import DAO.Responsavel_tecnicoDAO;
import model.Responsavel_tecnico;

public class ServicoResponsavel_tecnico {

	private Responsavel_tecnicoDAO responsavel_tecnicoDAO = new Responsavel_tecnicoDAO();

	public Responsavel_tecnico salvar(Responsavel_tecnico entidade) {
		return responsavel_tecnicoDAO.insert(entidade);
	}

	public Responsavel_tecnico buscarPorId(Integer id) {
		return responsavel_tecnicoDAO.findById(id);
	}

	public void update(Responsavel_tecnico responsavel_tecnico) throws SQLException {
		responsavel_tecnicoDAO.updateResponsavel_tecnico(responsavel_tecnico);
	}

	public void remover(Integer id) throws SQLException {
		responsavel_tecnicoDAO.deleteResponsavel_tecnico(id);
	}
}
