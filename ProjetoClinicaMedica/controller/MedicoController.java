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

	public String cadastrarMedico(String nome, String cpf, String telefone, String celular, String email, String crm,
			String especialidade, String rua, int numero, String bairro, String cidade, String estado, String cep,
			String usuario, String senha, String confirmacaoSenha, boolean admin) {
		String mensagem = validarMedio(nome, cpf, telefone, celular, email, crm, especialidade, rua, numero, bairro,
				cidade, estado, cep, usuario, senha, confirmacaoSenha, admin);
		Medico medico = new Medico();

		return null;
	}

	public String validarMedico(String nome, String cpf, String telefone, String celular, String email, String crm,
			String especialidade, String rua, int numero, String bairro, String cidade, String estado, String cep,
			String usuario, String senha, String confirmacaoSenha, boolean admin) {
		String mensagem = "";
		if (nome == null || nome.trim().equals("")) {
			mensagem += "O campo Nome é obrigatório!\n";
		}
		if (especialidade == null || especialidade.trim().equals("")) {
			mensagem += "O campo Especialidade é obrigatório!\n";
		}
		if (crm == null || crm.trim().equals("")) {
			mensagem += "O campo CRM é obrigatório!\n";
		}
		if (usuario == null || usuario.trim().equals("")) {
			mensagem += "O campo Usuário é obrigatório!\n";
		}
		if (senha == null || senha.trim().equals("")) {
			mensagem += "O campo Senha é obrigatório!\n";
		}
		if (!senha.equals(confirmacaoSenha)) {
			mensagem += "Confirmação de senha e senha não são iguais!\n";
		}

		return mensagem;
	}

}
