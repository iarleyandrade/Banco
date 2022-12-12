package servico;

import java.sql.SQLException;

import DAO.Medico_has_especialidadeDAO;
import model.Medico_has_especialidade;

public class ServicoMedico_has_especialidade {

	private Medico_has_especialidadeDAO medico_has_especialidadeDAO = new Medico_has_especialidadeDAO();

	public Medico_has_especialidade salvar(Medico_has_especialidade entidade) {
		return medico_has_especialidadeDAO.insert(entidade);
	}

	public Medico_has_especialidade buscarPorId(Integer id) {
		return medico_has_especialidadeDAO.findById(id);
	}

	public void update(Medico_has_especialidade medico_has_especialidade) throws SQLException {
		medico_has_especialidadeDAO.updateMedico_has_especialidade(medico_has_especialidade);
	}

	public void remover(Integer id) throws SQLException {
		medico_has_especialidadeDAO.deleteMedico_has_especialidade(id);
	}
}
