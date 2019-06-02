package view.principais;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.UsuarioController;
import net.miginfocom.swing.MigLayout;
import view.principais.TelaPadrao;

public class TelaDeLogin extends JFrame{
	
	private static TelaDeLogin window;
	
	private static TelaPrincipal telaPrincipal = new TelaPrincipal();
	private static TelaMedico telaMedico = new TelaMedico();
	private static TelaPadrao telaPadrao = new TelaPadrao();

	private JPasswordField passwordField;
	private JTextField txtUsuario;

	private JButton btnLogin;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new TelaDeLogin();
					window.setVisible(true);
					telaPrincipal.setVisible(false);
					telaMedico.setVisible(false);
					telaPadrao.setVisible(false);
					
				} catch (Exception e) {
					System.out.println("Erro ao tentar Iniciar a Tela.\n invokeLater.");
					e.getMessage();
				}
			}
		});
	}

	public TelaDeLogin() {
		setTitle("Clinica M\u00E9dica");
		setBounds(100, 100, 607, 381);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initialize();
	}

	private void initialize() {
		getContentPane().setLayout(new MigLayout("", "[grow][62px,grow][grow][112px,grow][grow]", "[grow,fill][25px,grow,fill][25px,grow,fill][grow,fill][29px,grow,fill][grow,fill]"));

		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setFont(new Font("Verdana", Font.BOLD, 20));
		getContentPane().add(lblUsuario, "cell 1 1,alignx center,growy");

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Verdana", Font.BOLD, 20));
		getContentPane().add(lblSenha, "cell 1 2,alignx center,growy");

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(passwordField, "cell 2 2 2 1,grow");

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.addActionListener(e -> {
			validarLogin();
		});
		getContentPane().add(btnLogin, "cell 1 4 3 1,grow");

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(txtUsuario, "cell 2 1 2 1,grow");
		txtUsuario.setColumns(10);
	}

	/**
	 * Chama o controller para validar se o usuario logado é Adm / Normal / MedicoVO.
	 */
	public void validarLogin() {

		UsuarioController controller = new UsuarioController();
		String usuario = txtUsuario.getText();
		String senha = new String(passwordField.getPassword());

		String mensagem = controller.consultarPermissao(usuario, senha);
		//if (mensagem.equals("Login Aprovado como Adm\n")) {
			this.setVisible(false);
			this.dispose();
			telaPrincipal.setVisible(true);
		/*} else if (mensagem.equals("Login Aprovado como Médico\n")) {
			telaMedico.setVisible(true);
			this.setVisible(false);
			this.dispose();
		} else if (mensagem.equals("Login Aprovado como Usuario\n")) {
			//TODO chamar a tela de usuario padrao
			
			this.setVisible(false);
			this.dispose();
		}*/
		
	}
}
