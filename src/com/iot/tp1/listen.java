package tp1;

import com.alien.enterpriseRFID.reader.*;
import com.alien.enterpriseRFID.tags.*;
import com.alien.enterpriseRFID.notify.Message;
import com.alien.enterpriseRFID.notify.*;



import java.net.InetAddress;

public class listen implements MessageListener {

	public listen(String ipL, String tempo, String ipR) throws Exception {

		
		


		AlienClass1Reader reader = new AlienClass1Reader();
		reader.setConnection(ipR);
		reader.open();
		System.out.println("Configuring Reader");


		reader.setNotifyAddress(ipL);
		reader.setNotifyFormat(AlienClass1Reader.XML_FORMAT);
		reader.setNotifyTrigger("TrueFalse"); 
		reader.setNotifyMode(AlienClass1Reader.ON);

		reader.autoModeReset();
		reader.setAutoMode(AlienClass1Reader.ON);
		

		Thread.sleep(Integer.parseInt(tempo)*1000);
		reader.close();	


		System.out.println("\nResetting Reader");
		reader.open();
		reader.autoModeReset();
		reader.setNotifyMode(AlienClass1Reader.OFF);
		reader.close();
		
		
	}

	public void messageReceived(Message message){
		System.out.println("\nMessage Received:");
		if (message.getTagCount() == 0) {
			System.out.println("(No Tags)");
		} else {
			for (int i = 0; i < message.getTagCount(); i++) {
				Tag tag = message.getTag(i);
				System.out.println(tag.toLongString());
			}
		}
	}


} 
