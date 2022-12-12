package servico;

import java.sql.SQLException;

import DAO.Consulta_medicaDAO;
import model.Consulta_medica;

public class ServicoConsulta_medica {

	private Consulta_medicaDAO consulta_medicaDAO = new Consulta_medicaDAO();

	public Consulta_medica salvar(Consulta_medica entidade) {
		return consulta_medicaDAO.insert(entidade);
	}

	public Consulta_medica buscarPorId(Integer id) {
		return consulta_medicaDAO.findById(id);
	}

	public void update(Consulta_medica consulta_medica) throws SQLException {
		consulta_medicaDAO.updateConsulta_medica(consulta_medica);
	}

	public void remover(Integer id) throws SQLException {
		consulta_medicaDAO.deleteConsulta_medica(id);
	}
}
