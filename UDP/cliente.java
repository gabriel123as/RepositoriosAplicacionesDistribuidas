import java.io.*;
import java.net.*;

public class cliente {
    public static void main(String[] args) {
        // Definimos el host y el puerto
        String serverHost = "192.168.225.252";
        int serverPort = 8888;

        try {
            // Creamos un socket UDP
            DatagramSocket socket = new DatagramSocket();

            // Preparamos los datos a enviar
            String message = "Mensaje desde el cliente UDP";
            byte[] sendData = message.getBytes();

            // Creamos un paquete con los datos, la dirección IP y el puerto del servidor
            InetAddress serverAddress = InetAddress.getByName(serverHost);
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

            // Enviamos el paquete al servidor
            socket.send(sendPacket);

            // Preparamos un buffer para recibir la respuesta del servidor
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // Recibimos la respuesta del servidor
            socket.receive(receivePacket);
            String response = new String(receivePacket.getData());
            System.out.println("Respuesta del servidor: " + response.trim());

            // Cerramos el socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
