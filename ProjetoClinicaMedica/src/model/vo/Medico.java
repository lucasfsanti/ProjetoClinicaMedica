package model.vo;

public class Medico extends Pessoa {

	private int idMedico;
	private String crm;
	private String especialidade;
	private Usuario usuario;

	public Medico() {
		super();
	}

	public Medico(int idMedico, String crm, String especialidade, String nome, String cpf, String telefone,
			String celular, String email, Endereco endereco, Usuario usuario) {
		super(nome, cpf, telefone, celular, email, endereco);
		this.idMedico = idMedico;
		this.crm = crm;
		this.especialidade = especialidade;
		this.usuario = usuario;
	}

	public int getIdMedico() {
		return this.idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getCrm() {
		return this.crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return this.especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return this.especialidade + " " + this.getNome() + " - " + this.crm;
	}

}
