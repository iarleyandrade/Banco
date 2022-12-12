package model;

public class Medico extends GenericModel{
    private String crm;
    private String nome;

    public Medico(int id, String crm, String nome) {
        setId(id);
        this.crm = crm;
        this.nome = nome;
    }
    public Medico(String crm, String nome) {
        super();
        this.crm = crm;
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "crm='" + crm + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
