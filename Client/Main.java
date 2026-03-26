import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // === VARS:
            // - Const:
                final String HOST = "wiljha.ntig.dev";
                final int PORT = 34567;

            // - Dynamic:
                boolean running = true;




   	    System.out.println("Client starting...");

        try {
   		 Socket client = new Socket(HOST, PORT);
   		 System.out.println("Succesfully established connection with: " + HOST + PORT);
   		 
         Scanner userInputs = new Scanner(System.in);
         DataOutputStream output = new DataOutputStream(client.getOutputStream());

         while (running) {
            System.out.println("Send a message (int):");
            int message = userInputs.nextInt();

            output.writeInt(message);
        
        
        }
        
        
        userInputs.close();
        client.close();

    } catch (Exception e) {

        System.out.println("Failed to established a connection: " + e.getMessage());

    }
    
    
    running = false;
    System.out.println("Client shutting down...");
}


}
