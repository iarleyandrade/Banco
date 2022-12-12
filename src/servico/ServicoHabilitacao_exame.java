package servico;

import java.sql.SQLException;

import DAO.Habilitacao_exameDAO;
import model.Habilitacao_exame;

public class ServicoHabilitacao_exame {

	private Habilitacao_exameDAO habilitacao_exameDAO = new Habilitacao_exameDAO();

	public Habilitacao_exame salvar(Habilitacao_exame entidade) {
		return habilitacao_exameDAO.insert(entidade);
	}

	public Habilitacao_exame buscarPorId(Integer id) {
		return habilitacao_exameDAO.findById(id);
	}

	public void update(Habilitacao_exame habilitacao_exame) throws SQLException {
		habilitacao_exameDAO.updateHabilitacao_exame(habilitacao_exame);
	}

	public void remover(Integer id) throws SQLException {
		habilitacao_exameDAO.deleteHabilitacao_exame(id);
	}
}
