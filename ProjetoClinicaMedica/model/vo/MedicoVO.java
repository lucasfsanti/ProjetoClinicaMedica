package model.vo;

public class MedicoVO extends Pessoa {

	private int idMedico;
	private String login;
	private String senha;
	private String crm;
	private String especialidade;
	private String ativo;
	private String horaTrabalho;
	private boolean admin;
	private ClienteVO cliente;
	
	public MedicoVO(int idMedico, String login, String senha, String crm, String especialidade, boolean admin,
			ClienteVO cliente) {
		super();
		this.idMedico = idMedico;
		this.login = login;
		this.senha = senha;
		this.crm = crm;
		this.especialidade = especialidade;
		this.admin = admin;
		this.cliente = cliente;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}
	
	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "MedicoVO [idMedico=" + idMedico + ", login=" + login + ", senha=" + senha + ", crm=" + crm
				+ ", especialidade=" + especialidade + ", admin=" + admin + ", cliente=" + cliente + "]";
	}

}
