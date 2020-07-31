package ir.ac.kntu.cs2d.server;
import ir.ac.kntu.cs2d.logic.play.logic.Game;
import ir.ac.kntu.cs2d.logic.play.logic.Soldier;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {

    static ServerSocket server = null;
    static Socket socket = null;
    static Game game;

    public static void main(String[] args) throws FileNotFoundException {
        game = new Game();
        controlData();
    }

    private static void controlData() {
        int i = 0 ;
//        while (true){
            try {
                server = new ServerSocket(50128);
                System.out.println("server accepting client.");
                socket = server.accept();
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("problem creating server.");
            }
            if (socket!=null){
                i++;
                System.out.println("client accepted.");
//                Thread receivingThread = new Thread(()->{
//                    while (true){
                Object sendingMessage ;
                try {
                    sendingMessage = game;
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//                            sendingMessage += new Scanner(System.in).nextLine();
                    oos.writeObject(sendingMessage);
                    oos.flush();
                    System.out.println("game sent.");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
//        }
    }
    public ServerMain() {

    }


}
