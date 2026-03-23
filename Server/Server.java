import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {


    public static void main(String[] args) {
   	 
   	 System.out.println("Detta ar Server-programmet.");
   	 
   	 try {
   		 ServerSocket server = new ServerSocket(34567);
   		 
   		 System.out.println("Vantar pa att en klient ska ansluta...");
   		 Socket anslutning = server.accept();
   		 
   		 System.out.println("Nu anslot en klient!");
   		 System.out.println("Klienten anslot fran adress: " + anslutning.getInetAddress());
   		 
   		 //Las vad klienten skickar
   		 DataInputStream input = new DataInputStream(anslutning.getInputStream());
   		 System.out.println("Klienten skickade siffran " + input.readInt());
   		 
   		 //stang ner anslutningen
   		 input.close();
   		 anslutning.close();
   		 server.close();
   		 
   	 } catch (Exception e) {
   		 System.out.println("Nagot gick fel: " + e.getMessage());
   	 }


   	 System.out.println("Nu avslutas Server-programmet.");
    }


}
