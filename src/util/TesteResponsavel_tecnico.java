package util;

import java.sql.SQLException;
import java.util.List;

import DAO.Responsavel_tecnicoDAO;
import model.Responsavel_tecnico;
import servico.ServicoResponsavel_tecnico;

public class TesteResponsavel_tecnico {
	static Responsavel_tecnicoDAO responsavelTecnicoDAO = new Responsavel_tecnicoDAO();

    static ServicoResponsavel_tecnico servicoResponsavelTecnico = new ServicoResponsavel_tecnico();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(responsavelTecnicoDAO.count());

        //salva
        Responsavel_tecnico responsavelTecnico = new Responsavel_tecnico("Fulano de tal","ale-CE","Medico","LBC",1);
        servicoResponsavelTecnico.salvar(responsavelTecnico);

        //buscar por ID
        Responsavel_tecnico endereco2 = responsavelTecnicoDAO.findById(2);
        System.out.println(endereco2);

        //Update
        responsavelTecnico.setNome("Novo nome");
        responsavelTecnicoDAO.updateResponsavel_tecnico(responsavelTecnico);
        responsavelTecnico = responsavelTecnicoDAO.findById(2);
        System.out.println(responsavelTecnico);

        //Select all
        List<Responsavel_tecnico> tipoExameList = responsavelTecnicoDAO.selectAllResponsavel_tecnicos();
        tipoExameList.forEach(System.out::println);

        //Delete
        responsavelTecnicoDAO.deleteResponsavel_tecnico(2);
        responsavelTecnicoDAO.selectAllResponsavel_tecnicos().forEach(System.out::println);
    }
}