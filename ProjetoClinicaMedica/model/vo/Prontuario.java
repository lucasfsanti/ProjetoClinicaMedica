package model.vo;

public class Prontuario {

	private int idProntuario;
	private MedicoVO medicoVO;
	private Paciente paciente;
	private String anamnese;
	private String laudo;
	private String diagnostico;
	private String prescricao;
	private String atestado;

	public Prontuario() {
		super();
	}

	public Prontuario(int idProntuario, MedicoVO medicoVO, Paciente paciente, String anamnese, String laudo,
			String diagnostico, String prescricao, String atestado) {
		super();
		this.idProntuario = idProntuario;
		this.medicoVO = medicoVO;
		this.paciente = paciente;
		this.anamnese = anamnese;
		this.laudo = laudo;
		this.diagnostico = diagnostico;
		this.prescricao = prescricao;
		this.atestado = atestado;
	}

	public int getIdProntuario() {
		return this.idProntuario;
	}

	public void setIdProntuario(int idProntuario) {
		this.idProntuario = idProntuario;
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

	public String getAnamnese() {
		return this.anamnese;
	}

	public void setAnamnese(String anamnese) {
		this.anamnese = anamnese;
	}

	public String getLaudo() {
		return this.laudo;
	}

	public void setLaudo(String laudo) {
		this.laudo = laudo;
	}

	public String getDiagnostico() {
		return this.diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getPrescricao() {
		return this.prescricao;
	}

	public void setPrescricao(String prescricao) {
		this.prescricao = prescricao;
	}

	public String getAtestado() {
		return this.atestado;
	}

	public void setAtestado(String atestado) {
		this.atestado = atestado;
	}

}
