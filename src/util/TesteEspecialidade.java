package util;

import java.sql.SQLException;
import java.util.List;

import DAO.EspecialidadeDAO;
import model.Especialidade;
import servico.ServicoEspecialidade;

public class TesteEspecialidade {
	static EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();

    static ServicoEspecialidade servicoEspecialidade = new ServicoEspecialidade();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(especialidadeDAO.count());

        //salva
        Especialidade especialidade = new Especialidade("Descrição: é um teste","Observação: é uma observação");
        servicoEspecialidade.salvar(especialidade);

        //buscar por ID
        Especialidade tipoExame2 = especialidadeDAO.findById(2);
        System.out.println(tipoExame2);

        //Update
        especialidade.setDescricao("Descricao: é um teste de novo");
        especialidadeDAO.updateEspecialidade(especialidade);
        especialidade = especialidadeDAO.findById(1);
        System.out.println(especialidade);

        //Select all
        List<Especialidade> tipoExameList = especialidadeDAO.selectAllEspecialidades();
        tipoExameList.forEach(System.out::println);

        //Delete
        especialidadeDAO.deleteEspecialidade(2);
        especialidadeDAO.selectAllEspecialidades().forEach(System.out::println);
    }
}