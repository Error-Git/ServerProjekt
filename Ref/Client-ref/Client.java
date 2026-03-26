import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Random;


public class Client {


    public static void main(String[] args) {
   	 System.out.println("Detta ar Klient-programmet.");
   	 Random rand = new Random();
   	 try {
   		 Socket klient = new Socket("wiljha.ntig.dev", 34567);
   		 System.out.println("Vi lyckades ansluta till servern.");
   		 
   		 //skicka siffermeddelande till klienten
   		 DataOutputStream output = new DataOutputStream(klient.getOutputStream());
   		 output.writeInt(rand.nextInt(64) + 1);
   		 
   		 //stang ner anslutningen
   		 output.close();
   		 klient.close();
   		 
   	 } catch (Exception e) {
   		 System.out.println("Kunde inte ansluta till servern: " + e.getMessage());


   	 }
   	 System.out.println("Nu avslutas Klient-programmet.");
    }


}
