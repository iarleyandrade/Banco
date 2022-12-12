package model;

public class Composicao_exame extends GenericModel {
	private String descricao;
	
	

	public Composicao_exame(String descricao) {
		super();
		this.descricao = descricao;
	}
	
	public Composicao_exame(int id,String descricao) {
		setId(id);
		this.descricao = descricao;
	}



	public String getDescricao() {
		return descricao;
	}



	@Override
	public String toString() {
		return "composicao_exame [descricao=" + descricao + "]";
	}
	
	
}
