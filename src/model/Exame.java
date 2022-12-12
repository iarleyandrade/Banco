package model;

public class Exame extends GenericModel {
	private String descricao;
	private String metodo;
	
	
	
	
	
	public Exame(String descricao, String metodo) {
		super();
		this.descricao = descricao;
		this.metodo = metodo;
	}

	public Exame(int id, String descricao, String metodo) {
		setId(id);
		this.descricao = descricao;
		this.metodo = metodo;
	}



	public String getDescricao() {
		return descricao;
	}





	public String getMetodo() {
		return metodo;
	}





	@Override
	public String toString() {
		return "exame [descricao=" + descricao + ", metodo=" + metodo + "]";
	}
	
	
}
