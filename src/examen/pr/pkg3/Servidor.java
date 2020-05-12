package examen.pr.pkg3;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {

  
    public static void main(String[] args) {
        ServerSocket socket;
     
     boolean fin = false;
     try {
         
        socket = new ServerSocket(4200);
        
        Socket socket_cli = socket.accept();

        DataInputStream in =new DataInputStream(socket_cli.getInputStream());

        String mensaje ="";
            
        mensaje = in.readUTF();

        System.out.println("Información del Cliente: "+mensaje);

        socket.close();
     }

     catch (Exception e) {
        System.err.println(e.getMessage());
        System.exit(1);
     }
    }
    
}
