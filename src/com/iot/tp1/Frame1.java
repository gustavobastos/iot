package tp1;

import java.awt.EventQueue;




import javax.swing.JFrame;
import javax.swing.JButton;

import com.alien.enterpriseRFID.reader.AlienReaderException;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Frame1 {

	private JFrame frmLeitorDeRfid;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frmLeitorDeRfid.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLeitorDeRfid = new JFrame();
		frmLeitorDeRfid.setTitle("Leitor de RFID");
		frmLeitorDeRfid.setBounds(100, 100, 310, 387);
		frmLeitorDeRfid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLeitorDeRfid.getContentPane().setLayout(null);

		JButton btnManual = new JButton("Ir");
		
		btnManual.setBackground(Color.LIGHT_GRAY);
		btnManual.setBounds(198, 115, 63, 23);
		frmLeitorDeRfid.getContentPane().add(btnManual);

		JButton btnAutonomo = new JButton("Ir");

		btnAutonomo.setBackground(Color.LIGHT_GRAY);
		btnAutonomo.setBounds(85, 296, 108, 23);
		frmLeitorDeRfid.getContentPane().add(btnAutonomo);

		JLabel lblSelecioneOModo = new JLabel("Modo de leitura MANUAL:");
		lblSelecioneOModo.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblSelecioneOModo.setBounds(10, 118, 241, 14);
		frmLeitorDeRfid.getContentPane().add(lblSelecioneOModo);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 155, 273, 2);
		frmLeitorDeRfid.getContentPane().add(separator);

		textField = new JTextField();
		textField.setBounds(85, 225, 163, 20);
		frmLeitorDeRfid.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(85, 253, 54, 20);
		frmLeitorDeRfid.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblIpListen = new JLabel("IP - listen");
		lblIpListen.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblIpListen.setBounds(30, 228, 46, 14);
		frmLeitorDeRfid.getContentPane().add(lblIpListen);

		JLabel lblTempo = new JLabel("Tempo(s)");
		lblTempo.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblTempo.setBounds(30, 256, 46, 14);
		frmLeitorDeRfid.getContentPane().add(lblTempo);

		JLabel lblEx = new JLabel("ex: 127.0.0.1:23");
		lblEx.setBounds(160, 244, 88, 14);
		frmLeitorDeRfid.getContentPane().add(lblEx);
		
		JLabel lblDigiteOEndereo = new JLabel("Digite o endere\u00E7o do leitor:");
		lblDigiteOEndereo.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblDigiteOEndereo.setBounds(10, 26, 241, 14);
		frmLeitorDeRfid.getContentPane().add(lblDigiteOEndereo);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 51, 163, 20);
		frmLeitorDeRfid.getContentPane().add(textField_2);
		
		JLabel label = new JLabel("ex: 127.0.0.1:23");
		label.setBounds(85, 71, 88, 14);
		frmLeitorDeRfid.getContentPane().add(label);
		
		JLabel lblModoDeLeitura = new JLabel("Modo de leitura AUT\u00D4NOMA:");
		lblModoDeLeitura.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblModoDeLeitura.setBounds(10, 188, 241, 14);
		frmLeitorDeRfid.getContentPane().add(lblModoDeLeitura);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 96, 273, 2);
		frmLeitorDeRfid.getContentPane().add(separator_1);

		btnManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new reader(textField_2.getText());

				} catch (AlienReaderException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		btnAutonomo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new listen(textField.getText(), textField_1.getText(), textField_2.getText());
					new listener(textField_1.getText());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}

	public static void maind(String[] args){
		new Frame1();

	}
}
