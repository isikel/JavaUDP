/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package comunicazioneunicast.c.s.udp.isi;
import java.net.*;
/**
 *
 * @author isibor
 */
public class UDPClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DatagramSocket clientSocket = null;
try {
clientSocket = new DatagramSocket();

InetAddress serverAddress = InetAddress.getByName("localhost");
int serverPort = 9876;

    String message = "Hello, server!";
    byte[] sendData = message.getBytes();

    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

    clientSocket.send(sendPacket);

    byte[] receiveData = new byte[1024];
    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

    clientSocket.receive(receivePacket);

    String modifiedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
    System.out.println("From Server: " + modifiedMessage);
        } catch (Exception e) {
        e.printStackTrace();
            } finally {
    if (clientSocket != null) {
        clientSocket.close();
                    }
                }
        }
    }
    
    

