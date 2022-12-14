package util;

import java.sql.SQLException;
import java.util.List;

import DAO.LaboratorioDAO;
import model.Laboratorio;
import servico.ServicoLaboratorio;

public class TesteLaboratorio {
	static LaboratorioDAO exameDAO = new LaboratorioDAO();

    static ServicoLaboratorio servicoLaboratorio = new ServicoLaboratorio();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(exameDAO.count());

        //salva
        Laboratorio tipoExame = new Laboratorio("A descrição é um ", "92837493", "0932490328", "8273487326", "Salvatore Leone instituto");
        servicoLaboratorio.salvar(tipoExame);

        //buscar por ID
        Laboratorio tipoExame2 = exameDAO.findById(2);
        System.out.println(tipoExame2);

        //Update
        tipoExame.setDescricao("a descrição nova é um");
        exameDAO.updateLaboratorio(tipoExame);
        tipoExame = exameDAO.findById(2);
        System.out.println(tipoExame);

        //Select all
        List<Laboratorio> tipoExameList = exameDAO.selectAllLaboratorios();
        tipoExameList.forEach(System.out::println);

        //Delete
        exameDAO.deleteLaboratorio(2);
        exameDAO.selectAllLaboratorios().forEach(System.out::println);
    }
}