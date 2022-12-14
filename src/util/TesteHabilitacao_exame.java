package util;

import java.sql.SQLException;
import java.util.List;

import DAO.Habilitacao_exameDAO;
import model.Habilitacao_exame;
import servico.ServicoHabilitacao_exame;

public class TesteHabilitacao_exame {
	static Habilitacao_exameDAO habilitacaoExameDAO = new Habilitacao_exameDAO();

    static ServicoHabilitacao_exame servicoHabilitacaoExame = new ServicoHabilitacao_exame();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(habilitacaoExameDAO.count());

        //salva
        Habilitacao_exame habilitacaoExame = new Habilitacao_exame("apenas observo", 15, 1,1);
        servicoHabilitacaoExame.salvar(habilitacaoExame);

        //buscar por ID
        Habilitacao_exame tipoExame2 = habilitacaoExameDAO.findById(2);
        System.out.println(tipoExame2);

        //Update
        habilitacaoExame.setCusto(20);
        habilitacaoExameDAO.updateHabilitacao_exame(habilitacaoExame);
        habilitacaoExame = habilitacaoExameDAO.findById(2);
        System.out.println(habilitacaoExame);

        //Select all
        List<Habilitacao_exame> tipoExameList = habilitacaoExameDAO.selectAllHabilitacao_exames();
        tipoExameList.forEach(System.out::println);

        //Delete
        habilitacaoExameDAO.deleteHabilitacao_exame(2);
        habilitacaoExameDAO.selectAllHabilitacao_exames().forEach(System.out::println);
    }
}