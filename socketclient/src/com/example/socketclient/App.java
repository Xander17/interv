package com.example.socketclient;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        SocketClient socketClient = new SocketClient();

        String result = socketClient.get("localhost", 8080, "/get/1");
        System.out.println("result:\n:" + result);
        System.out.println("---");
        result = socketClient.post("localhost", 8080, "/post", "BODY");
        System.out.println("result:\n:" + result);
    }
}
