package examen.pr.pkg3;

/**
 *
 * @author ADVANCE
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.ParseException;
import java.util.Scanner;


public class Cliente {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nombre:");
        String nombre = sc.nextLine();
        System.out.println("Apellidos:");
        String apellido = sc.nextLine();
        System.out.println("Fecha de Nacimiento:");
        String fecha = sc.nextLine();
        
        Persona persona1 = new Persona(nombre, apellido, fecha);
        
        System.out.println(persona1.MensajeCliente());
        
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Socket socket;
        
        byte[] mensaje_bytes = new byte[256];
        
        try {
            socket = new Socket("127.0.0.1",4200);
            
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            out.writeUTF(persona1.MensajeParaElServidor());
            

            out.close();
            socket.close();
         }catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
         }
        
    }
}
