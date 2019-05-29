package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Banco;
import model.vo.Medico;

public class MedicoDAO {

	public int cadastrarMedico(Medico medico) {
		int novoId = -1;
		String query = "INSERT INTO MEDICO (NOME, CPF, TELEFONE, CELULAR, IDENDERECO, EMAIL, "
				+ "CRM, ESPECIALIDADE, USUARIO, SENHA, ADMIN) " + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query, Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, medico.getNome());
			prepStmt.setString(2, medico.getCpf());
			prepStmt.setString(3, medico.getTelefone());
			prepStmt.setString(4, medico.getCelular());
			prepStmt.setInt(5, medico.getEndereco().getIdEndereco());
			prepStmt.setString(6, medico.getEmail());
			prepStmt.setString(7, medico.getCrm());
			prepStmt.setString(8, medico.getEspecialidade());
			prepStmt.setString(9, medico.getUsuario());
			prepStmt.setString(10, medico.getSenha());
			prepStmt.setBoolean(11, medico.isAdmin());

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar médico: \n " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return novoId;
	}

	public boolean atualizarMedico(Medico medico) {
		Boolean sucessoUpdate = false;
		String query = "UPDATE MEDICO SET NOME=?, CPF=?,TELEFONE=?, CELULAR=?, "
				+ "IDENDERECO=?, EMAIL=?, CRM=?, ESPECIALIDADE=?, USUARIO=?, SENHA=?" + ", ADMIN=?"
				+ "WHERE IDMEDICO = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setString(1, medico.getNome());
			prepStmt.setString(2, medico.getCpf());
			prepStmt.setString(3, medico.getTelefone());
			prepStmt.setString(4, medico.getCelular());
			prepStmt.setInt(5, medico.getEndereco().getIdEndereco());
			prepStmt.setString(6, medico.getEmail());
			prepStmt.setString(7, medico.getCrm());
			prepStmt.setString(8, medico.getEspecialidade());
			prepStmt.setString(9, medico.getUsuario());
			prepStmt.setString(10, medico.getSenha());
			prepStmt.setBoolean(11, medico.isAdmin());
			prepStmt.setInt(12, medico.getIdMedico());

			int resultado = prepStmt.executeUpdate();
			if (resultado >= 1) {
				sucessoUpdate = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar médico: \n " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return sucessoUpdate;
	}

	public boolean excluirMedico(int idMedico) {
		boolean sucessoDelete = false;

		String query = " DELETE FROM MEDICO " + " WHERE ID = ? ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, query);

		try {
			prepStmt.setInt(1, idMedico);

			int codigoRetorno = prepStmt.executeUpdate();

			if (codigoRetorno == 1) {
				sucessoDelete = true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao remover médico. Id = " + idMedico + ". Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return sucessoDelete;
	}

	public boolean login(String usuario, String senha) {
		boolean sucessoLogin = false;

		String query = "SELECT IDMEDICO, ADMIN FROM MEDICO WHERE USUARIO = ? " + "AND SENHA = ?";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			prepStmt.setString(1, usuario);
			prepStmt.setString(2, senha);
			ResultSet result = prepStmt.executeQuery();

			if (result.next()) {
				sucessoLogin = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao efetuar login: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}

		return sucessoLogin;
	}

}
