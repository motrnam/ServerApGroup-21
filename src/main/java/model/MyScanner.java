package model;

import java.io.InputStream;
import java.util.EventListener;
import java.util.Scanner;

public class MyScanner implements EventListener{
    Scanner scanner;
    public MyScanner(InputStream stream){
        scanner = new Scanner(stream);
    }
}
