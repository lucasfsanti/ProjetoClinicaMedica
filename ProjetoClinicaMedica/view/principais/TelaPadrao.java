package view.principais;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.UIManager;

import view.normal.TelaAgendaMedico;
import view.normal.TelaListarMedicos;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPadrao extends JFrame{

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPadrao window = new TelaPadrao();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPadrao() {
		setBounds(100, 100, 900, 719);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initialize();
	}

	private void initialize() {

		JMenuBar menuBar = new JMenuBar();
		getContentPane().add(menuBar, BorderLayout.NORTH);

		JMenu mnMedico = new JMenu("Medico");
		menuBar.add(mnMedico);

		JMenuItem mntmCadastrarAgenda = new JMenuItem("Cadastrar Agenda");
		mntmCadastrarAgenda.setIcon(new ImageIcon(TelaPadrao.class.getResource("/icones/icons8-calendário-48.png")));
		mntmCadastrarAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaAgendaMedico agendaMedico = new TelaAgendaMedico();
				getContentPane().add(agendaMedico);
				agendaMedico.setVisible(true);
				agendaMedico.show();

			}
		});
		mnMedico.add(mntmCadastrarAgenda);

		JMenuItem mntmMedicosAtivos = new JMenuItem("Medicos Ativos");
		mntmMedicosAtivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaListarMedicos listarMedico = new TelaListarMedicos();
				getContentPane().add(listarMedico);
				listarMedico.setVisible(true);
				listarMedico.show();

			}
		});
		mnMedico.add(mntmMedicosAtivos);

		JMenuItem mntmListarAgendas = new JMenuItem("Listar Agendas");
		mnMedico.add(mntmListarAgendas);

		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);

		JMenuItem mntmCadastrarDados = new JMenuItem("Cadastrar Dados");
		mntmCadastrarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnCliente.add(mntmCadastrarDados);

		JMenuItem mntmAlterarDados = new JMenuItem("Alterar Dados");
		mntmAlterarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnCliente.add(mntmAlterarDados);

		JMenuItem mntmCadastrarConsulta = new JMenuItem("Cadastrar Consulta");
		mnCliente.add(mntmCadastrarConsulta);

		JMenu mnProdutos = new JMenu("Produtos");
		menuBar.add(mnProdutos);

		JMenuItem mntmListarProduto = new JMenuItem("Listar Produtos");
		mntmListarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnProdutos.add(mntmListarProduto);

		JMenuItem mntmSoliciarProduto = new JMenuItem("Soliciar Produtos");
		mntmSoliciarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnProdutos.add(mntmSoliciarProduto);



	}
}
