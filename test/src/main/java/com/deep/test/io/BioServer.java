package com.deep.test.io;

import java.io.IOException;
import java.net.ServerSocket;

public class BioServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.accept();

    }
}
