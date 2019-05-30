package src.controller;

import src.model.bo.MedicoBO;

public class MedicoController {

	public boolean login(String usuario, String senha) {
		if (usuario.trim().equals("") || senha.trim().equals("")) {
			return false;
		} else {
			MedicoBO bo = new MedicoBO();
			return bo.login(usuario, senha);
		}
	}

}
