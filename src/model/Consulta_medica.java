package model;

import java.util.Date;

public class Consulta_medica extends GenericModel{
     
	 
	public Consulta_medica(Date dt_consulta, int medico_id, int paciente_id, String nm_atendimento) {
		super();
		this.dt_consulta = dt_consulta;
		this.medico_id = medico_id;
		this.paciente_id = paciente_id;
		this.nm_atendimento = nm_atendimento;
	}
	public Consulta_medica(int id, Date dt_consulta, int medico_id, int paciente_id, String nm_atendimento) {
		setId(id);
		this.dt_consulta = dt_consulta;
		this.medico_id = medico_id;
		this.paciente_id = paciente_id;
		this.nm_atendimento = nm_atendimento;
	}

	private Date dt_consulta;
      private int medico_id;
      private int paciente_id;
      private String nm_atendimento;
      
       public Date getDt_consulta() {
		return dt_consulta;
	}
	public int getMedico_id() {
		return medico_id;
	}
	public int getPaciente_id() {
		return paciente_id;
	}
	public String getNm_atendimento() {
		return nm_atendimento;
	} 
	
	@Override
	public String toString() {
		return "consulta_medica [dt_consulta=" + dt_consulta + ", medico_id=" + medico_id + ", paciente_id="
				+ paciente_id + ", nm_atendimento=" + nm_atendimento + "]";
	}
}
