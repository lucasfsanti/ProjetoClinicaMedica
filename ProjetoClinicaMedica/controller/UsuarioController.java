package controller;

import model.bo.UsuarioBO;

public class UsuarioController {
	
	public String consultarPermissao (String login, String senha) {
		String mensagem = "";

		if (login == null || login.isEmpty()) {
			mensagem += "Por favor, Digite o email do usuario a ser excluido!\n";
		}

		if (senha == null || senha.isEmpty()) {
			mensagem += "Por favor, Digite a Senha!\n";
		}

		if (mensagem == null || mensagem.isEmpty()) {
			UsuarioBO userBO = new UsuarioBO();
			mensagem += userBO.verificarPermissao(login, senha);
		}

		return mensagem;
	}

}
