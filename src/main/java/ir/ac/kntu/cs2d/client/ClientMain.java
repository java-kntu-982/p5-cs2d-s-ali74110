package ir.ac.kntu.cs2d.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

    static Socket socket = null;

    public static void main(String[] args) {
        try {
            socket = new Socket("127.0.0.1",49152);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("problem creating client.");
        }
        System.out.println("client is connected.");

        /*this thread will handle messages received in client side*/
        Thread sendingThread = new Thread(()->{
            String sendingMessage="him: ";
            while (true){
                try {
                    sendingMessage="him: ";
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    sendingMessage += new Scanner(System.in).nextLine();
                    oos.writeObject(sendingMessage);
                    oos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        sendingThread.start();
    }

    private ClientMain() {

    }
}
