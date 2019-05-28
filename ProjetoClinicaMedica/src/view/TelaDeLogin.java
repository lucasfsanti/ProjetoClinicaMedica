package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class TelaDeLogin {

	private JFrame frmClinicaMdica;
	private JPasswordField passwordField;
	private JTextField txtUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeLogin window = new TelaDeLogin();
					window.frmClinicaMdica.setVisible(true);
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClinicaMdica = new JFrame();
		frmClinicaMdica.setTitle("Clinica M\u00E9dica");
		frmClinicaMdica.setBounds(100, 100, 450, 300);
		frmClinicaMdica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmClinicaMdica.getContentPane().setLayout(springLayout);

		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblUsuario, 71, SpringLayout.NORTH,
				frmClinicaMdica.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblUsuario, 183, SpringLayout.WEST,
				frmClinicaMdica.getContentPane());
		frmClinicaMdica.getContentPane().add(lblUsuario);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.WEST, lblUsuario, 0, SpringLayout.WEST, lblSenha);
		frmClinicaMdica.getContentPane().add(lblSenha);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblSenha, 3, SpringLayout.NORTH, passwordField);
		springLayout.putConstraint(SpringLayout.EAST, passwordField, -100, SpringLayout.EAST,
				frmClinicaMdica.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblSenha, -58, SpringLayout.WEST, passwordField);
		frmClinicaMdica.getContentPane().add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, -100, SpringLayout.SOUTH, btnLogin);
		springLayout.putConstraint(SpringLayout.WEST, passwordField, -60, SpringLayout.EAST, btnLogin);
		springLayout.putConstraint(SpringLayout.WEST, btnLogin, 150, SpringLayout.WEST,
				frmClinicaMdica.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnLogin, -50, SpringLayout.SOUTH,
				frmClinicaMdica.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnLogin, -150, SpringLayout.EAST,
				frmClinicaMdica.getContentPane());
		frmClinicaMdica.getContentPane().add(btnLogin);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.WEST, txtUsuario, 39, SpringLayout.EAST, lblUsuario);
		springLayout.putConstraint(SpringLayout.SOUTH, txtUsuario, -16, SpringLayout.NORTH, passwordField);
		springLayout.putConstraint(SpringLayout.EAST, txtUsuario, 149, SpringLayout.EAST, lblUsuario);
		frmClinicaMdica.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
	}
}
