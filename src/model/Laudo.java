package model;

public class Laudo extends GenericModel {
	private String assinatura_digital;
	private String dt_resultado;
	private String codigo;
	private int solicitacao_exame_id;
	
	
	
	
	
	public void setAssinatura_digital(String assinatura_digital) {
		this.assinatura_digital = assinatura_digital;
	}

	public void setDt_resultado(String dt_resultado) {
		this.dt_resultado = dt_resultado;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Laudo(String assinatura_digital, String dt_resultado, String codigo, int solicitacao_exame_id) {
		super();
		this.assinatura_digital = assinatura_digital;
		this.dt_resultado = dt_resultado;
		this.codigo = codigo;
		this.setSolicitacao_exame_id(solicitacao_exame_id);
	}

	public Laudo(int id, String assinatura_digital, String dt_resultado, String codigo, int solicitacao_exame_id) {
		setId(id);
		this.assinatura_digital = assinatura_digital;
		this.dt_resultado = dt_resultado;
		this.codigo = codigo;
		this.setSolicitacao_exame_id(solicitacao_exame_id);
	}




	public String getAssinatura_digital() {
		return assinatura_digital;
	}





	public String getDt_resultado() {
		return dt_resultado;
	}





	public String getCodigo() {
		return codigo;
	}





	@Override
	public String toString() {
		return "laudo [assinatura_digital=" + assinatura_digital + ", dt_resultado=" + dt_resultado + ", codigo="
				+ codigo + "]";
	}

	public int getSolicitacao_exame_id() {
		return solicitacao_exame_id;
	}

	public void setSolicitacao_exame_id(int solicitacao_exame_id) {
		this.solicitacao_exame_id = solicitacao_exame_id;
	}
	
	
	
	
}
