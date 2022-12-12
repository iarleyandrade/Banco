package model;

public class Responsavel_tecnico_has_laboratorio extends GenericModel{

    private int responsavel_tecnico_id;
    private int laboratorio_id;

    public Responsavel_tecnico_has_laboratorio(int id, int responsavel_tecnico_id, int laboratorio_id) {
        setId(id);
        this.responsavel_tecnico_id = responsavel_tecnico_id;
        this.laboratorio_id = laboratorio_id;
    }

    public Responsavel_tecnico_has_laboratorio(int responsavel_tecnico_id, int laboratorio_id) {
        super();
        this.responsavel_tecnico_id = responsavel_tecnico_id;
        this.laboratorio_id = laboratorio_id;
    }

    public int getResponsavel_tecnico_id() {
        return responsavel_tecnico_id;
    }

    public int getLaboratorio_id() {
        return laboratorio_id;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Responsavel_tecnico_has_laboratorio{" +
                "responsavel_tecnico_id=" + responsavel_tecnico_id +
                ", laboratorio_id=" + laboratorio_id +
                '}';
    }
}