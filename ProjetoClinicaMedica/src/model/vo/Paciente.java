package src.model.vo;

public class Paciente extends Pessoa {

	private int idPaciente;

	public Paciente() {
		super();
	}

	public Paciente(int idPaciente, String nome, String cpf, String telefone, String celular, String email,
			Endereco endereco) {
		super(nome, cpf, telefone, celular, email, endereco);
		this.idPaciente = idPaciente;
	}

	public int getIdPaciente() {
		return this.idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	@Override
	public String toString() {
		return "Paciente " + this.getNome() + " - " + this.getCpf() + " - " + this.getCelular() + " " + this.getEmail();
	}

}
