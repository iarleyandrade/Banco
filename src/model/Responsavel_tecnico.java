package model;

public class Responsavel_tecnico extends GenericModel{
    private String nome;
    private String formacao;
    private String conselho;
    private String sigla_formacao;

    public Responsavel_tecnico(int id, String nome, String formacao, String conselho, String sigla_formacao) {
        setId(id);
        this.nome = nome;
        this.formacao = formacao;
        this.conselho = conselho;
        this.sigla_formacao = sigla_formacao;
    }
    public Responsavel_tecnico(String nome, String formacao, String conselho, String sigla_formacao) {
        super();
        this.nome = nome;
        this.formacao = formacao;
        this.conselho = conselho;
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
}
