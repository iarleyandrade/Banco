package util;

import java.sql.SQLException;
import java.util.List;
import java.sql.Date;

import DAO.PacienteDAO;
import model.Paciente;
import servico.ServicoPaciente;


public class TestePaciente {
	static PacienteDAO pacienteDAO = new PacienteDAO();

    static ServicoPaciente servicoPaciente = new ServicoPaciente();

    public static void main(String[] args) throws SQLException {
        String date = "2003-05-23";
        Date dataUsuario = Date.valueOf(date);
        
        

        //count
        System.out.println(pacienteDAO.count());

        //salva
        Paciente paciente = new Paciente("NPC qualquer", dataUsuario);
        servicoPaciente.salvar(paciente);

        //buscar por ID
        Paciente tipoExame2 = pacienteDAO.findById(2);
        System.out.println(tipoExame2);

        //Update
        paciente.setName("um novo NPC qualquer");
        pacienteDAO.updatePaciente(paciente);
        paciente = pacienteDAO.findById(2);
        System.out.println(paciente);

        //Select all
        List<Paciente> tipoExameList = pacienteDAO.selectAllPacientes();
        tipoExameList.forEach(System.out::println);

        //Delete
        pacienteDAO.deletePaciente(2);
        pacienteDAO.selectAllPacientes().forEach(System.out::println);
    }
}