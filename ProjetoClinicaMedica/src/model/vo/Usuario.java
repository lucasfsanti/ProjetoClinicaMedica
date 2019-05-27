package model.vo;

public class Usuario {

	private int idUsuario;
	private String usuario;
	private String senha;
	private String tipo;

	public Usuario() {
		super();
	}

	public Usuario(int idUsuario, String usuario, String senha, String tipo) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.senha = senha;
		this.tipo = tipo;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
