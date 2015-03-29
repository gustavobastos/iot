package tp1;

import com.alien.enterpriseRFID.reader.*;
import com.alien.enterpriseRFID.tags.*;
import com.alien.enterpriseRFID.notify.Message;
import com.alien.enterpriseRFID.notify.*;



import java.net.InetAddress;

public class listen implements MessageListener {

	public listen() throws Exception {

		
		


		AlienClass1Reader reader = new AlienClass1Reader();
		reader.setConnection("150.164.9.35", 23);
		reader.open();
		System.out.println("Configuring Reader");


		reader.setNotifyAddress("187.20.205.43:5000");
		reader.setNotifyFormat(AlienClass1Reader.XML_FORMAT); // Make sure service can decode it.
		reader.setNotifyTrigger("TrueFalse"); // Notify whether there's a tag or not
		reader.setNotifyMode(AlienClass1Reader.ON);

		reader.autoModeReset();
		reader.setAutoStopTimer(1000); // Read for 1 seconds
		reader.setAutoMode(AlienClass1Reader.ON);
		

		Thread.sleep(10000);
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

	public static final void main(String args[]){
		try {
			new listen();
		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		}

	}
} 
