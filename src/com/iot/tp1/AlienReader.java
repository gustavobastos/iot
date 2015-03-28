package com.iot.tp1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.alien.enterpriseRFID.reader.AlienClass1Reader;
import com.alien.enterpriseRFID.reader.AlienReaderException;
import com.alien.enterpriseRFID.tags.Tag;

public class AlienReader {

	public static JLabel tagsInfoLabel = new JLabel("");
	/**
	 * Constructor
	 */
	public AlienReader() throws AlienReaderException {

		AlienClass1Reader reader = new AlienClass1Reader();

		// To connect to a networked reader instead, use the following:

		reader.setConnection("150.164.9.35", 23);
		reader.setUsername("alien");
		reader.setPassword("password");

		// Open a connection to the reader
		reader.open();
		System.err.println("Reader info:" + reader.getInfo());

		// Ask the reader to read tags and print them
		Tag tagList[] = reader.getTagList();
		if (tagList == null) {
			System.out.println("No Tags Found");
		} else {
			System.out.println("Tag(s) found:");
			for (int i = 0; i < tagList.length; i++) {
				Tag tag = tagList[i];
				System.out.println("ID:" + tag.getTagID() + ", Discovered:"
						+ tag.getDiscoverTime() + ", Last Seen:"
						+ tag.getRenewTime() + ", Antenna:" + tag.getAntenna()
						+ ", Reads:" + tag.getRenewCount());
			}
		}

		// Close the connection
		reader.close();
	}
	

	

	/**
	 * Main
	 */
	public static final void main(String args[]) {

		try {
			AlienReader reader = new AlienReader();
		} catch (AlienReaderException e) {
			System.err.println("Deu merda");
			e.printStackTrace();
		}
		
		JFrame frame = new JFrame("TP IoT - RFID (2015/1)");
		frame.setVisible(true);
		frame.setSize(512,512);
		frame.setLayout(new GridLayout(0, 2));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		JButton button1 = new JButton("Read Rate");
		panel.add(button1);
		button1.addActionListener(new Action1());

		JButton button2 = new JButton("Success Rate");
		panel.add(button2);
		button2.addActionListener(new Action2());
		
		JLabel readerInfoLabel = new JLabel("Reader info labelAlien Reader Class 1",JLabel.CENTER);
		readerInfoLabel.setVisible(true);
		readerInfoLabel.setSize(512, 40);
		panel.add(readerInfoLabel);
		
		panel.add(tagsInfoLabel);
	}

	static class Action1 implements ActionListener {        
		public void actionPerformed (ActionEvent e) {
			tagsInfoLabel.setText("");
			tagsInfoLabel.setText("Looking for tags... read rate");
			readRate();
		}
		
		/**
		 * 
		 * Quantidade de leituras que a antena consegue realizar sobre uma etiqueta durante uma unidade de tempo.
		 * Deve ser expressa na razão quantidade de leituras / segundo
		 * 
		 */
		private void readRate() {

		}
	}
	
	static class Action2 implements ActionListener {        
		public void actionPerformed (ActionEvent e) {     
			tagsInfoLabel.setText("");
			tagsInfoLabel.setText("Looking for tags... success rate");
			successRate();
		}
		
		/**
		 * 
		 * Porcentagem de leituras bem sucedidas. É calculada pela divisão da quantidade de leituras bem sucedidas pelo total de tentativas de leitura de uma etiqueta.
		 * Deve ser expressa como uma porcentagem
		 * 
		 */
		private void successRate() {
			
		}
	}   
}

