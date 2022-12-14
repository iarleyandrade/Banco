package util;

import java.sql.SQLException;
import java.util.List;

import DAO.Material_exameDAO;
import model.Material_exame;
import servico.ServicoMaterial_exame;

public class TesteMaterial_exame {
	static Material_exameDAO materialExameDAO = new Material_exameDAO();

    static ServicoMaterial_exame servicoMaterialExame = new ServicoMaterial_exame();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(materialExameDAO.count());

        //salva
        Material_exame materialExame = new Material_exame("Material é palheta", "obeservação: texxxte");
        servicoMaterialExame.salvar(materialExame);

        //buscar por ID
        Material_exame tipoExame2 = materialExameDAO.findById(2);
        System.out.println(tipoExame2);

        //Update
        materialExame.setMaterial("Material, violão");
        materialExameDAO.updateMaterial_exame(materialExame);
        materialExame = materialExameDAO.findById(2);
        System.out.println(materialExame);

        //Select all
        List<Material_exame> tipoExameList = materialExameDAO.selectAllMaterial_exames();
        tipoExameList.forEach(System.out::println);

        //Delete
        materialExameDAO.deleteMaterial_exame(2);
        materialExameDAO.selectAllMaterial_exames().forEach(System.out::println);
    }
}