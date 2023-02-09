package ru.netology.javacore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientTest {
    private static final String ip = "localhost";
    private static final int PORT = 8989;

    public static void main(String[] args) throws IOException {
        try (
                Socket clientSoket = new Socket(ip, PORT)
                ){
            PrintWriter out = new PrintWriter(clientSoket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSoket.getInputStream()));
            out.print("{ \"type\": \"REMOVE\", \"task\": \"fitness\" }");
            System.out.println(in.readLine());
        }
    }
}
