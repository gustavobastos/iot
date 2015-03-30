package tp1;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.alien.enterpriseRFID.tags.*;
import com.alien.enterpriseRFID.notify.*;




public class listener implements MessageListener {
	int sucesso,falha;
	ArrayList<String> lista;
	public listener(String tempo, String IpR) throws Exception {

		sucesso = 0;
		falha = 0;
		lista = new ArrayList<String>();
		String[] porta = IpR.split(":");
		MessageListenerService service = new MessageListenerService(Integer.parseInt(porta[1]));
		service.setMessageListener(this);
		service.startService();
		System.out.println("Listener iniciado!");

		long runTime = Integer.parseInt(tempo)*1000; // milliseconds
		long startTime = System.currentTimeMillis();
		do {
			Thread.sleep(Integer.parseInt(tempo)*1000);
		} while(service.isRunning() && (System.currentTimeMillis()-startTime) < runTime);





		JTextArea textArea = new JTextArea(250,90);
		JScrollPane scroll = new JScrollPane(textArea);
		for(int i = 0; i < lista.size(); i++){
			textArea.append(lista.get(i));

		}

		textArea.setVisible(true);
		textArea.setBorder(BorderFactory.createLineBorder(Color.gray));
		textArea.setLineWrap(true);
		textArea.setFocusable(true);

		JScrollPane scroller = new JScrollPane(textArea);
		JScrollBar bar = new JScrollBar();


		JFrame janela = new JFrame("Modo Autonomo");
		janela.add(scroller);
		janela.pack();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);



		textArea.setCaretPosition(textArea.getText().length());	


		JOptionPane.showMessageDialog(null, "Tentativas com Sucesso: "+sucesso);
		JOptionPane.showMessageDialog(null, "Tentativas sem Sucesso: "+falha);
		JOptionPane.showMessageDialog(null, "Taxa de sucesso: "+(double)(sucesso)/(sucesso+falha)+"%");
		JOptionPane.showMessageDialog(null, "Velocidade de leitura: "+(double)(sucesso+falha)/(Integer.parseInt(tempo))+" tags por segundos");
		System.out.println("Tentativas COM Sucesso: " + 
				sucesso);
		System.out.println("Tentativas SEM Sucesso: " + 
				falha);


	}

	public void messageReceived(Message message){
		System.out.println("\nMessagem Recebida:");
		lista.add("\nMessagem recebida: \n");
		if (message.getTagCount() == 0) {
			System.out.println("(No Tags)\n");
			falha++;
			lista.add("No Tags\n");
		} else {
			sucesso++;
			for (int i = 0; i < message.getTagCount(); i++) {
				Tag tag = message.getTag(i);
				System.out.println(tag.toLongString());
				lista.add(tag.toLongString()+"\n");


			}

		}
		lista.add("\n ---------------------------------- \n");
	}


} 
