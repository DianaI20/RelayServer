package com.company;

import java.io.IOException;
import java.net.*;

public class Node {

    private DatagramSocket datagramSocket;
    private String name;
    public Node() {

    }

    public Node(int port, String ipAddress, String name) {
        try {
            this.name = name;
            this.datagramSocket = new DatagramSocket();
            datagramSocket.connect( InetAddress.getByName(ipAddress), port);
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("Socket wrong");
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("Unknown host");
        }
    }

    public DatagramSocket getDatagramSocket() {
        return datagramSocket;
    }

    public void setDatagramSocket(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    public void sendData(DatagramPacket dp){

        try {
            datagramSocket.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("There was an error sending the package");
        }
    }
    public DatagramPacket receiveData(byte[] buf, int length){
        System.out.println(this.name + ": I received a package...");
        try {
            DatagramPacket dp = new DatagramPacket(buf, length);
            datagramSocket.receive(dp);
            int number = dp.getData()[0];
            System.out.println(this.name + ": Data received: " + number);
            System.out.println(dp.getData());
            return  dp;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("There was an error receiving the package");
        }
        System.out.println(this.name + ": Data returned: " );


        return  null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
