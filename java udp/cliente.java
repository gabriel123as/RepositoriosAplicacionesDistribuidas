import java.io.*;
import java.net.*;

public class cliente {
    public static void main(String[] args) {
        // Definimos el host y el puerto del servidor UDP al que nos conectaremos
        String serverHost = "192.168.219.205";
        int serverPort = 1021;

        try {
            // Creamos un socket UDP para el cliente
            DatagramSocket clientSocket = new DatagramSocket();

            // Definimos la dirección del servidor
            InetAddress serverAddress = InetAddress.getByName(serverHost);

            // Enviamos datos al servidor
            String message = "Hola desde el cliente UDP en Java";
            byte[] sendData = message.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            clientSocket.send(sendPacket);

            System.out.println("Mensaje enviado al servidor UDP en Java");

            // Esperamos la respuesta del servidor
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String response = new String(receivePacket.getData()).trim();
            System.out.println("Respuesta del servidor: " + response);

            // Cerramos el socket del cliente
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}