package model;

public class Habilitacao_exame extends GenericModel {
	
	private String observacao;
	private int custo;
	private int tipo_exame_id;
	private int laboratorio_id;
	
	
	public Habilitacao_exame(String observacao, int custo, int tipo_exame_id, int laboratorio_id) {
		super();
		this.observacao = observacao;
		this.custo = custo;
		this.setTipo_exame_id(tipo_exame_id);
		this.setLaboratorio_id(laboratorio_id);
	}

	public Habilitacao_exame(int id, String observacao, int custo, int tipo_exame_id, int laboratorio_id) {
		setId(id);
		this.observacao = observacao;
		this.custo = custo;
		this.setTipo_exame_id(tipo_exame_id);
		this.setLaboratorio_id(laboratorio_id);
	}

	public String getObservacao() {
		return observacao;
	}


	public int getCusto() {
		return custo;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void setCusto(int custo) {
		this.custo = custo;
	}

	@Override
	public String toString() {
		return "habilitacao_exame [observacao=" + observacao + ", custo=" + custo + "]";
	}

	public int getLaboratorio_id() {
		return laboratorio_id;
	}

	public void setLaboratorio_id(int laboratorio_id) {
		this.laboratorio_id = laboratorio_id;
	}

	public int getTipo_exame_id() {
		return tipo_exame_id;
	}

	public void setTipo_exame_id(int tipo_exame_id) {
		this.tipo_exame_id = tipo_exame_id;
	}
}
