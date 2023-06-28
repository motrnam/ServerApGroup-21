import Controller.FileController;
import Controller.Listener;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("server started!");
        FileController.start();
        Listener listener = new Listener();
        listener.runServer();
        listener.receive();
        FileController.finish();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        listener.printHashMap();
        System.out.println("server ended!");
    }
}
