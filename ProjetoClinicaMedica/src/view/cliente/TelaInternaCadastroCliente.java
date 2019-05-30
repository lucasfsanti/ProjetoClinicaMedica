package src.view.cliente;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import net.miginfocom.swing.MigLayout;

public class TelaInternaCadastroCliente extends JInternalFrame {

	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JFormattedTextField ftfCPF;
	private JFormattedTextField ftfCNPJ;

	private MaskFormatter mascaraCpf;
	private MaskFormatter mascaraCnpj;
	private MaskFormatter mascaraData;
	private MaskFormatter mascaraTelefone;
	private JTextField txtBairroEndereco;
	private JTextField txtRuaEndereco;
	private JTextField txtNumeroEndereco;
	private JTextField txtComplementoEndereco;
	private JTextField txtEmail;
	private JTextField txtCidade;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInternaCadastroCliente window = new TelaInternaCadastroCliente();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInternaCadastroCliente() {
		setClosable(true);
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 527, 380);
		getContentPane().setLayout(new MigLayout("", "[61.00px][102px,grow][97px][130px,grow]", "[25.00,grow][13.00,grow][20px,grow][20px,grow][20.00,grow][13.00,grow][25.00,grow][13.00,grow][20px,grow][20px,grow][20px,grow][13.00,grow][25.00,grow][20px,grow][13.00][20px,grow]"));
		initialize();
	}

	private void initialize() {
		
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCnpj = new MaskFormatter("##.###.###/####-##");
			mascaraData = new MaskFormatter("##/##/####");
			mascaraTelefone = new MaskFormatter("(##)####-####");
		} catch (ParseException e) {
			System.out.println("Erro ao criar m�scaras. Causa: " + e.getMessage());
		}

		JLabel lblInformaesPessoais = new JLabel("Informa\u00E7\u00F5es Pessoais");
		lblInformaesPessoais.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(lblInformaesPessoais, "cell 0 0 4 1,alignx center,growy");

		JLabel lblNome = new JLabel("Nome:");
		getContentPane().add(lblNome, "cell 0 2,alignx left,aligny center");

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		getContentPane().add(lblSobrenome, "cell 2 2,alignx right,growy");

		JLabel lblCPF_CNPJ = new JLabel("CPF/CNPJ:");
		getContentPane().add(lblCPF_CNPJ, "cell 0 4,alignx left,aligny center");

		JLabel lblDataDeNacimento = new JLabel("Data de Nacimento:");
		getContentPane().add(lblDataDeNacimento, "cell 2 4,alignx right,aligny center");

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(lblEndereo, "cell 0 6 4 1,alignx center,growy");

		JLabel lblCidade = new JLabel("Cidade:");
		getContentPane().add(lblCidade, "cell 0 8,alignx left,aligny center");

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		getContentPane().add(txtCidade, "cell 1 8,growx");

		JLabel lblRua = new JLabel("Rua:");
		getContentPane().add(lblRua, "cell 2 8,alignx right,aligny center");

		txtRuaEndereco = new JTextField();
		getContentPane().add(txtRuaEndereco, "cell 3 8,growx,aligny top");
		txtRuaEndereco.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		getContentPane().add(lblBairro, "cell 0 9,alignx left,aligny center");


		txtBairroEndereco = new JTextField();
		getContentPane().add(txtBairroEndereco, "cell 1 9,growx,aligny top");
		txtBairroEndereco.setColumns(10);

		JLabel lblNumero = new JLabel("Numero:");
		getContentPane().add(lblNumero, "cell 2 9,alignx right,aligny center");

		JLabel lblComplemento = new JLabel("Complemento:");
		getContentPane().add(lblComplemento, "cell 0 10,alignx right,aligny center");

		txtComplementoEndereco = new JTextField();
		getContentPane().add(txtComplementoEndereco, "cell 1 10,growx,aligny top");
		txtComplementoEndereco.setColumns(10);

		JLabel lblContato = new JLabel("Contato");
		lblContato.setFont(new Font("Verdana", Font.PLAIN, 14));
		getContentPane().add(lblContato, "cell 0 12 4 1,alignx center,growy");

		JLabel lblNumeroTelefone = new JLabel("Telefone:");
		getContentPane().add(lblNumeroTelefone, "cell 0 13,alignx left,aligny center");

		JLabel lblEmail = new JLabel("E-Mail:");
		getContentPane().add(lblEmail, "cell 2 13,alignx right,aligny center");

		txtNome = new JTextField();
		getContentPane().add(txtNome, "cell 1 2,growx,aligny top");
		txtNome.setColumns(10);

		txtSobrenome = new JTextField();
		getContentPane().add(txtSobrenome, "cell 3 2,growx,aligny top");
		txtSobrenome.setColumns(10);

		txtNumeroEndereco = new JTextField();
		getContentPane().add(txtNumeroEndereco, "cell 3 9,growx,aligny top");
		txtNumeroEndereco.setColumns(10);

		txtEmail = new JTextField();
		getContentPane().add(txtEmail, "cell 3 13,growx,aligny top");
		txtEmail.setColumns(10);

		JRadioButton rbCNPJ = new JRadioButton("CPNJ");
		rbCNPJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selecionarCNPJ();
			}
		});
		JRadioButton rbCPF = new JRadioButton("CPF");
		rbCPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionarCPF();
			}
		});
		getContentPane().add(rbCNPJ, "cell 1 3,alignx center,aligny top");
		getContentPane().add(rbCPF, "cell 0 3,alignx right,aligny top");

		ButtonGroup group = new ButtonGroup();
		group.add(rbCNPJ);
		group.add(rbCPF);

		ftfCPF = new JFormattedTextField(mascaraCpf);
		getContentPane().add(ftfCPF, "cell 1 4,growx,aligny top");
		ftfCPF.setVisible(false);
		
		ftfCNPJ = new JFormattedTextField(mascaraCnpj);
		getContentPane().add(ftfCNPJ, "cell 1 4,growx,aligny top");
		ftfCNPJ.setVisible(false);

		JFormattedTextField ftfData = new JFormattedTextField(mascaraData);
		getContentPane().add(ftfData, "cell 3 4,growx,aligny top");

		JFormattedTextField ftfTelefone = new JFormattedTextField(mascaraTelefone);
		getContentPane().add(ftfTelefone, "cell 1 13,growx,aligny top");

		JButton btnCadastrar = new JButton("Cadastrar");
		getContentPane().add(btnCadastrar, "cell 1 15,grow");
		btnCadastrar.addActionListener(e -> {

		});

		JButton btnLimpar = new JButton("Limpar Campos");
		getContentPane().add(btnLimpar, "cell 3 15,grow");
		btnLimpar.addActionListener(e -> {
			
			// Info Pessoal
			txtNome.setText("");
			txtSobrenome.setText("");
			ftfCPF.setText("");
			ftfCNPJ.setText("");
			ftfCPF.setVisible(false);
			ftfCNPJ.setVisible(false);
			
			rbCPF.setSelected(false);
			rbCNPJ.setSelected(false);
			
			ftfData.setText("");
			// Endere�o
			txtCidade.setText("");
			txtBairroEndereco.setText("");
			txtRuaEndereco.setText("");
			txtNumeroEndereco.setText("");
			txtComplementoEndereco.setText("");
			// Contato
			ftfTelefone.setText("");
			txtEmail.setText("");
			
		});

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/aaaa");
			Date data = sdf.parse(ftfData.getText());
		} catch (ParseException e) {
			e.getMessage();
			System.out.println(e);
			System.out.println("2� Try/Catch. Causa: " + e.getMessage() );
		}
	}

	protected void selecionarCPF() {
		ftfCPF.setVisible(true);
		ftfCNPJ.setText("");
		ftfCNPJ.setVisible(false);
	}

	protected void selecionarCNPJ() {
		ftfCPF.setVisible(false);
		ftfCPF.setText("");
		ftfCNPJ.setVisible(true);
	}
}
