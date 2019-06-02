package view.medico;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class TelaCadastrarProntuario extends JFrame {


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarProntuario window = new TelaCadastrarProntuario();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastrarProntuario() {
		setBounds(100, 100, 1027, 794);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize();
	}

	private void initialize() {

	
	//TODO fazer a tela;
	
	}

}
