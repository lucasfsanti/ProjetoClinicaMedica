package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Banco;
import model.vo.NivelVO;
import model.vo.UsuarioVO;

public class UsuarioDAO {
	
	/**
	 * Obt�m um usuurio dado nome, email e senha
	 * @param login
	 * @param senha
	 * @return usuurio, caso email e senha estejam corretos
	 */
	public UsuarioVO consultarPorLoginESenha(String login, String senha) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT * FROM USUARIO"
				+ " WHERE UPPER(login) = '" + login.toUpperCase() + "' "
				+ " AND UPPER(senha) = '" + senha.toUpperCase() + "' ";

		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				UsuarioVO usuario = obterUsuarioDoResultSet(resultado);
				return usuario;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao Consultar Permiss�o do Usuario Logado\n");
			System.out.println("Erro: " +  e.getMessage());
			System.out.println(query);
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return null;
	}
	
	/**
	 * Cria um novo usuurio a partir do ResultSet
	 * @param resultado
	 * @return
	 */
	private UsuarioVO obterUsuarioDoResultSet(ResultSet resultado) {
		UsuarioVO userVO = null;
		try {
			//Constr�i um usu�rio com os dados retornados pela consulta
			userVO = new UsuarioVO();
			userVO.setId(resultado.getInt("id"));
			userVO.setEmail(resultado.getString("email"));
			userVO.setSenha(resultado.getString("senha"));
			userVO.setNome(resultado.getString("nome"));
			
			int idNivel = resultado.getInt("idNivel");
			
			NivelDAO nivelDAO =  new NivelDAO();
			NivelVO nivel = nivelDAO.consultarPorId(idNivel);
			
			userVO.setNivelVO(nivel);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userVO;
	}


}
