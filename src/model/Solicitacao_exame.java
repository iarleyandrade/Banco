package model;

import java.util.Date;

public class Solicitacao_exame extends GenericModel {
	private String nm_prescrito;
	private Date dt_solicitacao;
	
	
	
	public Solicitacao_exame(String nm_prescrito, Date dt_solicitacao) {
		super();
		this.nm_prescrito = nm_prescrito;
		this.dt_solicitacao = dt_solicitacao;
	}
	
	public Solicitacao_exame(int id,String nm_prescrito, Date dt_solicitacao) {
		setId(id);
		this.nm_prescrito = nm_prescrito;
		this.dt_solicitacao = dt_solicitacao;
	}
	
	
	public String getNm_prescrito() {
		return nm_prescrito;
	}
	public Date getDt_solicitacao() {
		return dt_solicitacao;
	}
	
	@Override
	public String toString() {
		return "solicitacao_exame [nm_prescrito=" + nm_prescrito + ", dt_solicitacao=" + dt_solicitacao + "]";
	}
	
	
}
