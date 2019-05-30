package src.model.bo;

import src.model.dao.MedicoDAO;

public class MedicoBO {

	public boolean login(String usuario, String senha) {
		MedicoDAO dao = new MedicoDAO();
		return dao.login(usuario, senha);
	}

}
