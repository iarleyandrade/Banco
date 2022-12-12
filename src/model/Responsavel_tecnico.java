package model;

public class Responsavel_tecnico extends GenericModel{
    private String nome;
    private String formacao;
    private String conselho;
    private String sigla_formacao;
    private int sigla_formacao_id;

    public Responsavel_tecnico(int id, String nome, String formacao, String conselho, String sigla_formacao, int sigla_formacao_id) {
        setId(id);
        this.nome = nome;
        this.formacao = formacao;
        this.conselho = conselho;
        this.sigla_formacao = sigla_formacao;
        this.sigla_formacao_id = sigla_formacao_id;
    }
    public Responsavel_tecnico(String nome, String formacao, String conselho, String sigla_formacao, int sigla_formacao_id) {
        super();
        this.nome = nome;
        this.formacao = formacao;
        this.conselho = conselho;
        this.sigla_formacao = sigla_formacao;
        this.sigla_formacao_id = sigla_formacao_id;
    }

    public void setNome(String nome) {
		this.nome = nome;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public void setConselho(String conselho) {
		this.conselho = conselho;
	}
	public void setSigla_formacao(String sigla_formacao) {
		this.sigla_formacao = sigla_formacao;
	}
	public String getNome() {
        return nome;
    }

    public String getFormacao() {
        return formacao;
    }

    public String getConselho() {
        return conselho;
    }

    public String getSigla_formacao() {
        return sigla_formacao;
    }

    @Override
    public String toString() {
        return "Responsavel_tecnico{" +
                "nome='" + nome + '\'' +
                ", formacao='" + formacao + '\'' +
                ", conselho='" + conselho + '\'' +
                ", sigla_formacao='" + sigla_formacao + '\'' +
                '}';
    }
	public int getSigla_formacao_id() {
		return sigla_formacao_id;
	}
	public void setSigla_formacao_id(int sigla_formacao_id) {
		this.sigla_formacao_id = sigla_formacao_id;
	}
}
