package model.bo;

import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

public class UsuarioBO {

	private static final int NIVEL_ADM = 1;
	private static final int NIVEL_NORMAL = 2;
	private static final int NIVEL_MEDICO = 3;


	public String verificarPermissao(String login, String senha) {
		
		String mensagem = "";
		/*String[] conferirEmail = new String [2];
		conferirEmail = login.split("@");

		if (conferirEmail.length > 2) {
			mensagem = "Email Invalido!";
		}

		if (senha.length() <= 5 || senha.length() >= 13) {
			mensagem = "Senha deve ser maior que 6 e menor que 12 Caracteres!";
		}*/

		UsuarioDAO userDAO = new UsuarioDAO();
		UsuarioVO usuarioLogado = userDAO.consultarPorLoginESenha(login, senha);

		if (usuarioLogado == null) {
			mensagem += "Login Invalido, por favor, tente novamente!\n";
		} else if (usuarioLogado != null && usuarioLogado.getNivelVO().getId() == NIVEL_ADM) {
			mensagem += "Login Aprovado como Adminisrador\n";
		} else if (usuarioLogado != null && usuarioLogado.getNivelVO().getId() == NIVEL_NORMAL) {
			mensagem += "Login Aprovado como Usuario\n";
		} else if (usuarioLogado != null && usuarioLogado.getNivelVO().getId() == NIVEL_MEDICO) {
			mensagem += "Login Aprovado como Médico\n";
		}

		return mensagem;
	}
}
