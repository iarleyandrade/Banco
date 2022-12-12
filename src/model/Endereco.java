package model;

public class Endereco extends GenericModel {
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String CEP;
    private String cidade;
    private int laboratorio_id;

    public Endereco(int id,String rua, String numero, String complemento, String bairro, String CEP, String cidade, int laboratorio_id) {
        setId(id);
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.CEP = CEP;
        this.cidade = cidade;
        this.laboratorio_id = laboratorio_id;
    }

    public Endereco(String rua, String numero, String complemento, String bairro, String CEP, String cidade, int laboratorio_id) {
        super();
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.CEP = CEP;
        this.cidade = cidade;
        this.laboratorio_id = laboratorio_id;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCEP() {
        return CEP;
    }

    public String getCidade() {
        return cidade;
    }

    public int getLaboratorio_id() {
        return laboratorio_id;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", CEP='" + CEP + '\'' +
                ", cidade='" + cidade + '\'' +
                ", laboratorio_id=" + laboratorio_id +
                '}';
    }
}
