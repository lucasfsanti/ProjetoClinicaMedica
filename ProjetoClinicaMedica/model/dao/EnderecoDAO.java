package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Banco;
import model.vo.Endereco;

public class EnderecoDAO {

	public int cadastrarEndereco(Endereco endereco) {
		int novoId = -1;
		String query = "INSERT INTO ENDERECO (RUA, NUMERO, BAIRRO, CIDADE, ESTADO, CEP) " + "VALUES (?,?,?,?,?,?)";

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query, Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, endereco.getRua());
			prepStmt.setInt(2, endereco.getNumero());
			prepStmt.setString(3, endereco.getBairro());
			prepStmt.setString(4, endereco.getCidade());
			prepStmt.setString(5, endereco.getEstado());
			prepStmt.setString(6, endereco.getCep());

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar endere�o: \n " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}

		return novoId;
	}

	public Endereco pesquisarPorId(int idEndereco) {
		Endereco endereco = null;
		String query = "SELECT * FROM ENDERECO WHERE IDENDERECO = " + idEndereco;

		Connection conn = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);

		try {
			ResultSet resultado = prepStmt.executeQuery();
			if (resultado.next()) {
				endereco = this.criarEndereco(resultado);
			}
			prepStmt.close();
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar Endereço por ID: \n" + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conn);
		}
		return endereco;
	}

	private Endereco criarEndereco(ResultSet resultado) {
		Endereco endereco = null;
		try {
			endereco.setRua(resultado.getString("RUA"));
			endereco.setNumero(resultado.getInt("NUMERO"));
			endereco.setBairro(resultado.getString("BAIRRO"));
			endereco.setCidade(resultado.getString("CIDADE"));
			endereco.setEstado(resultado.getString("ESTADO"));
			endereco.setCep(resultado.getString("CEP"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return endereco;
	}

}
