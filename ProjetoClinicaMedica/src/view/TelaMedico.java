package src.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;

import src.view.cliente.TelaInternaCadastroCliente;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;

public class TelaMedico extends JFrame{

	private JFrame frame;

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
		setBounds(100, 100, 712, 579);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initialize();
	}

	private void initialize() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar ");
		mntmCadastrar.setIcon(new ImageIcon(TelaMedico.class.getResource("/src/icones/icons8-adicionar-usuário-masculino.png")));
		mntmCadastrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmCadastrar.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "AAAAAAAAAAAAAAAAAAAAAAAAAA");
			TelaInternaCadastroCliente janelinhaCadastrar = new TelaInternaCadastroCliente();
			getContentPane().add(janelinhaCadastrar);
			janelinhaCadastrar.setVisible(true);
			janelinhaCadastrar.show();

		});
		menuBar.add(mntmCadastrar);
		
		JMenuItem mntmConsultarHorarios = new JMenuItem("Consultar Horarios");
		mntmConsultarHorarios.setIcon(new ImageIcon(TelaMedico.class.getResource("/src/icones/icons8-gerente-de-informações-do-cliente.png")));
		mntmConsultarHorarios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mntmConsultarHorarios.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "BBBBBBBBBBBBBBBBBBBBBBB");
		});
		menuBar.add(mntmConsultarHorarios);
		
		JMenuItem mntmConsultarProntuario = new JMenuItem("Consultar Prontuario");
		mntmConsultarProntuario.setIcon(new ImageIcon(TelaMedico.class.getResource("/src/icones/icons8-documento-regular.png")));
		mntmConsultarProntuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mntmConsultarProntuario.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "CCCCCCCCCCCCCCCCCCCCCCC");
		});
		menuBar.add(mntmConsultarProntuario);
		getContentPane().setLayout(new MigLayout("", "[grow,fill]", "[grow,fill]"));
		
		
		
	}
}
