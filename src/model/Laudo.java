package model;

public class Laudo extends GenericModel {
	private String assinatura_digital;
	private String dt_resultado;
	private String codigo;
	
	
	
	
	
	public Laudo(String assinatura_digital, String dt_resultado, String codigo) {
		super();
		this.assinatura_digital = assinatura_digital;
		this.dt_resultado = dt_resultado;
		this.codigo = codigo;
	}

	public Laudo(int id, String assinatura_digital, String dt_resultado, String codigo) {
		setId(id);
		this.assinatura_digital = assinatura_digital;
		this.dt_resultado = dt_resultado;
		this.codigo = codigo;
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
	
	
	
	
}
