package model;

import java.util.Date;

public class Resultado_exame extends GenericModel {
	private Date dt_exame;
	private String valor;
	
	
	
	public Resultado_exame(Date dt_exame, String valor) {
		super();
		this.dt_exame = dt_exame;
		this.valor = valor;
	}

	public Resultado_exame(int id, Date dt_exame, String valor) {
		setId(id);
		this.dt_exame = dt_exame;
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
	
	
}
