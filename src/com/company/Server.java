package com.company;

import java.math.BigInteger;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Server extends Node {

    private BigInteger data;
    private int noOfClients = 2;
    private List<Client> clients;

    public Server(int port, String ipAddress, BigInteger initialValue, String name) {
      super(port, ipAddress, name);
      this.data = initialValue;
      clients = new ArrayList<>();
    }

    private void incrementValue() {
        int counter = 100;
        while (counter != 0) {
            data.add(BigInteger.valueOf(1));
            counter--;
        }
    }

    // select a random client

    private Client selectClientForTransmission(){
        Random rand = new Random(); //instance of random class

        int int_random = rand.nextInt(noOfClients - 1) + noOfClients - 1;
        return clients.get(int_random);
    }

    public void addClient(Client node){
        clients.add(node);
    }

    public void sendDataToRandomClient(){
        this.incrementValue();
        Client selectedClient = selectClientForTransmission();
        System.out.println(this.getName() +": I've got a random client. Its name is:" + selectedClient.getName());
        InetAddress addr = selectedClient.getDatagramSocket().getInetAddress();
        byte[] dataBytes = this.data.toByteArray();
        System.out.println(selectedClient.getDatagramSocket().getPort());
        DatagramPacket dp = new DatagramPacket(dataBytes, dataBytes.length, addr,selectedClient.getDatagramSocket().getPort() );
    }
}
