package model;

public class Unidade_medida extends GenericModel {
	
	private String descricao;

	
	
	public Unidade_medida(String descricao) {
		super();
		this.descricao = descricao;
	}
	
	public Unidade_medida(int id, String descricao) {
		setId(id);
		this.descricao = descricao;
	}



	public String getDescricao() {
		return descricao;
	}



	@Override
	public String toString() {
		return "unidade_medida [descricao=" + descricao + "]";
	}
	
	
}
