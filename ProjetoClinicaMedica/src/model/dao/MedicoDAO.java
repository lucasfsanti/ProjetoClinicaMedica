package src.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import src.model.Banco;
import src.model.vo.Medico;

public class MedicoDAO {

	public String cadastrarMedico(Medico medico) {
		int novoId = -1;
		String query = "INSERT INTO MEDICO (NOME, CPF, TELEFONE, CELULAR, IDENDERECO, EMIAL, CRM, ESPECIALIDADE, USUARIO, SENHA, ADMIN) " + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query, Statement.RETURN_GENERATED_KEYS);
		
		String mensagem = "";
//		try {
//			//TODO continuar...
//			prepStmt.setString(1, medico.getNome());
//			prepStmt.setString(2, medico.getCpf());
//		}
		return mensagem;
	}

}
