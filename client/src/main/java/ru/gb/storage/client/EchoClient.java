package ru.gb.storage.client;

import java.io.*;
import java.net.Socket;

public class EchoClient {

    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
               clientSocket = new Socket("localhost", 9000);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                while (true) {
                    System.out.println("Вы что-то хотели сказать? Введите это здесь:");
                    String word = reader.readLine();
                    out.write(word + "\n");
                    out.flush();
                    String serverWord = in.readLine();
                    System.out.println(serverWord);
                }

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
