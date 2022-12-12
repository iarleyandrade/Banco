package model;

public class Habilitacao_exame extends GenericModel {
	
	private String observacao;
	private int custo;
	
	
	public Habilitacao_exame(String observacao, int custo) {
		super();
		this.observacao = observacao;
		this.custo = custo;
	}

	public Habilitacao_exame(int id, String observacao, int custo) {
		setId(id);
		this.observacao = observacao;
		this.custo = custo;
	}

	public String getObservacao() {
		return observacao;
	}


	public int getCusto() {
		return custo;
	}


	@Override
	public String toString() {
		return "habilitacao_exame [observacao=" + observacao + ", custo=" + custo + "]";
	}
}
