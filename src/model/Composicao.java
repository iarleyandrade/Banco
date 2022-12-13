package model;

public class Composicao extends GenericModel {
	private int exame_id;
	private int composicao_exame_id;
	private int valor_referencia_composicao_exame_id;

	
	
	
	
	public Composicao(int exame_id, int composicao_exame_id, int valor_referencia_composicao_exame) {
		super();
		this.exame_id = exame_id;
		this.composicao_exame_id = composicao_exame_id;
		this.valor_referencia_composicao_exame_id = valor_referencia_composicao_exame;
	}

	public Composicao(int id, int exame_id, int composicao_exame_id, int valor_referencia_composicao_exame) {
		setId(id);
		this.exame_id = exame_id;
		this.composicao_exame_id = composicao_exame_id;
		this.valor_referencia_composicao_exame_id = valor_referencia_composicao_exame;


	}



	public int getExame_id() {
		return exame_id;
	}





	@Override
	public String toString() {
		return "composicao [exame_id=" + exame_id + "]";
	}

	public int getValor_referencia_composicao_exame() {
		return valor_referencia_composicao_exame_id;
	}

	public void setValor_referencia_composicao_exame(int valor_referencia_composicao_exame) {
		this.valor_referencia_composicao_exame_id = valor_referencia_composicao_exame;
	}

	public int getComposicao_exame_id() {
		return composicao_exame_id;
	}

	public void setComposicao_exame_id(int composicao_exame_id) {
		this.composicao_exame_id = composicao_exame_id;
	}
	
}
