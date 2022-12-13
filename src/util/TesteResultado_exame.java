package util;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import DAO.Resultado_exameDAO;
import model.Resultado_exame;
import servico.ServicoResultado_exame;

public class TesteResultado_exame {
	static Resultado_exameDAO resultadoExameDAO = new Resultado_exameDAO();

    static ServicoResultado_exame servicoResultadoExame = new ServicoResultado_exame();

    public static void main(String[] args) throws SQLException {
    	 Date dataUsuario = new Date();

        //count
        System.out.println(resultadoExameDAO.count());

        //salva
        Resultado_exame resultadoExame = new Resultado_exame(dataUsuario,"550",3,6);
        servicoResultadoExame.salvar(resultadoExame);

        //buscar por ID
        Resultado_exame tipoExame2 = resultadoExameDAO.findById(2);
        System.out.println(tipoExame2);

        //Update
        resultadoExame.setValor("574");
        resultadoExameDAO.updateResultado_exame(resultadoExame);
        resultadoExame = resultadoExameDAO.findById(2);
        System.out.println(resultadoExame);

        //Select all
        List<Resultado_exame> tipoExameList = resultadoExameDAO.selectAllResultado_exames();
        tipoExameList.forEach(System.out::println);

        //Delete
        resultadoExameDAO.deleteResultado_exame(2);
        resultadoExameDAO.selectAllResultado_exames().forEach(System.out::println);
    }
}