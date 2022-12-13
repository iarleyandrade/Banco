package util;

import java.sql.SQLException;
import java.util.List;

import DAO.LaudoDAO;
import model.Laudo;
import servico.ServicoLaudo;

public class TesteLaudo {
	static LaudoDAO LaudoDAO = new LaudoDAO();

    static ServicoLaudo servicoLaudo = new ServicoLaudo();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(LaudoDAO.count());

        //salva
        Laudo consultaMedica = new Laudo("WFEA7", "2022/12/10","dadSF4E",9);
        servicoLaudo.salvar(consultaMedica);

        //buscar por ID
        Laudo tipoExame2 = LaudoDAO.findById(2);
        System.out.println(tipoExame2);

        //Update
        consultaMedica.setCodigo("fwa4f3Sf");
        LaudoDAO.updateLaudo(consultaMedica);
        consultaMedica = LaudoDAO.findById(2);
        System.out.println(consultaMedica);

        //Select all
        List<Laudo> tipoExameList = LaudoDAO.selectAllLaudos();
        tipoExameList.forEach(System.out::println);

        //Delete
        LaudoDAO.deleteLaudo(2);
        LaudoDAO.selectAllLaudos().forEach(System.out::println);
    }
}