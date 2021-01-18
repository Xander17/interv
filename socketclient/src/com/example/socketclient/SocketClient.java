package com.example.socketclient;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
1. Создаем билдер статическим методом SocketClient.url(String url)
Если не указан порт, то используется дефолтный - 80 для http, 443 для https. Если протокол не указан, считаем, что http

2. Используя методы билдера можно добавить тело запроса, перезаписать все хедеры, либо добавить новые к уже записанным
Для отправки строки используется метод body(String body), а для отправки объекта body(Object body), объект при этом сериализуется в виде json
Content-Type устанавливается в этих методах автоматически, но ничто не мешает задать его вручную в хедере.
Все нужные для отправки запроса хедеры устанавливаются автоматически.

3. Выполняется запрос методами get() или post()
*/

public class SocketClient {

    private static final String LINE_SEPARATOR = "\r\n";
    private static final String REQUEST_LINE = "%s %s HTTP/1.1" + LINE_SEPARATOR +
            "%s" + LINE_SEPARATOR +
            LINE_SEPARATOR +
            "%s";

    private HttpMethod method;
    private String host;
    private String path;
    private int port;
    private String body;
    private Map<String, String> headers = new HashMap<>();

    private SocketClient() {
    }

    public static Builder url(String url) {
        SocketClient socketClient = new SocketClient();
        parseUrl(url, socketClient);
        return new Builder(socketClient);
    }

    private static void parseUrl(String url, SocketClient socketClient) {
        String[] res = url.split("://");
        String protocol;
        if (res.length == 1) {
            protocol = "http";
            url = res[0];
        } else if (res.length == 2) {
            protocol = res[0];
            url = res[1];
        } else {
            throw new IllegalArgumentException("Invalid url: " + url);
        }

        res = url.split("/", 2);
        if (res.length == 1) {
            socketClient.path = "/";
        } else {
            socketClient.path = "/" + res[1];
        }

        res = res[0].split(":");
        if (res.length == 1) {
            socketClient.host = res[0];
            if (protocol.equals("http")) {
                socketClient.port = 80;
            } else if (protocol.equals("https")) {
                socketClient.port = 443;
            } else {
                throw new IllegalArgumentException("Invalid protocol: " + protocol);
            }
        } else if (res.length == 2) {
            socketClient.host = res[0];
            socketClient.port = Integer.parseInt(res[1]);
        } else {
            throw new IllegalArgumentException("Invalid url: " + url);
        }
    }

    private String run() throws IOException {
        try (Socket socket = new Socket(host, port)) {
            String request = getRequestLine();
            System.out.println("send:\n" + request);
            send(socket, request);
            return read(socket);
        }
    }

    private String getRequestLine() {
        return String.format(REQUEST_LINE, method.name(), path, getHeadersBlock(), body);
    }

    private String getHeadersBlock() {
        return headers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    private void send(Socket socket, String body) throws IOException {
        OutputStream os = socket.getOutputStream();
        os.write(body.getBytes());
    }

    private String read(Socket socket) throws IOException {
        InputStream is = socket.getInputStream();
        return new String(is.readAllBytes());
    }

    public static class Builder {

        private static final String CONNECTION_CLOSE = "close";

        private SocketClient socketClient;
        private ObjectMapper objectMapper;

        public Builder(SocketClient socketClient) {
            this.socketClient = socketClient;
            this.objectMapper = new ObjectMapper()
                    .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        }

        public Builder body(String body) {
            socketClient.body = body;
            additionalHeaders(Headers.CONTENT_TYPE, ContentTypes.TEST_HTML.getName());
            additionalHeaders(Headers.CONTENT_LENGTH, String.valueOf(body.length()));
            return this;
        }

        public Builder body(Object body) throws JsonProcessingException {
            socketClient.body = objectMapper.writeValueAsString(body);
            additionalHeaders(Headers.CONTENT_TYPE, ContentTypes.JSON.getName());
            additionalHeaders(Headers.CONTENT_LENGTH, String.valueOf(socketClient.body.length()));
            return this;
        }

        public Builder headers(Map<String, String> headers) {
            socketClient.headers = headers;
            return this;
        }

        public Builder additionalHeaders(Map<String, String> headers) {
            socketClient.headers.putAll(headers);
            return this;
        }

        public Builder additionalHeaders(String name, String value) {
            socketClient.headers.put(name, value);
            return this;
        }

        public Builder additionalHeaders(Headers header, String value) {
            socketClient.headers.put(header.getName(), value);
            return this;
        }

        public String get() throws IOException {
            socketClient.method = HttpMethod.GET;
            socketClient.body = null;
            setup();
            return socketClient.run();
        }

        public String post() throws IOException {
            socketClient.method = HttpMethod.POST;
            setup();
            return socketClient.run();
        }

        private void setup() {
            addHost();
            addDefault();
        }

        private void addHost() {
            socketClient.headers.put(Headers.HOST.getName(), socketClient.host);
        }

        private void addDefault() {
            if (!socketClient.headers.containsKey(Headers.CONNECTION.getName())) {
                socketClient.headers.put(Headers.CONNECTION.getName(), CONNECTION_CLOSE);
            }
            if (socketClient.body == null && socketClient.method == HttpMethod.POST) {
                socketClient.body = "";
                additionalHeaders(Headers.CONTENT_TYPE, ContentTypes.TEST_HTML.getName());
                additionalHeaders(Headers.CONTENT_LENGTH, String.valueOf(0));
            }
        }
    }

    public enum Headers {
        HOST("Host"),
        CONNECTION("Connection"),
        CONTENT_TYPE("Content-Type"),
        CONTENT_LENGTH("Content-Length");

        private String name;

        Headers(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public enum ContentTypes {
        TEST_HTML("text/html"),
        JSON("application/json");

        private String name;

        ContentTypes(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private enum HttpMethod {
        GET,
        POST
    }
}
