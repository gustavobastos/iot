package tp1;


import javax.swing.JOptionPane;

import com.alien.enterpriseRFID.reader.*;
import com.alien.enterpriseRFID.tags.*;
import com.alien.enterpriseRFID.*;

public class reader {

public  reader() throws AlienReaderException{
	
	AlienClass1Reader reader = new AlienClass1Reader();
	

	reader.setConnection("150.164.9.35", 23);
	reader.setUsername("alien");
	reader.setPassword("password");
	
	
	reader.open();
	
	Tag tagList[] = reader.getTagList();
	  if (tagList == null) {
	    System.out.println("No Tags Found");
	    JOptionPane.showMessageDialog(null, "Nenhuma tag encontrada!");
	  } else {
	    System.out.println("Tag(s) found:");
	    for (int i=0; i<tagList.length; i++) {
	      Tag tag = tagList[i];
	      System.out.println("ID:" + tag.getTagID() +
	                         ", Discovered:" + tag.getDiscoverTime() +
	                         ", Last Seen:" + tag.getRenewTime() +
	                         ", Antenna:" + tag.getAntenna() +
	                         ", Reads:" + tag.getRenewCount()
	                         );
	      JOptionPane.showMessageDialog(null, "ID: " + tag.getTagID()+"\n" +
                  "Discovered:" + tag.getDiscoverTime() +"\n" +
                  "Last Seen:" + tag.getRenewTime() +"\n" +
                  "Antenna:" + tag.getAntenna() +"\n" +
                  "Reads:" + tag.getRenewCount()
                  );
	    }
	  }
	  
	  reader.close();
	
}


	
	
public static final void main(String args[]){
	try {
	    new reader();
	  } catch(AlienReaderException e) {
	    System.out.println("Error: " + e.toString());
	  }
	}
}

