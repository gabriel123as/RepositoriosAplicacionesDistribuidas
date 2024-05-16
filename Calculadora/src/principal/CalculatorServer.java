/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer extends UnicastRemoteObject implements CalculatorInterface {
    public CalculatorServer() throws RemoteException {
        super();
    }

    public double add(double x, double y) throws RemoteException {
        return x + y;
    }

    public double subtract(double x, double y) throws RemoteException {
        return x - y;
    }

    public double multiply(double x, double y) throws RemoteException {
        return x * y;
    }

    public double divide(double x, double y) throws RemoteException {
        if (y == 0) {
            throw new RemoteException("Cannot divide by zero");
        }
        return x / y;
    }

    public static void main(String[] args) {
        try {
            CalculatorServer server = new CalculatorServer();
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("CalculatorService", server);
            System.out.println("Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
