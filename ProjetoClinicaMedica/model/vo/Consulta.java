package model.vo;

public class Consulta {

	private int idConsulta;
	private MedicoVO medicoVO;
	private Paciente paciente;
	private String data_consulta;

	public Consulta() {
		super();
	}

	public Consulta(int idConsulta, MedicoVO medicoVO, Paciente paciente, String data_consulta) {
		super();
		this.idConsulta = idConsulta;
		this.medicoVO = medicoVO;
		this.paciente = paciente;
		this.data_consulta = data_consulta;
	}

	public int getIdConsulta() {
		return this.idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public MedicoVO getMedico() {
		return this.medicoVO;
	}

	public void setMedico(MedicoVO medicoVO) {
		this.medicoVO = medicoVO;
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
