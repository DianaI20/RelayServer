package com.company;

public class Client extends Node{
    private int receivedValue;

    public Client(int port, String ipAddress, String name) {
        super(port, ipAddress, name);
    }
}
