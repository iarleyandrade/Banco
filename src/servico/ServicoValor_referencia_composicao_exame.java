package servico;

import java.sql.SQLException;

import DAO.Valor_referencia_composicao_exameDAO;
import model.Valor_referencia_composicao_exame;

public class ServicoValor_referencia_composicao_exame {

	private Valor_referencia_composicao_exameDAO valor_referencia_composicao_exameDAO = new Valor_referencia_composicao_exameDAO();

	public Valor_referencia_composicao_exame salvar(Valor_referencia_composicao_exame entidade) {
		return valor_referencia_composicao_exameDAO.insert(entidade);
	}

	public Valor_referencia_composicao_exame buscarPorId(Integer id) {
		return valor_referencia_composicao_exameDAO.findById(id);
	}

	public void update(Valor_referencia_composicao_exame valor_referencia_composicao_exame) throws SQLException {
		valor_referencia_composicao_exameDAO.updateValor_referencia_composicao_exame(valor_referencia_composicao_exame);
	}

	public void remover(Integer id) throws SQLException {
		valor_referencia_composicao_exameDAO.deleteValor_referencia_composicao_exame(id);
	}
}
