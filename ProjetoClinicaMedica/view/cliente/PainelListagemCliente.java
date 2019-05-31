package view.cliente;


import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class PainelListagemCliente extends JInternalFrame {

	private JTextField txtNome;
	private JTextField txtCPF_CPNPJ;
	private JTextField txtDtNascimento;
	private JTable table;
	private JButton btnFechar;
	private JMenuBar menuBar;
	private JMenuItem mntmCadastrarHorario;
	private JMenuItem mntmExcluirHorario;

	public PainelListagemCliente() {
		setBounds(100, 100, 450, 341);
		getContentPane().setLayout(new MigLayout("", "[81px][10px][166px][10px][106px][10px][191px]",
				"[24px][21px][33px][313px,grow,fill]"));

		JLabel lblNome = new JLabel("Nome:");
		getContentPane().add(lblNome, "cell 0 0,grow");

		txtNome = new JTextField();
		getContentPane().add(txtNome, "cell 2 0,grow");
		txtNome.setColumns(10);

		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ:");
		getContentPane().add(lblCpfcnpj, "cell 0 1,grow");

		txtCPF_CPNPJ = new JTextField();
		txtCPF_CPNPJ.setColumns(10);
		getContentPane().add(txtCPF_CPNPJ, "cell 2 1,grow");

		JLabel lblDtNascimento = new JLabel("Dt. Nascimento:");
		getContentPane().add(lblDtNascimento, "cell 4 0,grow");

		txtDtNascimento = new JTextField();
		txtDtNascimento.setColumns(10);
		getContentPane().add(txtDtNascimento, "cell 6 0,grow");

		Object[][] data = new Object[][] { { "#", "Nome", "CPF", "Email", "Telefone" }, };
		Object[] columnNames = new String[] { "#", "Nome", "CPF", "Email", "Telefone" };

		btnFechar = new JButton("Fechar");
		
		getContentPane().add(btnFechar, "cell 6 2,grow");

		table = new JTable();
		getContentPane().add(table, "cell 0 3 7 1,grow");
		table.setModel(new DefaultTableModel(data, columnNames));

		JButton btnPesquisar = new JButton("PESQUISAR");
		btnPesquisar.addActionListener(e -> {

		});
		getContentPane().add(btnPesquisar, "cell 0 2 5 1,grow");
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmCadastrarHorario = new JMenuItem("Cadastrar Horario");
		mntmCadastrarHorario.setIcon(new ImageIcon(PainelListagemCliente.class.getResource("/src/icones/icons8-hora-extra-48.png")));
		menuBar.add(mntmCadastrarHorario);
		
		mntmExcluirHorario = new JMenuItem("Excluir Horario");
		mntmExcluirHorario.setIcon(new ImageIcon(PainelListagemCliente.class.getResource("/src/icones/icons8-passado-16.png")));
		menuBar.add(mntmExcluirHorario);
	}

	public JButton getBtnFechar() {
		return btnFechar;
	}

	public void setBtnFechar(JButton btnFechar) {
		this.btnFechar = btnFechar;
	}

}
