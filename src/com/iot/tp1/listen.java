package tp1;

import com.alien.enterpriseRFID.reader.*;
import com.alien.enterpriseRFID.tags.*;
import com.alien.enterpriseRFID.notify.*;

import java.awt.Color;
import java.net.InetAddress;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class listen implements MessageListener {
	public int sucesso, falha;
	public ArrayList<String> lista;
	
	public void getReaders() {
	
	}
	
	public listen(String ipL, String tempo, String ipR) throws Exception {

		sucesso = 0;
		falha = 0;
		lista = new ArrayList<String>();

		
		String[] porta = ipL.split(":");
		MessageListenerService service = new MessageListenerService(Integer.parseInt(porta[1]));
		service.setMessageListener(this);
		service.startService();
		System.out.println("Listener iniciado!");
		
		
		AlienClass1Reader reader = new AlienClass1Reader();
		reader.setConnection(ipR);
		reader.setUsername("alien");
		reader.setPassword("password");
		
		reader.open();
		System.out.println("Configuring Reader");

		reader.setNotifyAddress(ipL);
		reader.setNotifyFormat(AlienClass1Reader.XML_FORMAT);
		reader.setNotifyTrigger("TrueFalse"); 
		reader.setNotifyMode(AlienClass1Reader.ON);

		reader.autoModeReset();
		reader.setAutoMode(AlienClass1Reader.ON);
		reader.close();

		Thread.sleep(Integer.parseInt(tempo)*1000);
		long antes = System.currentTimeMillis();
	

		service.stopService();
		long tempoT = System.currentTimeMillis() - antes;

		
		
		
		
		
		JTextArea textArea = new JTextArea(30,90);
		JScrollPane scroll = new JScrollPane(textArea);
		for(int i = 0; i < lista.size(); i++){
			textArea.append(lista.get(i));
		}


		textArea.append("Tentativas com Sucesso: "+sucesso+"\n");
		textArea.append("Tentativas sem Sucesso: "+falha+"\n");
		textArea.append("Taxa de sucesso: "+(double)(sucesso)/(sucesso+falha)+"%\n");
		textArea.append("Velocidade de leitura: "+(double)(sucesso+falha)/(tempoT)+" leituras por segundos");
		
		
		textArea.setVisible(true);
		textArea.setBorder(BorderFactory.createLineBorder(Color.gray));
		textArea.setLineWrap(true);
		textArea.setFocusable(true);

		JScrollPane scroller = new JScrollPane(textArea);
		JScrollBar bar = new JScrollBar();


		JFrame janela = new JFrame("Modo Autonômico");
		janela.add(scroller);
		janela.pack();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);


	
		
		System.out.println("\nResetting Reader");
		reader.open();
		reader.autoModeReset();
		reader.setNotifyMode(AlienClass1Reader.OFF);
		reader.close();
	}

	public void messageReceived(Message message){
		System.out.println("\nMessagem Recebida:");
		lista.add("\nMessagem recebida: \n");
		if (message.getTagCount() == 0) {
			System.out.println("(No Tags)\n");
			falha++;
			lista.add("No Tags\n");
		} else {
			lista.add("\n ---------------------------------- \n");
			for (int i = 0; i < message.getTagCount(); i++) {
				Tag tag = message.getTag(i);
				System.out.println(tag.toLongString());
				lista.add(tag.toLongString()+"\n");


			}
			sucesso++;
		}
		lista.add("\n ---------------------------------- \n");
	}


} 
