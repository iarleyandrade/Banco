package servico;

import java.sql.SQLException;

import DAO.Solicitacao_exameDAO;
import model.Solicitacao_exame;

public class ServicoSolicitacao_exame {

	private Solicitacao_exameDAO solicitacao_exameDAO = new Solicitacao_exameDAO();

	public Solicitacao_exame salvar(Solicitacao_exame entidade) {
		return solicitacao_exameDAO.insert(entidade);
	}

	public Solicitacao_exame buscarPorId(Integer id) {
		return solicitacao_exameDAO.findById(id);
	}

	public void update(Solicitacao_exame solicitacao_exame) throws SQLException {
		solicitacao_exameDAO.updateSolicitacao_exame(solicitacao_exame);
	}

	public void remover(Integer id) throws SQLException {
		solicitacao_exameDAO.deleteSolicitacao_exame(id);
	}
}
