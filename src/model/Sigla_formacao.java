package model;

public class Sigla_formacao extends GenericModel {


    public Sigla_formacao(int id, String sigla) {
        setId(id);
        this.sigla = sigla;
    }

    public Sigla_formacao(String sigla) {
        super();
        this.sigla = sigla;
    }

    public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getSigla() {
        return sigla;
    }

    private String sigla;

    @Override
    public String toString() {
        return "Sigla_formacao{" +
                "sigla='" + sigla + '\'' +
                '}';
    }

}