package view.principais;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.UIManager;

import view.cliente.TelaInternaAtualizarCliente;
import view.cliente.TelaInternaCadastroCliente;
import view.normal.TelaInternaAgendaMedico;
import view.normal.TelaInternaListarMedicos;

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
		new JInternalFrame().setClosable(true);
		

		initialize();
	}

	private void initialize() {

		JMenuBar menuBar = new JMenuBar();
		getContentPane().add(menuBar, BorderLayout.NORTH);

		JMenu mnMedico = new JMenu("Medico");
		mnMedico.setIcon(new ImageIcon(TelaPadrao.class.getResource("/icones/icons8-сharlie-сhaplin.png")));
		menuBar.add(mnMedico);

		JMenuItem mntmCadastrarAgenda = new JMenuItem("Cadastrar Agenda");
		mntmCadastrarAgenda.setIcon(new ImageIcon(TelaPadrao.class.getResource("/icones/icons8-calendário-48.png")));
		mntmCadastrarAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaInternaAgendaMedico agendaMedico = new TelaInternaAgendaMedico();
				getContentPane().add(agendaMedico);
				agendaMedico.setVisible(true);
				agendaMedico.show();

			}
		});
		mnMedico.add(mntmCadastrarAgenda);

		JMenuItem mntmMedicosAtivos = new JMenuItem("Medicos Ativos");
		mntmMedicosAtivos.setIcon(new ImageIcon(TelaPadrao.class.getResource("/icones/icons8-treinamento.png")));
		mntmMedicosAtivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaInternaListarMedicos listarMedico = new TelaInternaListarMedicos();
				getContentPane().add(listarMedico);
				listarMedico.setVisible(true);
				listarMedico.show();

			}
		});
		mnMedico.add(mntmMedicosAtivos);

		JMenuItem mntmListarAgendas = new JMenuItem("Listar Agendas");
		mntmListarAgendas.setIcon(new ImageIcon(TelaPadrao.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));
		mnMedico.add(mntmListarAgendas);

		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setIcon(new ImageIcon(TelaPadrao.class.getResource("/icones/icons8-adicionar-usuário-masculino.png")));
		menuBar.add(mnCliente);

		JMenuItem mntmCadastrarDados = new JMenuItem("Cadastrar Dados");
		mntmCadastrarDados.setIcon(new ImageIcon(TelaPadrao.class.getResource("/icones/icons8-adicionar-usuário-masculino.png")));
		mnCliente.add(mntmCadastrarDados);
		mntmCadastrarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInternaCadastroCliente janelinhaCadastroCliente = new TelaInternaCadastroCliente();
				getContentPane().add(janelinhaCadastroCliente);
				janelinhaCadastroCliente.setVisible(true);
				janelinhaCadastroCliente.show();
				
			}
		});

		JMenuItem mntmAlterarDados = new JMenuItem("Alterar Dados");
		mntmAlterarDados.setIcon(new ImageIcon(TelaPadrao.class.getResource("/icones/icons8-adicionar-ao-banco-de-dados.png")));
		mnCliente.add(mntmAlterarDados);
		mntmAlterarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInternaAtualizarCliente janelinhaAtualizarCliente = new TelaInternaAtualizarCliente();
				getContentPane().add(janelinhaAtualizarCliente);
				janelinhaAtualizarCliente.setVisible(true);
				janelinhaAtualizarCliente.show();
				
			}
		});

		JMenuItem mntmCadastrarConsulta = new JMenuItem("Cadastrar Consulta");
		mnCliente.add(mntmCadastrarConsulta);

		JMenu mnProdutos = new JMenu("Produtos");
		mnProdutos.setIcon(new ImageIcon(TelaPadrao.class.getResource("/icones/icons8-comprar.png")));
		menuBar.add(mnProdutos);

		JMenuItem mntmListarProduto = new JMenuItem("Listar Produtos");
		mnProdutos.add(mntmListarProduto);
		mntmListarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JMenuItem mntmSoliciarProduto = new JMenuItem("Soliciar Produtos");
		mnProdutos.add(mntmSoliciarProduto);
		mntmSoliciarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});



	}
}
