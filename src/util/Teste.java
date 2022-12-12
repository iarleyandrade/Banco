package util;

import java.sql.SQLException;
import java.util.List;

import DAO.MarcaDAO;
import model.Marca;
import servico.ServicoMarca;

public class Teste {
    static MarcaDAO marcaDAO = new MarcaDAO();

    static ServicoMarca servicoMarca = new ServicoMarca();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(marcaDAO.count());

        //salvar
        Marca marca = new Marca("Citroen", "Carro de vidro! :(");
        servicoMarca.salvar(marca);

        //buscar por ID
        marca = marcaDAO.findById(2);
        System.out.println(marca);

        //Update
        marca.setDescricao("Volt");
        marcaDAO.updateMarca(marca);
        marca = marcaDAO.findById(2);
        System.out.println(marca);

        //Select all
        List<Marca> marcas = marcaDAO.selectAllMarcas();
        marcas.forEach(System.out::println);

        //Delete
        marcaDAO.deleteMarca(2);
        marcaDAO.selectAllMarcas().forEach(System.out::println);
    }
}
