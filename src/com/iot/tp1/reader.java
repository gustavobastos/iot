package tp1;


import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.alien.enterpriseRFID.reader.*;
import com.alien.enterpriseRFID.tags.*;
import com.alien.enterpriseRFID.*;

public class reader {

int sucesso, falha;

public  reader(String IpR, String repeticoes) throws AlienReaderException, InterruptedException{
	sucesso = 0;
	falha = 0;
	
	AlienClass1Reader reader = new AlienClass1Reader();
	

	reader.setConnection(IpR);
	reader.setUsername("alien");
	reader.setPassword("password");
	
	
	JTextArea textArea = new JTextArea(20,40);
	
	

	textArea.setVisible(true);
	textArea.setBorder(BorderFactory.createLineBorder(Color.gray));
	textArea.setLineWrap(true);
	textArea.setFocusable(true);

	JScrollPane scroller = new JScrollPane(textArea);
	JFrame janela = new JFrame("Modo Manual");
	janela.add(scroller);
	janela.pack();
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	janela.setVisible(true);



	textArea.setCaretPosition(textArea.getText().length());	
  
	
	reader.open();
	long antes = System.currentTimeMillis();  
	
	for(int j = 0; j < Integer.parseInt(repeticoes); j++ ){
	Tag tagList[] = reader.getTagList();
	  if (tagList == null) {
	    falha++;
		  textArea.append("Nenhuma tag encontrada!\n\n");
	  } else {
		  textArea.append("------------------------------------------------------------------\n");
		  for (int i=0; i<tagList.length; i++) {
	      Tag tag = tagList[i];
	      textArea.append("ID: " + tag.getTagID()+"\n");

	    }
		  Thread.sleep(1000);
		  sucesso++;
	    textArea.append("------------------------------------------------------------------\n");
	  }

	}
	  reader.close();
	  
	  double tempo = System.currentTimeMillis() - antes;
	  textArea.append("Leituras com sucesso: "+sucesso+"\n");
	  textArea.append("Leituras sem sucesso: "+falha+"\n");
	  textArea.append("velocidade de leitura: "+ (sucesso+falha)/((double)(System.currentTimeMillis() - antes)/1000)+" leituras por segundo\n");
	  textArea.append("Taxa de sucesso: "+(double)(sucesso)/(sucesso+falha)+"\n");
	
}


	
	

}

