import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileManager fileManager = new FileManager();
        fileManager.create("araba");
        fileManager.create("araba2");
        fileManager.create("araba3");

        fileManager.write("araba", "bu 4. yazıdır");
        fileManager.copyFile("araba2", "araba3");

        fileManager.read("araba");
        System.out.println("-----------------------------------------------------------");

        fileManager.read("araba2");
        fileManager.read("araba3");

        fileManager.updateFile("araba", "ucuz1", "ucuz");
        fileManager.read("araba");


    }
}
