package util;

import java.sql.SQLException;
import java.util.List;

import DAO.ComposicaoDAO;
import model.Composicao;
import servico.ServicoComposicao;

public class TesteComposicao {
	static ComposicaoDAO composicaoDAO = new ComposicaoDAO();

    static ServicoComposicao servicoComposicao = new ServicoComposicao();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(composicaoDAO.count());

        //salva
        Composicao composicao = new Composicao(9,1,1);
        servicoComposicao.salvar(composicao);

        //buscar por ID
        Composicao tipoExame2 = composicaoDAO.findById(2);
        System.out.println(tipoExame2);

        //Update
        composicao.setValor_referencia_composicao_exame(1);
        composicaoDAO.updateComposicao(composicao);
        composicao = composicaoDAO.findById(2);
        System.out.println(composicao);

        //Select all
        List<Composicao> tipoExameList = composicaoDAO.selectAllComposicaos();
        tipoExameList.forEach(System.out::println);

        //Delete
        composicaoDAO.deleteComposicao(2);
        composicaoDAO.selectAllComposicaos().forEach(System.out::println);
    }
}