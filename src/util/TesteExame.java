package util;

import java.sql.SQLException;
import java.util.List;

import DAO.ExameDAO;
import model.Exame;
import servico.ServicoExame;

public class TesteExame {
	static ExameDAO exameDAO = new ExameDAO();

    static ServicoExame servicoServicoExame = new ServicoExame();

    public static void main(String[] args) throws SQLException {
    	
    	

        //count
        System.out.println(exameDAO.count());

        //salva
        Exame exame = new Exame("descricao: novamente um teste boy", "o metodo é bom!",1,1);
        servicoServicoExame.salvar(exame);

        //exame.pegarID();
        
        //buscar por ID
        Exame tipoExame2 = exameDAO.findById(2);
        System.out.println(tipoExame2);

        //Update
        exame.setDescricao("Descricao: teste novo boy");
        exameDAO.updateExame(exame);
        exame = exameDAO.findById(2);
        System.out.println(exame);

        //Select all
        List<Exame> tipoExameList = exameDAO.selectAllExames();
        tipoExameList.forEach(System.out::println);

        //Delete
        exameDAO.deleteExame(2);
        exameDAO.selectAllExames().forEach(System.out::println);
    }
}