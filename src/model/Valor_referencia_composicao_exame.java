package model;

public class Valor_referencia_composicao_exame extends GenericModel {
	private String valor_minimo;	
	private String valor_maximo;
	private String limitador_minimo;
	private String limitador_maximo;
	
	
	
	
	public Valor_referencia_composicao_exame(String valor_minimo, String valor_maximo, String limitador_minimo,
			String limitador_maximo) {
		super();
		this.valor_minimo = valor_minimo;
		this.valor_maximo = valor_maximo;
		this.limitador_minimo = limitador_minimo;
		this.limitador_maximo = limitador_maximo;
	}
	
	public Valor_referencia_composicao_exame(int id, String valor_minimo, String valor_maximo, String limitador_minimo,
			String limitador_maximo) {
		setId(id);
		this.valor_minimo = valor_minimo;
		this.valor_maximo = valor_maximo;
		this.limitador_minimo = limitador_minimo;
		this.limitador_maximo = limitador_maximo;
	}




	public String getValor_minimo() {
		return valor_minimo;
	}




	public String getValor_maximo() {
		return valor_maximo;
	}




	public String getLimitador_minimo() {
		return limitador_minimo;
	}




	public String getLimitador_maximo() {
		return limitador_maximo;
	}




	@Override
	public String toString() {
		return "valor_referencia_composicao_exame [valor_minimo=" + valor_minimo + ", valor_maximo=" + valor_maximo
				+ ", limitador_minimo=" + limitador_minimo + ", limitado_maximo=" + limitador_maximo + "]";
	}
	
	
	
}
