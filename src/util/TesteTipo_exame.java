package util;

import java.sql.SQLException;
import java.util.List;

import DAO.Tipo_exameDAO;
import model.Tipo_exame;
import servico.ServicoTipo_exame;


public class TesteTipo_exame {
	static Tipo_exameDAO exameDAO = new Tipo_exameDAO();

    static ServicoTipo_exame servicoTipoExame = new ServicoTipo_exame();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(exameDAO.count());

        //salva
        Tipo_exame tipoExame = new Tipo_exame("A descrição é uma descrição", "Observação: observo");
        servicoTipoExame.salvar(tipoExame);

        //buscar por ID
        Tipo_exame tipoExame2 = exameDAO.findById(2);
        System.out.println(tipoExame2);

        //Update
        tipoExame.setDescricao("é nova descrição");
        exameDAO.updateTipo_exame(tipoExame);
        tipoExame = exameDAO.findById(2);
        System.out.println(tipoExame);

        //Select all
        List<Tipo_exame> tipoExameList = exameDAO.selectAllTipo_exames();
        tipoExameList.forEach(System.out::println);

        //Delete
        exameDAO.deleteTipo_exame(2);
        exameDAO.selectAllTipo_exames().forEach(System.out::println);
    }
}