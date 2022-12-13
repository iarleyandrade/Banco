package model;

import java.util.Date;

public class Resultado_exame extends GenericModel {
	private Date dt_exame;
	private String valor;
	private int composicao_id;
	private int laudo_id;
	
	
	
	public Resultado_exame(Date dt_exame, String valor, int composicao_id, int laudo_id) {
		super();
		this.dt_exame = dt_exame;
		this.valor = valor;
		this.setComposicao_id(composicao_id);
		this.setLaudo_id(laudo_id);

	}

	public Resultado_exame(int id, Date dt_exame, String valor, int composicao_id, int laudo_id) {
		setId(id);
		this.dt_exame = dt_exame;
		this.valor = valor;
		this.setComposicao_id(composicao_id);
		this.setLaudo_id(laudo_id);
	}


	public void setDt_exame(Date dt_exame) {
		this.dt_exame = dt_exame;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Date getDt_exame() {
		return dt_exame;
	}



	public String getValor() {
		return valor;
	}



	@Override
	public String toString() {
		return "resultado_exame [dt_exame=" + dt_exame + ", valor=" + valor + "]";
	}

	public int getComposicao_id() {
		return composicao_id;
	}

	public void setComposicao_id(int composicao_id) {
		this.composicao_id = composicao_id;
	}

	public int getLaudo_id() {
		return laudo_id;
	}

	public void setLaudo_id(int laudo_id) {
		this.laudo_id = laudo_id;
	}
	
	
}
