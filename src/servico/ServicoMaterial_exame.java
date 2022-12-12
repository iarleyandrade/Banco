package servico;

import java.sql.SQLException;

import DAO.Material_exameDAO;
import model.Material_exame;

public class ServicoMaterial_exame {

	private Material_exameDAO material_exameDAO = new Material_exameDAO();

	public Material_exame salvar(Material_exame entidade) {
		return material_exameDAO.insert(entidade);
	}

	public Material_exame buscarPorId(Integer id) {
		return material_exameDAO.findById(id);
	}

	public void update(Material_exame material_exame) throws SQLException {
		material_exameDAO.updateMaterial_exame(material_exame);
	}

	public void remover(Integer id) throws SQLException {
		material_exameDAO.deleteMaterial_exame(id);
	}
}
