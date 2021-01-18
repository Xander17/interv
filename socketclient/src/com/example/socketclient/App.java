package com.example.socketclient;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        String result = SocketClient.url("http://localhost:8080/get/1")
                .get();
        System.out.println("result:\n:" + result);

        System.out.println("---");

        result = SocketClient.url("localhost:8080/post")
                .body("BODY")
                .post();
        System.out.println("result:\n:" + result);

        System.out.println("---");

        result = SocketClient.url("localhost:8080")
                .body(new TestClass())
                .post();
        System.out.println("result:\n:" + result);
    }
}
