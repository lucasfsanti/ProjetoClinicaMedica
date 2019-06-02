package view.principais;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.toedter.calendar.JDateChooser;

import controller.MedicoController;
import model.vo.MedicoVO;
import net.miginfocom.swing.MigLayout;

public class TelaMedico extends JFrame{
	
	private JTable table;
	private MedicoController controller;
	private Date data;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMedico window = new TelaMedico();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaMedico() {
		setResizable(true);
		setBounds(100, 100, 821, 609);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[][grow][grow][grow][grow][grow][grow,fill][grow][grow][grow][grow][grow][]", "[grow][grow][grow][grow][grow,fill][grow][grow][grow][grow]"));
		initialize();
	}

	private void initialize() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mntmConsultarPaciente = new JMenuItem("Consultar Paciente");
		mntmConsultarPaciente.setFont(new Font("Arial", Font.BOLD, 12));
		mntmConsultarPaciente.setIcon(new ImageIcon(TelaMedico.class.getResource("/icones/icons8-gerente-de-informações-do-cliente.png")));
		mntmConsultarPaciente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		menuBar.add(mntmConsultarPaciente);
		mntmConsultarPaciente.addActionListener(e -> {

		});

		JMenuItem mntmCadastrarProndutario = new JMenuItem("Cadastrar Prontuario");
		mntmCadastrarProndutario.setFont(new Font("Arial", Font.BOLD, 12));
		mntmCadastrarProndutario.setIcon(new ImageIcon(TelaMedico.class.getResource("/icones/icons8-adicionar-usuário-masculino.png")));
		mntmCadastrarProndutario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		menuBar.add(mntmCadastrarProndutario);
		mntmCadastrarProndutario.addActionListener(e -> {

		});

		JMenuItem mntmImprimir = new JMenuItem("Imprimir");
		mntmImprimir.setFont(new Font("Arial", Font.BOLD, 12));
		mntmImprimir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mntmImprimir.setIcon(new ImageIcon(TelaMedico.class.getResource("/icones/icons8-imprimir-arquivo.png")));
		menuBar.add(mntmImprimir);
		

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setToolTipText("Selecione a Data para Consulta");
		getContentPane().add(dateChooser, "cell 2 0 4 1,grow");

		JButton btnPesquisarAgenda = new JButton("Pesquisar Agenda");
		getContentPane().add(btnPesquisarAgenda, "cell 6 0 4 1,grow");
		btnPesquisarAgenda.addActionListener(e -> {
			
			controller = new MedicoController();
			
			data = dateChooser.getDate();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			
			ArrayList<MedicoVO> vo = controller.consultarData(data);
			atualizarTabelaCarros(vo);

		});



		JButton btnAgendarConsulta = new JButton("Agendar Consulta");
		getContentPane().add(btnAgendarConsulta, "cell 2 8 4 1,grow");
		btnAgendarConsulta.addActionListener(e -> {

		});

		JButton btnApagar = new JButton("Apagar Consulta");
		getContentPane().add(btnApagar, "cell 6 8 4 1,grow");
		btnApagar.addActionListener(e -> {


		});

		Object[][] data = new Object[][] { {  "Nome", "Data-Hora", "Telefone", "Médico", "Especialidade" }, };
		Object[] columnNames = new String[] { "Nome", "Data-Hora", "Telefone", "Médico", "Especialidade" };
		
		table = new JTable();
		getContentPane().add(table, "cell 1 1 11 7,grow");
		table.setModel(new DefaultTableModel(data, columnNames));
		
	}
	
	protected void atualizarTabelaCarros(ArrayList<MedicoVO> medicos) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		Object novaLinha[] = new Object[5];
		for(MedicoVO medicoVO: medicos){
			novaLinha[0] = medicoVO.getCliente().getNome();
			novaLinha[1] = medicoVO.getCliente().getHoraConsulta();
			novaLinha[2] = medicoVO.getCliente().getCpf();
			novaLinha[3] = medicoVO.getCliente().getTelefone();
			novaLinha[4] = medicoVO.getNome();
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
