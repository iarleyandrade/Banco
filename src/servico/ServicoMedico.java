package servico;

import java.sql.SQLException;

import DAO.MedicoDAO;
import model.Medico;

public class ServicoMedico {

	private MedicoDAO medicoDAO = new MedicoDAO();

	public Medico salvar(Medico entidade) {
		return medicoDAO.insert(entidade);
	}

	public Medico buscarPorId(Integer id) {
		return medicoDAO.findById(id);
	}

	public void update(Medico medico) throws SQLException {
		medicoDAO.updateMedico(medico);
	}

	public void remover(Integer id) throws SQLException {
		medicoDAO.deleteMedico(id);
	}
}
