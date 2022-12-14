package util;

import java.sql.SQLException;
import java.util.List;

import DAO.EnderecoDAO;
import model.Endereco;
import servico.ServicoEndereco;

public class TesteEndereco {
	static EnderecoDAO enderecoDAO = new EnderecoDAO();

    static ServicoEndereco servicoContato = new ServicoEndereco();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(enderecoDAO.count());

        //salva
        Endereco contato = new Endereco("rua do balacobaco", "300", "perto do cheiro do queijo", "nunsei", "60420520","Gothan City", 1);
        servicoContato.salvar(contato);

        //buscar por ID
        Endereco endereco2 = enderecoDAO.findById(2);
        System.out.println(endereco2);

        //Update
        contato.setRua("irineuuuu");
        enderecoDAO.updateEndereco(contato);
        contato = enderecoDAO.findById(2);
        System.out.println(contato);

        //Select all
        List<Endereco> tipoExameList = enderecoDAO.selectAllEnderecos();
        tipoExameList.forEach(System.out::println);

        //Delete
        enderecoDAO.deleteEndereco(2);
        enderecoDAO.selectAllEnderecos().forEach(System.out::println);
    }
}