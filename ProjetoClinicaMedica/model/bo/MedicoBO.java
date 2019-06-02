package model.bo;

import model.dao.MedicoDAO;
import model.vo.Medico;

public class MedicoBO {

	public Medico login(String usuario, String senha) {
		MedicoDAO dao = new MedicoDAO();
		return dao.login(usuario, senha);
	}

}
