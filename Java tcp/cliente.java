import java.io.*;
import java.net.*;

public class cliente {
    public static void main(String[] args) {
        // Definimos el host y el puerto del servidor al que nos conectaremos
        String serverHost = "192.168.219.205";
        int serverPort = 1020;

        try {
            // Creamos un socket TCP para conectarnos al servidor
            Socket socket = new Socket(serverHost, serverPort);

            // Creamos los flujos de entrada y salida para comunicarnos con el servidor
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Enviamos un mensaje al servidor
            output.println("Hola desde el cliente TCP en Java");

            // Leemos la respuesta del servidor
            String response = input.readLine();
            System.out.println("Respuesta del servidor: " + response);

            // Cerramos los flujos y el socket
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}