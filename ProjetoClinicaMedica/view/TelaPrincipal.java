package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import model.vo.Medico;
import net.miginfocom.swing.MigLayout;
import view.cliente.PainelListagemCliente;
import view.cliente.TelaInternaAtualizarCliente;
import view.cliente.TelaInternaCadastroCliente;
import view.cliente.TelaInternaRelatorioCliente;

public class TelaPrincipal extends JFrame {

	private JDesktopPane desktopPane;
	private TelaInternaCadastroCliente janelinhaCadastroCliente = new TelaInternaCadastroCliente();
	private TelaInternaAtualizarCliente janelinhaAtualizarCliente = new TelaInternaAtualizarCliente();
	private PainelListagemCliente painelListagemCliente = new PainelListagemCliente();
	private TelaInternaRelatorioCliente janelinhaRelatorioCliente = new TelaInternaRelatorioCliente();
	private Medico medico;

	private ArrayList<Component> componentesDaTela = new ArrayList<Component>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.setExtendedState(Frame.MAXIMIZED_BOTH);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal() {
		setTitle("Tela de Administrador");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 412);
		initialize();
	}

	public void fecharJanelinha(JInternalFrame janelinha) {
		componentesDaTela.remove(janelinha);
	}

	private void initialize() {

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCliente = new JMenu("Pessoa");
		mnCliente.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/src/icones/icons8-gestão-de-cliente.png")));
		menuBar.add(mnCliente);

		JMenuItem jmiCadastrarCliente = new JMenuItem("Cadastrar");
		jmiCadastrarCliente.setIcon(
				new ImageIcon(TelaPrincipal.class.getResource("/src/icones/icons8-adicionar-usuário-masculino.png")));
		jmiCadastrarCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		jmiCadastrarCliente.addActionListener(e -> {
			adicionarInternalFrame(janelinhaCadastroCliente);
		});
		mnCliente.add(jmiCadastrarCliente);

		JMenuItem jmiAtualizarCliente = new JMenuItem("Atualizar");
		jmiAtualizarCliente.setIcon(
				new ImageIcon(TelaPrincipal.class.getResource("/src/icones/icons8-adicionar-ao-banco-de-dados.png")));
		jmiAtualizarCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		jmiAtualizarCliente.addActionListener(e -> {
			adicionarInternalFrame(janelinhaAtualizarCliente);
		});
		mnCliente.add(jmiAtualizarCliente);

		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/src/icones/icons8-confiança.png")));
		mntmListar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mntmListar.addActionListener(e -> {
			adicionarPainel(painelListagemCliente);
		});
		mnCliente.add(mntmListar);

		JMenuItem jmiRelatorioCliente = new JMenuItem("Relatorio");
		jmiRelatorioCliente
				.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/src/icones/icons8-imprimir-arquivo.png")));
		jmiRelatorioCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));
		jmiRelatorioCliente.addActionListener(e -> {

			janelinhaRelatorioCliente = new TelaInternaRelatorioCliente();
			desktopPane.add(janelinhaRelatorioCliente);
			janelinhaRelatorioCliente.setVisible(true);
			janelinhaRelatorioCliente.show();

		});
		mnCliente.add(jmiRelatorioCliente);

		JMenu mnProduto = new JMenu("Produtos");
		mnProduto.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/src/icones/icons8-comprar.png")));
		menuBar.add(mnProduto);

		JMenuItem jmiCadastrarProduto = new JMenuItem("Cadastrar");
		jmiCadastrarProduto.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/src/icones/icons8-comprar.png")));
		jmiCadastrarProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.CTRL_MASK));
		jmiCadastrarProduto.addActionListener(e -> {

			JInternalFrame frameCadastrarProduto = new JInternalFrame();
			desktopPane.add(frameCadastrarProduto);
			frameCadastrarProduto.setVisible(true);
			frameCadastrarProduto.show();
		});
		mnProduto.add(jmiCadastrarProduto);

		JMenuItem jmiAtualizarProduto = new JMenuItem("Atualizar");
		jmiAtualizarProduto.setIcon(
				new ImageIcon(TelaPrincipal.class.getResource("/src/icones/icons8-adicionar-ao-banco-de-dados.png")));
		jmiAtualizarProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.CTRL_MASK));
		jmiAtualizarProduto.addActionListener(e -> {

			JInternalFrame frameAtualizarProduto = new JInternalFrame();
			desktopPane.add(frameAtualizarProduto);
			frameAtualizarProduto.setVisible(true);
			frameAtualizarProduto.show();

		});
		mnProduto.add(jmiAtualizarProduto);

		JMenuItem jmiListarProduto = new JMenuItem("Listar");
		jmiListarProduto.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/src/icones/icons8-confiança.png")));
		jmiListarProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.CTRL_MASK));
		jmiListarProduto.addActionListener(e -> {

			JInternalFrame frameListarProduto = new JInternalFrame();
			desktopPane.add(frameListarProduto);
			frameListarProduto.setVisible(true);
			frameListarProduto.show();

		});
		mnProduto.add(jmiListarProduto);

		JMenu mnFuncionario = new JMenu("Funcionarios");
		mnFuncionario.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/src/icones/icons8-fila.png")));
		menuBar.add(mnFuncionario);

		JMenuItem jmiCadastrarFuncionario = new JMenuItem("Cadastrar");
		jmiCadastrarFuncionario.setIcon(
				new ImageIcon(TelaPrincipal.class.getResource("/src/icones/icons8-adicionar-usuário-masculino.png")));
		jmiCadastrarFuncionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.SHIFT_MASK));
		jmiCadastrarFuncionario.addActionListener(e -> {

			JInternalFrame frameCadastrarFuncionarios = new JInternalFrame();
			desktopPane.add(frameCadastrarFuncionarios);
			frameCadastrarFuncionarios.setVisible(true);
			frameCadastrarFuncionarios.show();

		});
		mnFuncionario.add(jmiCadastrarFuncionario);

		JMenuItem jmiAtualizarFuncionario = new JMenuItem("Atualizar");
		jmiAtualizarFuncionario.setIcon(
				new ImageIcon(TelaPrincipal.class.getResource("/src/icones/icons8-adicionar-ao-banco-de-dados.png")));
		jmiAtualizarFuncionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.SHIFT_MASK));
		jmiAtualizarFuncionario.addActionListener(e -> {

			JInternalFrame frameAtualizarFuncionario = new JInternalFrame();
			desktopPane.add(frameAtualizarFuncionario);
			frameAtualizarFuncionario.setVisible(true);
			frameAtualizarFuncionario.show();

		});
		mnFuncionario.add(jmiAtualizarFuncionario);

		JMenuItem jmiListarFuncionario = new JMenuItem("Listar");
		jmiListarFuncionario
				.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/src/icones/icons8-confiança.png")));
		jmiListarFuncionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.SHIFT_MASK));
		jmiListarFuncionario.addActionListener(e -> {

			JInternalFrame frameListarFuncionario = new JInternalFrame();
			desktopPane.add(frameListarFuncionario);
			frameListarFuncionario.setVisible(true);
			frameListarFuncionario.show();

		});
		mnFuncionario.add(jmiListarFuncionario);

		JMenuItem jmiSobre = new JMenuItem("Sobre");
		jmiSobre.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/src/icones/icons8-livro-de-física.png")));
		jmiSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		jmiSobre.addActionListener(e -> {

		});
		menuBar.add(jmiSobre);

		JMenu mnData = new JMenu("Data");
		menuBar.add(mnData);

		// TODO testar outros layouts
		getContentPane().setLayout(null);

		desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1560, 294);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		desktopPane.setBounds(10, 10, screenSize.width - 40, screenSize.height - 150);

		setContentPane(desktopPane);
		desktopPane.setLayout(new MigLayout("", "[grow,fill]", "[grow,fill]"));
	}

	private void adicionarPainel(JInternalFrame janelinha) {

		// TODO continuar
		if (janelinha == null) {
			painelListagemCliente = new PainelListagemCliente();
			getContentPane().add(painelListagemCliente);
			painelListagemCliente.setVisible(true);
			painelListagemCliente.show();

			painelListagemCliente.getBtnFechar().addActionListener(evt -> {
				getContentPane().remove(painelListagemCliente);
				painelListagemCliente = null;
				this.repaint();
			});
		} else {
			painelListagemCliente.setVisible(true);
		}
	}

	private void adicionarInternalFrame(JInternalFrame janelinha) {
		if (!componentesDaTela.contains(janelinha)) {
			desktopPane.add(janelinha);
			componentesDaTela.add(janelinha);
			janelinha.show();
		}

		janelinha.addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent evt) {
				fecharJanelinha(evt.getInternalFrame());
			}
		});
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
}