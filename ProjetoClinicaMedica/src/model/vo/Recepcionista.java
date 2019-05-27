package model.vo;

public class Recepcionista extends Pessoa {

	private int idRecepcionista;
	private Usuario usuario;

	public Recepcionista() {
		super();
	}

	public Recepcionista(int idRecepcionista, String nome, String cpf, String telefone, String celular, String email,
			Endereco endereco, Usuario usuario) {
		super(nome, cpf, telefone, celular, email, endereco);
		this.idRecepcionista = idRecepcionista;
		this.usuario = usuario;
	}

	public int getIdRecepcionista() {
		return this.idRecepcionista;
	}

	public void setIdRecepcionista(int idRecepcionista) {
		this.idRecepcionista = idRecepcionista;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Recepcionista " + this.getNome() + " - " + this.getCpf() + " - " + this.getCelular() + " "
				+ this.getEmail();
	}

}
