package model;

public class Laboratorio extends GenericModel {

    private String descricao;
    private String CNPJ;
    private String CNES;
    private String CRBM;
    private String nome_fantasia;

    public Laboratorio(int id, String descricao, String CNPJ, String CNES, String CRBM, String nome_fantasia) {
        this.setId(id);
        this.descricao = descricao;
        this.CNPJ = CNPJ;
        this.CNES = CNES;
        this.CRBM = CRBM;
        this.nome_fantasia = nome_fantasia;
    }

    public Laboratorio(String descricao, String CNPJ, String CNES, String CRBM, String nome_fantasia) {
        super();
        this.descricao = descricao;
        this.CNPJ = CNPJ;
        this.CNES = CNES;
        this.CRBM = CRBM;
        this.nome_fantasia = nome_fantasia;
    }

    public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public void setCNES(String cNES) {
		CNES = cNES;
	}

	public void setCRBM(String cRBM) {
		CRBM = cRBM;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public String getDescricao() {
        return descricao;
    }

    public String getCNES() {
        return CNES;
    }

    public String getCRBM() {
        return CRBM;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    @Override
    public String toString() {
        return "Laboratorio{" +
                "descricao='" + descricao + '\'' +
                ", CNPJ='" + CNPJ + '\'' +
                ", CNES='" + CNES + '\'' +
                ", CRBM='" + CRBM + '\'' +
                ", nome_fantasia='" + nome_fantasia + '\'' +
                '}';
    }
}
