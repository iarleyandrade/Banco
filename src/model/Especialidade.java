package model;

public class Especialidade extends GenericModel {
    private String observacao;
    private String descricao;

    public Especialidade(int id, String observacao, String descricao) {
        setId(id);
        this.observacao = observacao;
        this.descricao = descricao;
    }
    public Especialidade(String observacao, String descricao) {
        super();
        this.observacao = observacao;
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
    public String toString() {
        return "Especialidade{" +
                "observacao='" + observacao + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
