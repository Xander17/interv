package lesson3;

import lombok.SneakyThrows;

public class PingPong {

    public static void main(String[] args) {
        new PingPong();
    }

    public PingPong() {
        new Thread(() -> print("Ping!")).start();
        new Thread(() -> print("Pong!")).start();
    }

    @SneakyThrows
    private synchronized void print(String message) {
        while (true) {
            Thread.sleep(1000);
            System.out.println(message);
            this.notify();
            this.wait();
        }
    }

}


