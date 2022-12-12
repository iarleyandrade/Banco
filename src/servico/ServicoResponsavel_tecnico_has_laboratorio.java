package servico;

import java.sql.SQLException;

import DAO.Responsavel_tecnico_has_laboratorioDAO;
import model.Responsavel_tecnico_has_laboratorio;

public class ServicoResponsavel_tecnico_has_laboratorio {

	private Responsavel_tecnico_has_laboratorioDAO responsavel_tecnico_has_laboratorioDAO = new Responsavel_tecnico_has_laboratorioDAO();

	public Responsavel_tecnico_has_laboratorio salvar(Responsavel_tecnico_has_laboratorio entidade) {
		return responsavel_tecnico_has_laboratorioDAO.insert(entidade);
	}

	public Responsavel_tecnico_has_laboratorio buscarPorId(Integer id) {
		return responsavel_tecnico_has_laboratorioDAO.findById(id);
	}

	public void update(Responsavel_tecnico_has_laboratorio responsavel_tecnico_has_laboratorio) throws SQLException {
		responsavel_tecnico_has_laboratorioDAO.updateResponsavel_tecnico_has_laboratorio(responsavel_tecnico_has_laboratorio);
	}

	public void remover(Integer id) throws SQLException {
		responsavel_tecnico_has_laboratorioDAO.deleteResponsavel_tecnico_has_laboratorio(id);
	}
}
