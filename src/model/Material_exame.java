package model;

public class Material_exame extends GenericModel {
	
	public Material_exame(String material, String observacao) {
		super();
		this.material = material;
		this.observacao = observacao;
	}
	
	public Material_exame(int id, String material, String observacao) {
		setId(id);
		this.material = material;
		this.observacao = observacao;
	}

	private String material;
	private String observacao;
	
	
	
	public String getMaterial() {
		return material;
	}



	public String getObservacao() {
		return observacao;
	}



	@Override
	public String toString() {
		return "material_exame [material=" + material + ", observacao=" + observacao + "]";
	}
	
	
}
