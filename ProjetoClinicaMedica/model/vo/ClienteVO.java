package model.vo;

public class ClienteVO extends Pessoa{
	
	private int id;
	private String consulta;
	private String horaConsulta;
	private Endereco endereco;
	
	public ClienteVO(String nome, String cpf, String telefone, String celular, String email, Endereco endereco, int id,
			String consulta, String horaConsulta, Endereco endereco2) {
		super(nome, cpf, telefone, celular, email, endereco);
		this.id = id;
		this.consulta = consulta;
		this.horaConsulta = horaConsulta;
		endereco = endereco2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	public String getHoraConsulta() {
		return horaConsulta;
	}

	public void setHoraConsulta(String horaConsulta) {
		this.horaConsulta = horaConsulta;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "ClienteVO [id=" + id + ", consulta=" + consulta + ", horaConsulta=" + horaConsulta + ", endereco="
				+ endereco + "]";
	}
	
}
