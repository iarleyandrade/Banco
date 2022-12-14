package util;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import DAO.Consulta_medicaDAO;
import model.Consulta_medica;
import servico.ServicoConsulta_medica;

public class TesteConsulta_medica {
	static Consulta_medicaDAO consultaMedicaDAO = new Consulta_medicaDAO();

    static ServicoConsulta_medica servicoConsultaMedica = new ServicoConsulta_medica();

    public static void main(String[] args) throws SQLException {
        Date dataUsuario = new Date();
        
        

        //count
        System.out.println(consultaMedicaDAO.count());

        //salva
        Consulta_medica consultaMedica = new Consulta_medica(dataUsuario, 1,1,"ttasde132");
        servicoConsultaMedica.salvar(consultaMedica);

        //buscar por ID
        Consulta_medica tipoExame2 = consultaMedicaDAO.findById(2);
        System.out.println(tipoExame2);

        //Update
        consultaMedica.setNm_atendimento("virgo34");
        consultaMedicaDAO.updateConsulta_medica(consultaMedica);
        consultaMedica = consultaMedicaDAO.findById(2);
        System.out.println(consultaMedica);

        //Select all
        List<Consulta_medica> tipoExameList = consultaMedicaDAO.selectAllConsulta_medicas();
        tipoExameList.forEach(System.out::println);

        //Delete
        consultaMedicaDAO.deleteConsulta_medica(2);
        consultaMedicaDAO.selectAllConsulta_medicas().forEach(System.out::println);
    }
}