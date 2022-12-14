package util;

import java.sql.SQLException;
import java.util.List;

import DAO.Sigla_formacaoDAO;
import model.Sigla_formacao;
import servico.ServicoSigla_formacao;

public class TesteSigla_formacao {
	static Sigla_formacaoDAO siglaFormacaoDAO = new Sigla_formacaoDAO();

    static ServicoSigla_formacao servicoSiglaFormacao = new ServicoSigla_formacao();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(siglaFormacaoDAO.count());

        //salva
        Sigla_formacao siglaFormacao = new Sigla_formacao("UEFA");
        servicoSiglaFormacao.salvar(siglaFormacao);

        //buscar por ID
        Sigla_formacao endereco2 = siglaFormacaoDAO.findById(2);
        System.out.println(endereco2);

        //Update
        siglaFormacao.setSigla("BRA");
        siglaFormacaoDAO.updateSigla_formacao(siglaFormacao);
        siglaFormacao = siglaFormacaoDAO.findById(2);
        System.out.println(siglaFormacao);

        //Select all
        List<Sigla_formacao> tipoExameList = siglaFormacaoDAO.selectAllSigla_formacoes();
        tipoExameList.forEach(System.out::println);

        //Delete
        siglaFormacaoDAO.deleteSigla_formacao(2);
        siglaFormacaoDAO.selectAllSigla_formacoes().forEach(System.out::println);
    }
}