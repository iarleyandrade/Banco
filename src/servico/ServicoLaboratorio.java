package servico;

import java.sql.SQLException;

import DAO.LaboratorioDAO;
import model.Laboratorio;

public class ServicoLaboratorio {

	private LaboratorioDAO laboratorioDAO = new LaboratorioDAO();

	public Laboratorio salvar(Laboratorio entidade) {
		return laboratorioDAO.insert(entidade);
	}

	public Laboratorio buscarPorId(Integer id) {
		return laboratorioDAO.findById(id);
	}

	public void update(Laboratorio laboratorio) throws SQLException {
		laboratorioDAO.updateLaboratorio(laboratorio);
	}

	public void remover(Integer id) throws SQLException {
		laboratorioDAO.deleteLaboratorio(id);
	}
}
