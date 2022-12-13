package util;

import java.sql.SQLException;
import java.util.List;

import DAO.Valor_referencia_composicao_exameDAO;
import model.Valor_referencia_composicao_exame;
import servico.ServicoValor_referencia_composicao_exame;

public class TesteValor_referencia_composicao_exame {
	static Valor_referencia_composicao_exameDAO valorReferenciaComposicaoExameDAO = new Valor_referencia_composicao_exameDAO();

    static ServicoValor_referencia_composicao_exame servicoValorReferenciaComposicaoExame = new ServicoValor_referencia_composicao_exame();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(valorReferenciaComposicaoExameDAO.count());

        //salva
        Valor_referencia_composicao_exame valorReferenciaComposicaoExame = new Valor_referencia_composicao_exame("10","500","165","442",1);
        servicoValorReferenciaComposicaoExame.salvar(valorReferenciaComposicaoExame);

        //buscar por ID
        Valor_referencia_composicao_exame tipoExame2 = valorReferenciaComposicaoExameDAO.findById(2);
        System.out.println(tipoExame2);

        //Update
        valorReferenciaComposicaoExame.setValor_maximo("750");
        valorReferenciaComposicaoExameDAO.updateValor_referencia_composicao_exame(valorReferenciaComposicaoExame);
        valorReferenciaComposicaoExame = valorReferenciaComposicaoExameDAO.findById(2);
        System.out.println(valorReferenciaComposicaoExame);

        //Select all
        List<Valor_referencia_composicao_exame> tipoExameList = valorReferenciaComposicaoExameDAO.selectAllValor_referencia_composicao_exames();
        tipoExameList.forEach(System.out::println);

        //Delete
        valorReferenciaComposicaoExameDAO.deleteValor_referencia_composicao_exame(2);
        valorReferenciaComposicaoExameDAO.selectAllValor_referencia_composicao_exames().forEach(System.out::println);
    }
}