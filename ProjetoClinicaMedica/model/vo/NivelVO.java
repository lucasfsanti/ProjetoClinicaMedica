package model.vo;

public class NivelVO {
	
	private String descricao;
	private int id;
	
	public NivelVO(int id, String descricao) {
		super();
		this.descricao = descricao;
		this.id = id;
	}
	
	public NivelVO() {
		super();
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.descricao + " (" + this.id + ")";
	}

}
