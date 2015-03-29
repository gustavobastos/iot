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

public class Frame1 {

	private JFrame frmLeitorDeRfid;

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
		frmLeitorDeRfid.setBounds(100, 100, 271, 173);
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
		btnManual.setBounds(62, 49, 108, 23);
		frmLeitorDeRfid.getContentPane().add(btnManual);
		
		JButton btnAutonomo = new JButton("Aut\u00F4nomo");
		btnAutonomo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				new listen();
				new listener();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		});
		btnAutonomo.setBackground(Color.LIGHT_GRAY);
		btnAutonomo.setBounds(62, 83, 108, 23);
		frmLeitorDeRfid.getContentPane().add(btnAutonomo);
		
		JLabel lblSelecioneOModo = new JLabel("Selecione o modo de leitura:");
		lblSelecioneOModo.setFont(new Font("DialogInput", Font.PLAIN, 12));
		lblSelecioneOModo.setBounds(30, 11, 241, 14);
		frmLeitorDeRfid.getContentPane().add(lblSelecioneOModo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 235, 2);
		frmLeitorDeRfid.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 121, 235, 2);
		frmLeitorDeRfid.getContentPane().add(separator_1);
	}
}
