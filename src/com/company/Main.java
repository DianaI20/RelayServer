package com.company;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        Server n1 = new Server(5, "127.0.0.1", new BigInteger("1"), "Server");
        Client n2 = new Client(6, "127.0.0.2", "Node 1");
        Client n3 = new Client(7, "127.0.0.3", "Node 2");
        n1.addClient(n2);
        n1.addClient(n3);

int p = n1.getDatagramSocket().getPort();
        while(true){
            n1.sendDataToRandomClient();

        }

    }
}
