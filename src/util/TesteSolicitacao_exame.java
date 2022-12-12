package util;

import java.sql.SQLException;

import java.util.Date;
import java.util.List;

import DAO.Solicitacao_exameDAO;
import model.Solicitacao_exame;
import servico.ServicoSolicitacao_exame;

public class TesteSolicitacao_exame {
	static Solicitacao_exameDAO solicitacaoExameDAO = new Solicitacao_exameDAO();

    static ServicoSolicitacao_exame servicoSolicitacaoExame = new ServicoSolicitacao_exame();

    public static void main(String[] args) throws SQLException {
    	   Date dataUsuario = new Date();

        //count
        System.out.println(solicitacaoExameDAO.count());

        //salva
        Solicitacao_exame solicitacaoExame = new Solicitacao_exame("WFEA7", dataUsuario, 1, 1, 1);
        servicoSolicitacaoExame.salvar(solicitacaoExame);

        //buscar por ID
        Solicitacao_exame tipoExame2 = solicitacaoExameDAO.findById(2);
        System.out.println(tipoExame2);

        //Update
        solicitacaoExame.setNm_prescrito("fwa4f3Sf");
        solicitacaoExameDAO.updateSolicitacao_exame(solicitacaoExame);
        solicitacaoExame = solicitacaoExameDAO.findById(2);
        System.out.println(solicitacaoExame);

        //Select all
        List<Solicitacao_exame> tipoExameList = solicitacaoExameDAO.selectAllSolicitacao_exames();
        tipoExameList.forEach(System.out::println);

        //Delete
        solicitacaoExameDAO.deleteSolicitacao_exame(2);
        solicitacaoExameDAO.selectAllSolicitacao_exames().forEach(System.out::println);
    }
}