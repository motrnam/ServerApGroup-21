package Controller;

import model.User;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Listener {
    private Thread acceptThread,thisThread;
    private Thread registerThread;
    private final ServerSocket serverSocket,registerSocket;
    private final ArrayList<Socket> registerSockets = new ArrayList<>();
    private final HashMap<Socket, User> userSocketHashMap = new HashMap<>();
    private final HashMap<Scanner,User> scannerUserHashMap = new HashMap<>();

    {
        try {
            serverSocket = new ServerSocket(2022);
            registerSocket = new ServerSocket(2023);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void runServer() throws Exception {
        acceptThread = new Thread(() -> {
            while (true){
                try {
                    Socket socket = serverSocket.accept();
                    InputStream socketInputStream = socket.getInputStream();
                    Scanner scanner = new Scanner(socketInputStream);
                    scannerUserHashMap.put(scanner,null);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        acceptThread.start();//start this
    }

    public synchronized void receive(){
        thisThread = new Thread(() -> {
            while (true){
                for (Scanner scanner: scannerUserHashMap.keySet()) {
                    if (scanner.hasNext())
                        System.out.println(scanner.next());
                }

            }
        });
        thisThread.start();
    }

    public void runServerForRegister(){
        acceptThread = new Thread(() -> {

        });
        acceptThread.start();
    }

    public void printHashMap(){
        System.out.println(scannerUserHashMap);
    }

}
