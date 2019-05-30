package src.view.cliente;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

public class PainelListagemCliente extends JPanel {

	private JTextField txtNome;
	private JTextField txtCPF_CPNPJ;
	private JTextField txtDtNascimento;
	private JTable table;
	private JButton btnFechar;

	public PainelListagemCliente() {
		setBounds(100, 100, 450, 341);
		setLayout(new MigLayout("", "[81px][10px][166px][10px][106px][10px][191px]",
				"[24px][21px][33px][313px,grow,fill]"));

		JLabel lblNome = new JLabel("Nome:");
		add(lblNome, "cell 0 0,grow");

		txtNome = new JTextField();
		add(txtNome, "cell 2 0,grow");
		txtNome.setColumns(10);

		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ:");
		add(lblCpfcnpj, "cell 0 1,grow");

		txtCPF_CPNPJ = new JTextField();
		txtCPF_CPNPJ.setColumns(10);
		add(txtCPF_CPNPJ, "cell 2 1,grow");

		JLabel lblDtNascimento = new JLabel("Dt. Nascimento:");
		add(lblDtNascimento, "cell 4 0,grow");

		txtDtNascimento = new JTextField();
		txtDtNascimento.setColumns(10);
		add(txtDtNascimento, "cell 6 0,grow");

		Object[][] data = new Object[][] { { "#", "Nome", "CPF", "Email", "Telefone" }, };
		Object[] columnNames = new String[] { "#", "Nome", "CPF", "Email", "Telefone" };

		btnFechar = new JButton("Fechar");
		
		add(btnFechar, "cell 6 2,grow");

		table = new JTable();
		add(table, "cell 0 3 7 1,grow");
		table.setModel(new DefaultTableModel(data, columnNames));

		JButton btnPesquisar = new JButton("PESQUISAR");
		btnPesquisar.addActionListener(e -> {

		});
		add(btnPesquisar, "cell 0 2 5 1,grow");
	}

	public JButton getBtnFechar() {
		return btnFechar;
	}

	public void setBtnFechar(JButton btnFechar) {
		this.btnFechar = btnFechar;
	}

}
