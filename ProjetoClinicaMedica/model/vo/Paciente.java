package model.vo;

public class Paciente extends Pessoa {

	private int idPaciente;
	private String rua;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;

	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paciente(String nome, String cpf, String telefone, String celular, String email, int idPaciente, String rua,
			int numero, String bairro, String cidade, String estado, String cep) {
		super(nome, cpf, telefone, celular, email);
		this.idPaciente = idPaciente;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	public int getIdPaciente() {
		return this.idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Paciente " + this.getNome() + " - " + this.getCpf() + " - " + this.getCelular() + " " + this.getEmail();
	}

}
