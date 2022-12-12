package servico;

import java.sql.SQLException;

import DAO.Tipo_exameDAO;
import model.Tipo_exame;

public class ServicoTipo_exame {

	private Tipo_exameDAO tipo_exameDAO = new Tipo_exameDAO();

	public Tipo_exame salvar(Tipo_exame entidade) {
		return tipo_exameDAO.insert(entidade);
	}

	public Tipo_exame buscarPorId(Integer id) {
		return tipo_exameDAO.findById(id);
	}

	public void update(Tipo_exame tipo_exame) throws SQLException {
		tipo_exameDAO.updateTipo_exame(tipo_exame);
	}

	public void remover(Integer id) throws SQLException {
		tipo_exameDAO.deleteTipo_exame(id);
	}
}
