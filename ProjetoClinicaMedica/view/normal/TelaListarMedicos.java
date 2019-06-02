package view.normal;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.vo.MedicoVO;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import net.miginfocom.swing.MigLayout;

public class TelaListarMedicos extends JInternalFrame{
	private JTextField txtNome;
	private JTextField txtCRM;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarMedicos window = new TelaListarMedicos();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaListarMedicos() {
		setBounds(100, 100, 961, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initialize();
	}

	private void initialize() {

		JLabel lblCadastrarMedico = new JLabel("Cadastrar Medico");
		lblCadastrarMedico.setIcon(new ImageIcon(TelaListarMedicos.class.getResource("/icones/icons8-adicionar-usuário-masculino.png")));
		lblCadastrarMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {


			}
		});
		getContentPane().setLayout(new MigLayout("", "[grow,fill][125px,grow,fill][10px][197px,grow,fill][53.00px,grow,fill][grow,fill][grow,fill][395.00px,fill][grow,fill]", "[50px,grow,fill][7px,grow][31px,grow,fill][31px,grow,fill][32px,grow,fill][398px,grow,fill][grow,fill]"));
		lblCadastrarMedico.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		getContentPane().add(lblCadastrarMedico, "cell 1 0 3 1,alignx left,aligny top");

		JLabel lblNome = new JLabel("Médico:");
		getContentPane().add(lblNome, "cell 1 2,grow");

		JLabel lblCrm = new JLabel("CRM:");
		getContentPane().add(lblCrm, "cell 1 3,grow");

		JLabel lblEspecializao = new JLabel("Especialização:");
		getContentPane().add(lblEspecializao, "cell 1 4,grow");

		JSeparator separator = new JSeparator();
		getContentPane().add(separator, "cell 1 1 7 1,grow");

		txtNome = new JTextField();
		getContentPane().add(txtNome, "cell 3 2 2 1,grow");
		txtNome.setColumns(10);

		txtCRM = new JTextField();
		txtCRM.setColumns(10);
		getContentPane().add(txtCRM, "cell 3 3 2 1,grow");

		JComboBox cbEspecializacao = new JComboBox();
		getContentPane().add(cbEspecializacao, "cell 3 4 2 1,grow");

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		getContentPane().add(btnPesquisar, "cell 7 4,alignx left,growy");

		table = new JTable();
		getContentPane().add(table, "cell 1 5 7 1,grow");
		
		JDateChooser dateChooser = new JDateChooser();
		getContentPane().add(dateChooser, "cell 7 2,grow");
		
		JDateChooser dateChooser_1 = new JDateChooser();
		getContentPane().add(dateChooser_1, "cell 7 3,alignx left,growy");
		
		
		Object[][] data = new Object[][] { {  "Nome", "Ativo", "Telefone", "Horario de Trabalho", "Especialidade" }, };
		Object[] columnNames = new String[] { "Nome", "Ativo", "Telefone", "Horario de Trabalho", "Especialidade" };
		
	}
	
	protected void atualizarTabelaCarros(ArrayList<MedicoVO> medicos) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		Object novaLinha[] = new Object[5];
		for(MedicoVO medicoVO: medicos){
			novaLinha[0] = medicoVO.getNome();
			novaLinha[1] = medicoVO.getAtivo();
			novaLinha[3] = medicoVO.getTelefone();
			novaLinha[5] = medicoVO.getEspecialidade();
			
			model.addRow(novaLinha);
		}
	}
	
	public void limparTela() {
		table.setModel(new DefaultTableModel(
				new Object[][] {{"Placa", "Modelo", "Ano", "Valor"}},
				new String[] {"Placa", "Modelo", "Ano", "Valor"}));
	}
}
