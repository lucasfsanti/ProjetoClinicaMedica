package src.view.cliente;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

public class TelaInternaAtualizarCliente extends JInternalFrame{

	private JTextField textField;
	private JTable tableClientes;
	private JButton btnApagar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInternaAtualizarCliente window = new TelaInternaAtualizarCliente();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInternaAtualizarCliente() {
		setClosable(true);
		setResizable(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 482, 403);
		getContentPane().setLayout(new MigLayout("", "[60.00px][grow][grow][79px]", "[29.00px][29.00][40.00][grow][fill]"));
		initialize();
	}

	private void initialize() {
		
		JLabel lblNome = new JLabel("Nome:");
		getContentPane().add(lblNome, "cell 0 0,alignx center,growy");
		
		JLabel lblCpf = new JLabel("CPF:");
		getContentPane().add(lblCpf, "cell 0 1,alignx center,growy");
		
		textField = new JTextField();
		getContentPane().add(textField, "cell 1 0 2 1,grow");
		textField.setColumns(10);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		getContentPane().add(formattedTextField, "cell 1 1 2 1,grow");
		
		JButton btnPesquisar01 = new JButton("Pesquisar");
		getContentPane().add(btnPesquisar01, "cell 3 0 1 2,grow");
		
		JButton btnSalvar = new JButton("Salvar Dados");
		getContentPane().add(btnSalvar, "cell 0 2 2 1,grow");
		
		JButton btnLimpar = new JButton("Limpar Campos");
		getContentPane().add(btnLimpar, "flowx,cell 2 2,grow");
		
		JButton btnPesquisarTodos = new JButton("Pesquisar Todos");
		getContentPane().add(btnPesquisarTodos, "cell 3 2,grow");
		
		Object[][] data = new Object[][] {{"#", "Nome", "CPF", "Email", "Telefone"},};
		Object[] columnNames = new String[] {"#", "Nome", "CPF", "Email", "Telefone"};
		
		tableClientes = new JTable();
		getContentPane().add(tableClientes, "cell 0 3 4 1,grow");
		tableClientes.setModel(new DefaultTableModel(data, columnNames));
		
		JCheckBox chkbApagarCliente = new JCheckBox("Apagar Clientes");
		chkbApagarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkbApagarCliente.isSelected()) {
					JOptionPane.showMessageDialog(null, "Aten��o, Cuidado ao apagar um Cliente!\nIsso pode gerar Problemas!");
					btnApagar.setEnabled(true);
				}
				
			}
		});
		getContentPane().add(chkbApagarCliente, "cell 1 4,grow");
		
		
		
		btnApagar = new JButton("APAGAR");
		btnApagar.addActionListener(e -> {
			//TODO Pegar a linha/coluna selecionada e alterar diretamente na tabela
			int[] id = tableClientes.getSelectedRows();
		});
		btnApagar.setEnabled(false);
		getContentPane().add(btnApagar, "cell 2 4,grow");
		
	}
	
	@Override
	public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }
	
	

}
