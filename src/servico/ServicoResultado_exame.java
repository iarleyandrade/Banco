package servico;

import java.sql.SQLException;

import DAO.Resultado_exameDAO;
import model.Resultado_exame;

public class ServicoResultado_exame {

	private Resultado_exameDAO resultado_exameDAO = new Resultado_exameDAO();

	public Resultado_exame salvar(Resultado_exame entidade) {
		return resultado_exameDAO.insert(entidade);
	}

	public Resultado_exame buscarPorId(Integer id) {
		return resultado_exameDAO.findById(id);
	}

	public void update(Resultado_exame resultado_exame) throws SQLException {
		resultado_exameDAO.updateResultado_exame(resultado_exame);
	}

	public void remover(Integer id) throws SQLException {
		resultado_exameDAO.deleteResultado_exame(id);
	}
}
