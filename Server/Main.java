import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {

   


    public static void main(String[] args) {

        // === VARS:
        // - Const:
        final int PORT = 34567;

        // - Dynamic:
        boolean running = true;

        


   	 
   	    System.out.println("Server starting...");
   	 
   	 try {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started succesfully at port: " + PORT);

        System.out.println("Waiting for the first connection...");
        Socket connection_1 = server.accept();
        System.out.println("Connection 1 established succesfully from address: " + connection_1.getInetAddress());

        System.out.println("Waiting for the second connection...");
        Socket connection_2 = server.accept();
        System.out.println("Connection 1 established succesfully from address: " + connection_2.getInetAddress());

        while (running) {

            DataInputStream input1 = new DataInputStream(connection_1.getInputStream());
            DataInputStream input2 = new DataInputStream(connection_2.getInputStream());

            if (input1.readInt() != 0) {
                System.out.println("Connection one (1) sent: " + input1.readInt());
            }
            if (input2.readInt() != 0) {
                System.out.println("Connection two (2) sent: " + input2.readInt());
            }

        }


   		 connection_1.close();
         connection_2.close();
   		 server.close();
   		 
   	 } catch (Exception e) {
   		 System.out.println("Something went wrong: " + e.getMessage());
   	 }

     running = false;
   	 System.out.println("Server shutting down...");
    }


}
