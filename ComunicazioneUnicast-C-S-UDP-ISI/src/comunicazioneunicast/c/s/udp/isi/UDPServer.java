/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicazioneunicast.c.s.udp.isi;
import java.net.*;
/**
 *
 * @author isibor
 */
public class UDPServer {
    public static void main(String args[]) {
DatagramSocket serverSocket = null;
try {
serverSocket = new DatagramSocket(9876);

byte[] receiveData = new byte[1024];
while (true) {
DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
serverSocket.receive(receivePacket);

String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
System.out.println("From Client: " + message);

InetAddress clientAddress = receivePacket.getAddress();
int clientPort = receivePacket.getPort();

    String response = "Hello, client!";
    byte[] sendData = response.getBytes();

    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
        e.printStackTrace();
            } finally {
                if (serverSocket != null) {
                        serverSocket.close();
                    }
            }
        }
    }

