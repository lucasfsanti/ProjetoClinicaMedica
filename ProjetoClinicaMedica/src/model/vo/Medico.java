package src.model.vo;

public class Medico extends Pessoa {

	private int idMedico;
	private String crm;
	private String especialidade;
	private String usuario;
	private String senha;
	private boolean admin;

	public String getUsuario() {
		return this.usuario;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Medico() {
		super();
	}

	public Medico(int idMedico, String crm, String especialidade, String nome, String cpf, String telefone,
			String celular, String email, Endereco endereco, String usuario, String senha, boolean admin) {
		super(nome, cpf, telefone, celular, email, endereco);
		this.idMedico = idMedico;
		this.crm = crm;
		this.especialidade = especialidade;
		this.usuario = usuario;
		this.senha = senha;
		this.admin = admin;
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

	@Override
	public String toString() {
		return this.especialidade + " " + this.getNome() + " - " + this.crm;
	}

}
