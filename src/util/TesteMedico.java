package util;

import java.sql.SQLException;
import java.util.List;

import DAO.MedicoDAO;
import model.Medico;
import servico.ServicoMedico;

public class TesteMedico {
	static MedicoDAO medicoDAO = new MedicoDAO();

    static ServicoMedico servicoMedico = new ServicoMedico();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(medicoDAO.count());

        //salva
        Medico especialidade = new Medico("Cicrano Almeida","SERGAD");
        servicoMedico.salvar(especialidade);

        //buscar por ID
        Medico tipoExame2 = medicoDAO.findById(2);
        System.out.println(tipoExame2);

        //Update
        especialidade.setNome("Cicrano de Souza");
        medicoDAO.updateMedico(especialidade);
        especialidade = medicoDAO.findById(2);
        System.out.println(especialidade);

        //Select all
        List<Medico> tipoExameList = medicoDAO.selectAllMedicos();
        tipoExameList.forEach(System.out::println);

        //Delete
        medicoDAO.deleteMedico(2);
        medicoDAO.selectAllMedicos().forEach(System.out::println);
        }}