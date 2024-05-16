/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.rmi.Naming;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            CalculatorInterface calculator = (CalculatorInterface) Naming.lookup("//192.168.217.76/CalculatorService");

            double x = 18;
            double y = 7;
            
            System.out.println("Suma: "+x+" + "+y+" = "+ calculator.add(x, y));
            System.out.println("Resta: "+x+" - "+y+" = "+ calculator.subtract(x, y));
            System.out.println("Multiplicacion: "+x+" * "+y+" = "+ calculator.multiply(x, y));
            System.out.println("Divicion: "+x+" / "+y+" = "+ calculator.divide(x, y));
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
