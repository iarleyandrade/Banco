package util;

import java.sql.SQLException;
import java.util.List;

import DAO.ContatoDAO;
import model.Contato;
import servico.ServicoContato;

public class TesteContato {
	static ContatoDAO exameDAO = new ContatoDAO();

    static ServicoContato servicoContato = new ServicoContato();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(exameDAO.count());

        //salva
        Contato contato = new Contato("080090911", 1);
        servicoContato.salvar(contato);

        //buscar por ID
        Contato tipoExame2 = exameDAO.findById(2);
        System.out.println(tipoExame2);

        //Update
        contato.setTelefone("40028922");
        exameDAO.updateContato(contato);
        contato = exameDAO.findById(2);
        System.out.println(contato);

        //Select all
        List<Contato> tipoExameList = exameDAO.selectAllContatos();
        tipoExameList.forEach(System.out::println);

        //Delete
        exameDAO.deleteContato(2);
        exameDAO.selectAllContatos().forEach(System.out::println);
    }
}