package servico;

import java.sql.SQLException;

import DAO.Composicao_exameDAO;
import model.Composicao_exame;

public class ServicoComposicao_exame {

	private Composicao_exameDAO composicao_exameDAO = new Composicao_exameDAO();

	public Composicao_exame salvar(Composicao_exame entidade) {
		return composicao_exameDAO.insert(entidade);
	}

	public Composicao_exame buscarPorId(Integer id) {
		return composicao_exameDAO.findById(id);
	}

	public void update(Composicao_exame composicao_exame) throws SQLException {
		composicao_exameDAO.updateComposicao_exame(composicao_exame);
	}

	public void remover(Integer id) throws SQLException {
		composicao_exameDAO.deleteComposicao_exame(id);
	}
}
