package listener;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class listenerGUI {

	private JFrame frmListener;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listenerGUI window = new listenerGUI();
					window.frmListener.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public listenerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListener = new JFrame();
		frmListener.setTitle("Listener");
		frmListener.setBounds(100, 100, 325, 219);
		frmListener.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListener.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(76, 77, 37, 20);
		frmListener.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("IP");
		label.setBounds(41, 54, 18, 14);
		frmListener.getContentPane().add(label);
		
		JLabel lblTempos = new JLabel("tempo(s)");
		lblTempos.setBounds(20, 80, 52, 14);
		frmListener.getContentPane().add(lblTempos);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(76, 51, 154, 20);
		frmListener.getContentPane().add(textField_1);
		
		JButton btnIniciarListener = new JButton("Iniciar listener");
		btnIniciarListener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				new iniciarL(textField.getText(), textField_1.getText());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		btnIniciarListener.setBounds(100, 127, 130, 23);
		frmListener.getContentPane().add(btnIniciarListener);
	}
}
