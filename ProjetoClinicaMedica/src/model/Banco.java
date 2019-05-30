package src.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe criada na disciplina de POO (2019/1).
 * 
 * Representa um banco de dados que se conecta � aplica��o
 * 
 * Encapsula m�todos da API JDBC, com a defini��o, cria��o e fechamento de
 * conex�es � bancos de dados relacionais
 * 
 * @author Adriano de Melo Vilmar C�sar Pereira J�nior (continua��o em
 *         Desenvolvimento Desktop 2018/2)
 * 
 *         Diferen�as entre Statement e PreparedStatement:
 * 
 *         A maioria dos bancos de dados relacionais lida com uma consulta
 *         (query) JDBC / SQL em quatro passos:
 *
 *         1- Interpretar (parse) a consulta SQL;
 * 
 *         2- Compilar a consulta SQL;
 * 
 *         3- Planejar e otimizar o caminho de busca dos dados;
 * 
 *         4- Executar a consulta otimizada, buscando e retornando os dados.
 * 
 *         Um Statement ir� sempre passar pelos quatro passos acima para cada
 *         consulta SQL enviada para o banco. J� um Prepared Statement
 *         pr�-executa os passos (1) a (3).
 * 
 *         Ent�o, ao criar um Prepared Statement alguma pr�-otimiza��o � feita
 *         de imediato. O efeito disso � que, se voc� pretende executar a mesma
 *         consulta repetidas vezes mudando apenas os par�metros de cada uma, a
 *         execu��o usando Prepared Statements ser� mais r�pida e com menos
 *         carga sobre o banco.
 * 
 *         Outra vantagem dos Prepared Statements � que, se utilizados
 *         corretamente, ajudam a evitar <b>ataques de Inje��o de SQL</b>.
 * 
 *         Note que para isso � preciso que os par�metros da consulta sejam
 *         atribu�dos atrav�s dos m�todos setInt(), setString(), etc. presentes
 *         na interface PreparedStatement e n�o por concatena��o de strings.
 * 
 *         Para uma consulta que vai ser executada poucas vezes e n�o requer
 *         nenhum par�metro, Statement basta. Para os demais casos, prefira
 *         PreparedStatement.
 * 
 *         FONTE:
 *         {@link https://pt.stackoverflow.com/questions/99620/qual-a-diferen%C3%A7a-entre-o-statement-e-o-preparedstatement}
 */
public class Banco {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String BANCO = "dbclinicamedica";
	private static final String CONEXAO = "jdbc:mysql://localhost:3306/" + BANCO
			+ "?useTimezone=true&serverTimezone=UTC";
	private static final String USUARIO = "root";
	private static final String SENHA = "";

	public static final int CODIGO_RETORNO_ERRO_EXCLUSAO = 0;
	public static final int CODIGO_RETORNO_SUCESSO_EXCLUSAO = 1;

	/**
	 * Estabelece a conex�o JBDC considerando as configura��es da classe Banco.
	 * 
	 * @return Connection um objeto de conex�o JDBC.
	 * 
	 * @throws ClassNotFoundException caso o nome completo de DRIVER_MYSQL esteja
	 *                                incorreto ou o driver JDBC do banco
	 *                                selecionado n�o foi adicionado ao projeto (via
	 *                                .jar ou depend�ncia no pom.xml).
	 * 
	 * @throws SQLException           caso a URL_CONEXAO, USUARIO e/ou SENHA estejam
	 *                                incorretos.
	 */
	public static Connection getConnection() {
		try {
			Connection conn = null;
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(CONEXAO, USUARIO, SENHA);
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("Classe do Driver n�o foi encontrada. Causa: " + e.getMessage());
			return null;
		} catch (SQLException e) {
			System.out.println("Erro ao obter a Connection. Causa: " + e.getMessage());
			return null;
		}
	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento da conex�o. Causa: " + e.getMessage());
		}
	}

	/**
	 * 
	 * Solicita um objeto Statement para uma conex�o. Este objeto serve para
	 * executar as opera��es SQL.
	 * 
	 * Este m�todo deve ser sempre chamado nos DAOs ap�s a cria��o da express�o SQL,
	 * geralmente com os m�todos execute(sql), executeUpdate(sql) ou
	 * executeQuery(sql), onde "sql" � do tipo String.
	 * 
	 * @param conn uma conex�o anteriormente criada.
	 * @return stmt um objeto do tipo Statement
	 * 
	 * @throws SQLException
	 * 
	 */
	public static Statement getStatement(Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			return stmt;
		} catch (SQLException e) {
			System.out.println("Erro ao obter o Statement. Causa: " + e.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * Fecha um objeto Statement anteriormente criado.
	 * 
	 * Este m�todo deve ser sempre chamado nos DAOs ap�s a execu��o da express�o
	 * SQL.
	 * 
	 * @param stmt um objeto do tipo Statement
	 * 
	 * @throws SQLException
	 * 
	 */
	public static void closeStatement(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do Statement. Causa: " + e.getMessage());
		}
	}

	/**
	 * 
	 * Solicita um objeto PreparedStatement para uma conex�o. Este objeto serve para
	 * executar as opera��es SQL.
	 * 
	 * @param conn uma conex�o anteriormente criada.
	 * @return stmt um objeto do tipo PreparedStatement
	 * 
	 * @throws SQLException
	 * 
	 */
	public static PreparedStatement getPreparedStatement(Connection conn) {
		try {
			PreparedStatement stmt = null;
			return stmt;
		} catch (Exception e) {
			System.out.println("Erro ao obter o PreparedStatement. Causa: " + e.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * Solicita um objeto PreparedStatement para uma conex�o. Este objeto serve para
	 * executar as opera��es SQL.
	 * 
	 * @param conn uma conex�o anteriormente criada.
	 * @return stmt um objeto do tipo PreparedStatement
	 * 
	 * @throws SQLException
	 * 
	 */
	public static PreparedStatement getPreparedStatement(Connection conn, String sql) {
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			return stmt;
		} catch (Exception e) {
			System.out.println("Erro ao obter o PreparedStatement.");
			return null;
		}
	}

	public static PreparedStatement getPreparedStatement(Connection conn, String sql, int tipoRetorno) {
		try {
			PreparedStatement stmt = conn.prepareStatement(sql, tipoRetorno);
			return stmt;
		} catch (Exception e) {
			System.out.println("Erro ao obter o PreparedStatement.");
			return null;
		}
	}

	/**
	 * 
	 * Fecha um objeto PreparedStatement anteriormente criado.
	 * 
	 * Este m�todo deve ser sempre chamado nos DAOs ap�s a execu��o da express�o
	 * SQL.
	 * 
	 * @param stmt um objeto do tipo PreparedStatement
	 * 
	 * @throws SQLException
	 * 
	 */
	public static void closePreparedStatement(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do PreparedStatement. Causa: " + e.getMessage());
		}
	}

	/**
	 * 
	 * Fecha um objeto ResultSet anteriormente criado.
	 * 
	 * Este m�todo deve ser sempre chamado nos DAOs ap�s a consulta de todos os
	 * resultados e convers�o para objetos.
	 * 
	 * @param result um objeto do tipo ResultSet
	 * 
	 * @throws SQLException
	 * 
	 */
	public static void closeResultSet(ResultSet result) {
		try {
			if (result != null) {
				result.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do ResultSet. Causa: " + e.getMessage());
		}
	}
}