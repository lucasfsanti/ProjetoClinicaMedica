package controller;

import model.bo.MedicoBO;
import model.vo.Medico;

public class MedicoController {

	public Medico login(String usuario, String senha) {
		if (usuario.trim().equals("") || senha.trim().equals("")) {
			return null;
		} else {
			MedicoBO bo = new MedicoBO();
			return bo.login(usuario, senha);
		}
	}

}
