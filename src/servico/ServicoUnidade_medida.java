package servico;

import java.sql.SQLException;

import DAO.Unidade_medidaDAO;
import model.Unidade_medida;

public class ServicoUnidade_medida {

	private Unidade_medidaDAO unidade_medidaDAO = new Unidade_medidaDAO();

	public Unidade_medida salvar(Unidade_medida entidade) {
		return unidade_medidaDAO.insert(entidade);
	}

	public Unidade_medida buscarPorId(Integer id) {
		return unidade_medidaDAO.findById(id);
	}

	public void update(Unidade_medida unidade_medida) throws SQLException {
		unidade_medidaDAO.updateUnidade_medida(unidade_medida);
	}

	public void remover(Integer id) throws SQLException {
		unidade_medidaDAO.deleteUnidade_medida(id);
	}
}
