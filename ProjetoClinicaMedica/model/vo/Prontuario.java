package model.vo;

public class Prontuario {

	private int idProntuario;
	private Medico medico;
	private Paciente paciente;
	private String observacoes;

	public Prontuario() {
		super();
	}

	public Prontuario(int idProntuario, Medico medico, Paciente paciente, String observacoes) {
		super();
		this.idProntuario = idProntuario;
		this.medico = medico;
		this.paciente = paciente;
		this.observacoes = observacoes;
	}

	public int getIdProntuario() {
		return this.idProntuario;
	}

	public void setIdProntuario(int idProntuario) {
		this.idProntuario = idProntuario;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getObservacoes() {
		return this.observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

}
