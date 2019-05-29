package src.model.vo;

public class Consulta {

	private int idConsulta;
	private Medico medico;
	private Paciente paciente;
	private String data_consulta;

	public Consulta() {
		super();
	}

	public Consulta(int idConsulta, Medico medico, Paciente paciente, String data_consulta) {
		super();
		this.idConsulta = idConsulta;
		this.medico = medico;
		this.paciente = paciente;
		this.data_consulta = data_consulta;
	}

	public int getIdConsulta() {
		return this.idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
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

	public String getData_consulta() {
		return this.data_consulta;
	}

	public void setData_consulta(String data_consulta) {
		this.data_consulta = data_consulta;
	}

}
