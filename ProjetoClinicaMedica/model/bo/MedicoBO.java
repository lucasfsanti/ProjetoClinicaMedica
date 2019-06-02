package model.bo;

import java.util.ArrayList;
import java.util.Date;

import model.dao.MedicoDAO;
import model.vo.MedicoVO;

public class MedicoBO {
	
	public boolean login(String usuario, String senha) {
		MedicoDAO dao = new MedicoDAO();
		return dao.login(usuario, senha);
	}

	public ArrayList<MedicoVO> ConsultarAgenda(Date data) {
		return null;
	}

}
