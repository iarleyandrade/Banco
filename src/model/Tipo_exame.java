package model;

public class Tipo_exame extends GenericModel {
	private String descricao;
	private String observacao;
	
	
	public Tipo_exame(String descricao, String observacao) {
		super();
		this.descricao = descricao;
		this.observacao = observacao;
	}
	
	public Tipo_exame(int id, String descricao, String observacao) {
		setId(id);
		this.descricao = descricao;
		this.observacao = observacao;
	}


	public String getDescricao() {
		return descricao;
	}


	public String getObservacao() {
		return observacao;
	}


	@Override
	public String toString() {
		return "tipo_exame [descricao=" + descricao + ", observacao=" + observacao + "]";
	}
	

}
