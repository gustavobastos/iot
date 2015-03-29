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


	public Frame1() {
		initialize();
	}


	private void initialize() {
		frmLeitorDeRfid = new JFrame();
		frmLeitorDeRfid.setTitle("Leitor de RFID");
		frmLeitorDeRfid.setBounds(100, 100, 309, 216);
		frmLeitorDeRfid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLeitorDeRfid.getContentPane().setLayout(null);
		
		JButton btnManual = new JButton("Manual");
		btnManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				new reader();

			} catch (AlienReaderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		btnManual.setBackground(Color.LIGHT_GRAY);
		btnManual.setBounds(83, 36, 108, 23);
		frmLeitorDeRfid.getContentPane().add(btnManual);
		
		JButton btnAutonomo = new JButton("Aut\u00F4nomo");

		btnAutonomo.setBackground(Color.LIGHT_GRAY);
		btnAutonomo.setBounds(83, 140, 108, 23);
		frmLeitorDeRfid.getContentPane().add(btnAutonomo);
		
		JLabel lblSelecioneOModo = new JLabel("Selecione o modo de leitura:");
		lblSelecioneOModo.setFont(new Font("DialogInput", Font.BOLD, 12));
		lblSelecioneOModo.setBounds(30, 11, 241, 14);
		frmLeitorDeRfid.getContentPane().add(lblSelecioneOModo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 70, 273, 2);
		frmLeitorDeRfid.getContentPane().add(separator);
		
		textField = new JTextField();
		textField.setBounds(65, 81, 163, 20);
		frmLeitorDeRfid.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(65, 109, 54, 20);
		frmLeitorDeRfid.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblIpListen = new JLabel("IP - listen");
		lblIpListen.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblIpListen.setBounds(10, 84, 46, 14);
		frmLeitorDeRfid.getContentPane().add(lblIpListen);
		
		JLabel lblTempo = new JLabel("Tempo(s)");
		lblTempo.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblTempo.setBounds(10, 112, 46, 14);
		frmLeitorDeRfid.getContentPane().add(lblTempo);
		
		JLabel lblEx = new JLabel("ex: 127.0.0.1:23");
		lblEx.setBounds(140, 100, 88, 14);
		frmLeitorDeRfid.getContentPane().add(lblEx);
	
		btnAutonomo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				new listen(textField.getText(), textField_1.getText());
				new listener();
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			
			}
		});
	}
}
