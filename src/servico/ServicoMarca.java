package servico;

import java.sql.SQLException;

import DAO.MarcaDAO;
import model.Marca;

public class ServicoMarca {

	private MarcaDAO marcaDAO = new MarcaDAO();

	public Marca salvar(Marca entidade) {
		return marcaDAO.insert(entidade);
	}

	public Marca buscarPorId(Integer id) {
		return marcaDAO.findById(id);
	}

	public void update(Marca marca) throws SQLException {
		marcaDAO.updateMarca(marca);
	}

	public void remover(Integer id) throws SQLException {
		marcaDAO.deleteMarca(id);
	}
}
