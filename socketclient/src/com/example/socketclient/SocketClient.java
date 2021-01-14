package com.example.socketclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {

    public static final String GET_STRING = "GET %s HTTP/1.1\r\n" +
            "Host: %s\r\n" +
            "Connection: close\r\n" +
            "\r\n";
    public static final String POST_STRING = "POST %s HTTP/1.1\r\n" +
            "Host: %s\r\n" +
            "Content-Length: %d\r\n" +
            "Connection: close\r\n" +
            "\r\n" +
            "%s";

    public String get(String host, int port, String path) throws IOException {
        try (Socket socket = new Socket(host, port)) {
            String request = String.format(GET_STRING, path, host);
            System.out.println("send:\n" + request);
            send(socket, request);
            return read(socket);
        }
    }

    public String post(String host, int port, String path, String body) throws IOException {
        try (Socket socket = new Socket(host, port)) {
            String request = String.format(POST_STRING, path, host, body.length(), body);
            System.out.println("send:\n" + request);
            send(socket, request);
            return read(socket);
        }
    }

    private void send(Socket socket, String body) throws IOException {
        OutputStream os = socket.getOutputStream();
        os.write(body.getBytes());
    }

    private String read(Socket socket) throws IOException {
        InputStream is = socket.getInputStream();
        return new String(is.readAllBytes());
    }
}
