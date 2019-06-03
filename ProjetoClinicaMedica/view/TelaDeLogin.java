package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.MedicoController;
import model.vo.Medico;
import net.miginfocom.swing.MigLayout;

public class TelaDeLogin extends JFrame {

	private JPasswordField passwordField;
	private JTextField txtUsuario;

	private JButton btnLogin;
	private JButton btnNovoUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeLogin window = new TelaDeLogin();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaDeLogin() {
		setTitle("Clinica Médica");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		getContentPane()
				.setLayout(new MigLayout("", "[64px][183px][][][][][][][][][]", "[28px][25px][29px][][][][][]"));

		btnNovoUsuario = new JButton("Novo Usuário");
		btnNovoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroMedico telaCadastroMedico = new TelaCadastroMedico();
				telaCadastroMedico.setVisible(true);
			}
		});

		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblUsuario, "cell 1 1,alignx center,aligny bottom");

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(txtUsuario, "cell 2 1 2 1,growx,aligny top");
		txtUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblSenha, "flowx,cell 1 3,alignx center,aligny center");

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(passwordField, "cell 2 3 2 1,growx,aligny top");
		btnNovoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(btnNovoUsuario, "cell 1 6,aligny center");

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(btnLogin, "cell 3 6,growx,aligny top");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicoController controller = new MedicoController();
				String usuario = txtUsuario.getText();
				String senha = new String(passwordField.getPassword());
				Medico medico = controller.login(usuario, senha);
				if (medico != null) {
					JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");

					TelaPrincipal telaPrincipal = new TelaPrincipal();
					telaPrincipal.setMedico(medico);
					getContentPane().add(telaPrincipal);
					telaPrincipal.setVisible(true);
					telaPrincipal.show();

				} else {
					JOptionPane.showMessageDialog(null, "Usuario e/ou senha inválidos.");
				}
			}
		});
	}
}
