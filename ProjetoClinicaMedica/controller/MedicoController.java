package controller;

import java.util.ArrayList;
import java.util.Date;

import model.bo.MedicoBO;
import model.vo.MedicoVO;

public class MedicoController {

	private MedicoBO bo;

	public boolean login(String usuario, String senha) {
		if (usuario.trim().equals("") || senha.trim().equals("")) {
			return false;
		} else {
			bo = new MedicoBO();
			return bo.login(usuario, senha);
		}
	}

	public ArrayList<MedicoVO> consultarData(Date data) {
		return bo.ConsultarAgenda(data);
		
	}

}
