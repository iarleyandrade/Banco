package model;

public class Medico_has_especialidade extends GenericModel {
    private int especialista_id;
    private int medico_id;

    public Medico_has_especialidade(int id, int especialista_id, int medico_id) {
        setId(id);
        this.especialista_id = especialista_id;
        this.medico_id = medico_id;
    }
    public Medico_has_especialidade(int especialista_id, int medico_id) {
        super();
        this.especialista_id = especialista_id;
        this.medico_id = medico_id;
    }

    public int getEspecialista_id() {
        return especialista_id;
    }

    public int getMedico_id() {
        return medico_id;
    }

    @Override
    public String toString() {
        return "Medico_has_especialidade{" +
                "especialida_id=" + especialista_id +
                ", medico_id=" + medico_id +
                '}';
    }
}
