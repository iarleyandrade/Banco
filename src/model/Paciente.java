package model;


import java.util.Date;

public class Paciente extends GenericModel{
    private String name;
    private Date dt_nascimento;

    public Paciente(int id, String name, Date dt_nascimento) {
        setId(id);
        this.name = name;
        this.dt_nascimento = dt_nascimento;
    }
    public Paciente(String name, Date dt_nascimento) {
        super();
        this.name = name;
        this.dt_nascimento = dt_nascimento;
    }

    public String getName() {
        return name;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "name='" + name + '\'' +
                ", dt_nascimento=" + dt_nascimento +
                '}';
    }
}
