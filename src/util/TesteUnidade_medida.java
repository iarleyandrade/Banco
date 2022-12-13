package util;

import java.sql.SQLException;
import java.util.List;

import DAO.Unidade_medidaDAO;
import model.Unidade_medida;
import servico.ServicoUnidade_medida;

public class TesteUnidade_medida {
	static Unidade_medidaDAO unidadeMedidaDAO = new Unidade_medidaDAO();

    static ServicoUnidade_medida servicoUnidadeMedida = new ServicoUnidade_medida();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(unidadeMedidaDAO.count());

        //salva
        Unidade_medida unidadeMedida = new Unidade_medida("descricao: é um teste");
        servicoUnidadeMedida.salvar(unidadeMedida);

        //buscar por ID
        Unidade_medida tipoExame2 = unidadeMedidaDAO.findById(2);
        System.out.println(tipoExame2);

        //Update
        unidadeMedida.setDescricao("Descricao: novo teste");
        unidadeMedidaDAO.updateUnidade_medida(unidadeMedida);
        unidadeMedida = unidadeMedidaDAO.findById(2);
        System.out.println(unidadeMedida);

        //Select all
        List<Unidade_medida> tipoExameList = unidadeMedidaDAO.selectAllUnidade_medidas();
        tipoExameList.forEach(System.out::println);

        //Delete
        unidadeMedidaDAO.deleteUnidade_medida(2);
        unidadeMedidaDAO.selectAllUnidade_medidas().forEach(System.out::println);
    }
}