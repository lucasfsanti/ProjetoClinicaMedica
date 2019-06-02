package view.normal;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.JButton;

public class TelaInternaAgendaMedico extends JInternalFrame {
	
	 private DefaultStyledDocument doc;

	private static TelaInternaAgendaMedico window;
	private JTextField textMedico;
	private JTextField textAgenda;
	private JTextField textTelefone;
	private JTextField textEmail;
	private JTextField txtLocalAtendimento;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new TelaInternaAgendaMedico();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInternaAgendaMedico() {
		setClosable(true);
		setResizable(true);
		setBounds(100, 100, 763, 605);
		setTitle("Cadastro de Agenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		initialize();
	}

	private void initialize() {

		JLabel lblDados = new JLabel("Dados Da Agenda");
		lblDados.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDados.setBounds(10, 11, 141, 31);
		getContentPane().add(lblDados);

		JLabel lblMedico = new JLabel("Médico:");
		lblMedico.setBounds(10, 74, 124, 31);
		getContentPane().add(lblMedico);
		
				JLabel lblNomeDaAgenda = new JLabel("Nome da Agenda:");
				lblNomeDaAgenda.setBounds(10, 122, 124, 31);
				getContentPane().add(lblNomeDaAgenda);
		
				JLabel lblTelefone = new JLabel("Telefone:");
				lblTelefone.setBounds(370, 74, 124, 31);
				getContentPane().add(lblTelefone);
		
				JLabel labelEmail = new JLabel("Email:");
				labelEmail.setBounds(370, 122, 124, 31);
				getContentPane().add(labelEmail);
		
				JLabel lblDescricao = new JLabel("Descrição:");
				lblDescricao.setBounds(10, 261, 124, 31);
				getContentPane().add(lblDescricao);
		
		JLabel lblLocalAtendimento = new JLabel("Local de Atendimento:");
		lblLocalAtendimento.setBounds(10, 202, 124, 31);
		getContentPane().add(lblLocalAtendimento);

		textMedico = new JTextField();

		textMedico.setBounds(144, 74, 216, 31);
		getContentPane().add(textMedico);
		textMedico.setColumns(10);

		textAgenda = new JTextField();
		textAgenda.setColumns(10);
		textAgenda.setBounds(144, 119, 216, 34);
		getContentPane().add(textAgenda);

		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(504, 74, 216, 31);
		getContentPane().add(textTelefone);

		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(504, 122, 216, 31);
		getContentPane().add(textEmail);
		
		txtLocalAtendimento = new JTextField();
		txtLocalAtendimento.setColumns(10);
		txtLocalAtendimento.setBounds(144, 202, 216, 31);
		getContentPane().add(txtLocalAtendimento);
		

		JTextArea textArea = new JTextArea();
		textArea.setBounds(144, 261, 576, 211);
		getContentPane().add(textArea);
		
		JButton btnCadastrar = new JButton("Cadastrar Agenda");
		btnCadastrar.setBounds(170, 483, 172, 68);
		getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(543, 483, 160, 68);
		getContentPane().add(btnCancelar);
		
		JButton btnAlterarAgenda = new JButton("Alterar Agenda");
		btnAlterarAgenda.setBounds(352, 483, 172, 68);
		getContentPane().add(btnAlterarAgenda);

	}
}
