package servico;

import java.sql.SQLException;

import DAO.ExameDAO;
import model.Exame;

public class ServicoExame {

	private ExameDAO exameDAO = new ExameDAO();

	public Exame salvar(Exame entidade) {
		return exameDAO.insert(entidade);
	}

	public Exame buscarPorId(Integer id) {
		return exameDAO.findById(id);
	}

	public void update(Exame exame) throws SQLException {
		exameDAO.updateExame(exame);
	}

	public void remover(Integer id) throws SQLException {
		exameDAO.deleteExame(id);
	}
}
