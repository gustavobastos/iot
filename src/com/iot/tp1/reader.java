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



public  reader(String IpR) throws AlienReaderException{

	
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
	
	Tag tagList[] = reader.getTagList();
	  if (tagList == null) {
	    textArea.append("Nenhuma tag encontrada!\n\n");
	  } else {
	    for (int i=0; i<tagList.length; i++) {
	      Tag tag = tagList[i];
	      textArea.append("ID: " + tag.getTagID()+"\n");
	    }
	    textArea.append("\n----------------------------------------------------\n");
	  }
	  
	  
	  reader.close();
	  
	  
	
}


	
	

}

