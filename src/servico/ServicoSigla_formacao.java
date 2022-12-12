package servico;

import java.sql.SQLException;

import DAO.Sigla_formacaoDAO;
import model.Sigla_formacao;

public class ServicoSigla_formacao {

	private Sigla_formacaoDAO sigla_formacaoDAO = new Sigla_formacaoDAO();

	public Sigla_formacao salvar(Sigla_formacao entidade) {
		return sigla_formacaoDAO.insert(entidade);
	}

	public Sigla_formacao buscarPorId(Integer id) {
		return sigla_formacaoDAO.findById(id);
	}

	public void update(Sigla_formacao sigla_formacao) throws SQLException {
		sigla_formacaoDAO.updateSigla_formacao(sigla_formacao);
	}

	public void remover(Integer id) throws SQLException {
		sigla_formacaoDAO.deleteSigla_formacao(id);
	}
}
