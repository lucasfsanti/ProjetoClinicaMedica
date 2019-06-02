package view.normal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;

public class TelaInternaListarAgendaMedica extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInternaListarAgendaMedica window = new TelaInternaListarAgendaMedica();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInternaListarAgendaMedica() {
		
		setClosable(true);
		setResizable(true);
		setBounds(100, 100, 923, 671);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		initialize();
	}

	private void initialize() {


		JLabel lblMedico = new JLabel("Medico:");
		lblMedico.setBounds(10, 11, 120, 35);
		getContentPane().add(lblMedico);
		
		JLabel lblEspecializao = new JLabel("Especialização:");
		lblEspecializao.setBounds(10, 55, 120, 35);
		getContentPane().add(lblEspecializao);
		
		JLabel lblCrm = new JLabel("CRM:");
		lblCrm.setBounds(10, 101, 120, 35);
		getContentPane().add(lblCrm);
		
		textField = new JTextField();
		textField.setBounds(140, 11, 238, 35);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(140, 101, 238, 35);
		getContentPane().add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(140, 55, 238, 35);
		getContentPane().add(comboBox);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(578, 11, 319, 35);
		getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(578, 55, 319, 35);
		getContentPane().add(dateChooser_1);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(578, 104, 319, 35);
		getContentPane().add(btnPesquisar);
		
		table = new JTable();
		table.setBounds(10, 179, 887, 451);
		getContentPane().add(table);
		
		
	}
}
