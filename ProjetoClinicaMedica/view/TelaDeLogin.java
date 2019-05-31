package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controller.MedicoController;

public class TelaDeLogin extends JFrame{

	private JPasswordField passwordField;
	private JTextField txtUsuario;
	private	SpringLayout springLayout;
	
	private JButton btnLogin;

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
		setTitle("Clinica M\u00E9dica");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblUsuario, 71, SpringLayout.NORTH,
				getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblUsuario, 183, SpringLayout.WEST,
				getContentPane());
		getContentPane().add(lblUsuario);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.WEST, lblUsuario, 0, SpringLayout.WEST, lblSenha);
		getContentPane().add(lblSenha);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblSenha, 3, SpringLayout.NORTH, passwordField);
		springLayout.putConstraint(SpringLayout.EAST, passwordField, -100, SpringLayout.EAST,
				getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblSenha, -58, SpringLayout.WEST, passwordField);
		getContentPane().add(passwordField);

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, -100, SpringLayout.SOUTH, btnLogin);
		springLayout.putConstraint(SpringLayout.WEST, passwordField, -60, SpringLayout.EAST, btnLogin);
		springLayout.putConstraint(SpringLayout.WEST, btnLogin, 150, SpringLayout.WEST,
				getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnLogin, -50, SpringLayout.SOUTH,
				getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnLogin, -150, SpringLayout.EAST,
				getContentPane());
		getContentPane().add(btnLogin);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MedicoController controller = new MedicoController();
				String usuario = txtUsuario.getText();
				String senha = new String(passwordField.getPassword());
				if (controller.login(usuario, senha)) {
					JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
					
					//TODO chamar a tela principal
					TelaPrincipal telaPrincipal = new TelaPrincipal();
					getContentPane().add(telaPrincipal);
					telaPrincipal.setVisible(true);
					telaPrincipal.show();
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Usuario e/ou senha inv�lidos.");
				}
			}
		});

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.WEST, txtUsuario, 39, SpringLayout.EAST, lblUsuario);
		springLayout.putConstraint(SpringLayout.SOUTH, txtUsuario, -16, SpringLayout.NORTH, passwordField);
		springLayout.putConstraint(SpringLayout.EAST, txtUsuario, 149, SpringLayout.EAST, lblUsuario);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
	}
}
